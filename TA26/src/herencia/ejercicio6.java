package herencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pelicula {
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;

    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }
}

class Espectador {
    private String nombre;
    private int edad;
    private double dinero;

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }
}

class Asiento {
    private char fila;
    private int columna;
    private boolean ocupado;

    public Asiento(char fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
    }

    public char getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }
}

class Cine {
    private Pelicula peliculaActual;
    private double precioEntrada;
    private Asiento[][] asientos;

    public Cine(Pelicula peliculaActual, double precioEntrada, int filas, int columnas) {
        this.peliculaActual = peliculaActual;
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento((char) ('A' + i), j + 1);
            }
        }
    }
    
    public void mostrarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                char fila = asientos[i][j].getFila();
                int columna = asientos[i][j].getColumna();
                char estado = asientos[i][j].estaOcupado() ? 'X' : 'O';
                System.out.print("(" + fila + columna + ":" + estado + ") ");
            }
            System.out.println();
        }
    }

    public boolean sentarEspectador(Espectador espectador) {
        if (espectador.getEdad() < peliculaActual.getEdadMinima() || espectador.getDinero() < precioEntrada) {
            return false;
        }

        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (!asientos[i][j].estaOcupado()) {
                    asientos[i][j].ocupar();
                    return true;
                }
            }
        }

        return false;
        
        
    }
}

public class ejercicio6 {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Pelicula A", 120, 12, "Director A");
        Cine cine = new Cine(pelicula, 10.0, 8, 9);

        List<Espectador> espectadores = generarEspectadores(50);
        for (Espectador espectador : espectadores) {
            boolean sentado = cine.sentarEspectador(espectador);
            if (sentado) {
                System.out.println(espectador.getNombre() + " ha sido sentado en el cine.");
            } else {
                System.out.println(espectador.getNombre() + " no pudo ser sentado en el cine.");
            }
        }
        
        cine.mostrarAsientos();
    }

    private static List<Espectador> generarEspectadores(int cantidad) {
        List<Espectador> espectadores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Espectador" + i;
            int edad = random.nextInt(40) + 10; 
            double dinero = random.nextDouble() * 50.0; 
            espectadores.add(new Espectador(nombre, edad, dinero));
        }
        return espectadores;
    }
}
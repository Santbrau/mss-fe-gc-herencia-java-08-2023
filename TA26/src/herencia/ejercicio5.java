package herencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Persona {
    private String nombre;
    private int edad;
    private char sexo;

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }
}

class Estudiante extends Persona {
    private double calificacion;

    public Estudiante(String nombre, int edad, char sexo, double calificacion) {
        super(nombre, edad, sexo);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean haceNovillos() {
        return Math.random() < 0.5;
    }
}

class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, int edad, char sexo, String materia) {
        super(nombre, edad, sexo);
        this.materia = materia;
    }

    public boolean estaDisponible() {
        return Math.random() >= 0.2;
    }

    public String getMateria() {
        return materia;
    }
}

class Aula {
    private int identificador;
    private int capacidadMaxima;
    private String materiaDestinada;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Aula(int identificador, int capacidadMaxima, String materiaDestinada) {
        this.identificador = identificador;
        this.capacidadMaxima = capacidadMaxima;
        this.materiaDestinada = materiaDestinada;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public boolean sePuedeDarClase() {
        if (profesor == null || !profesor.estaDisponible() || !profesor.getMateria().equals(materiaDestinada)) {
            return false;
        }

        int numEstudiantes = estudiantes.size();
        int numAlumnosAprobados = 0;

        for (Estudiante estudiante : estudiantes) {
            if (!estudiante.haceNovillos() && estudiante.getCalificacion() >= 5) {
                numAlumnosAprobados++;
            }
        }

        return numEstudiantes > 0 && numAlumnosAprobados > numEstudiantes / 2;
    }
}

public class ejercicio5 {
    public static void main(String[] args) {
        // Crear profesor
        Profesor profesor = new Profesor("Profesor A", 40, 'M', "matemáticas");

        // Crear estudiantes y agregar al aula
        Aula aulaMatematicas = new Aula(1, 20, "matemáticas");
        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante("Estudiante " + (i + 1), getRandomAge(), getRandomSex(), getRandomCalificacion());
            aulaMatematicas.agregarEstudiante(estudiante);
        }

        // Agregar profesor al aula
        aulaMatematicas.agregarProfesor(profesor);

        // Determinar si se puede dar clase
        if (aulaMatematicas.sePuedeDarClase()) {
            System.out.println("Se puede dar clase en el aula de matemáticas.");
        } else {
            System.out.println("No se puede dar clase en el aula de matemáticas.");
        }
    }

    // Generar una edad aleatoria entre 18 y 25 años
    private static int getRandomAge() {
        return new Random().nextInt(8) + 18;
    }

    // Generar un sexo aleatorio
    private static char getRandomSex() {
        return Math.random() < 0.5 ? 'M' : 'F';
    }

    // Generar una calificación aleatoria entre 0 y 10
    private static double getRandomCalificacion() {
        return Math.random() * 10;
    }
}







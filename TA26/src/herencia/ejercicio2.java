package herencia;

public class ejercicio2 {

    interface Entregable {
        void entregar();
        void devolver();
        boolean isEntregado();
        int compareTo(Object a);
    }

    static class Serie implements Entregable {
        private String titulo;
        private int numeroTemporadas;
        private boolean entregado;
        private String genero;
        private String creador;

        public Serie(String titulo, String creador) {
            this.titulo = titulo;
            this.creador = creador;
            this.numeroTemporadas = 3;
            this.entregado = false;
            this.genero = "";
        }

        public int getNumeroTemporadas() {
            return numeroTemporadas;
        }
        
        @Override
        public void entregar() {
            entregado = true;
        }

        @Override
        public void devolver() {
            entregado = false;
        }

        @Override
        public boolean isEntregado() {
            return entregado;
        }

        @Override
        public int compareTo(Object a) {         
            return 0;
        }

        @Override
        public String toString() {
            return "Serie{" +
                    "titulo='" + titulo + '\'' +
                    ", numeroTemporadas=" + numeroTemporadas +
                    ", entregado=" + entregado +
                    ", genero='" + genero + '\'' +
                    ", creador='" + creador + '\'' +
                    '}';
        }
    }

    static class Videojuego implements Entregable {
        private String titulo;
        private int horasEstimadas;
        private boolean entregado;
        private String genero;
        private String compañia;

        public Videojuego(String titulo, int horasEstimadas) {
            this.titulo = titulo;
            this.horasEstimadas = horasEstimadas;
            this.entregado = false;
            this.genero = "";
            this.compañia = "";
        }

        public int getHorasEstimadas() {
            return horasEstimadas;
        }
        
        
        @Override
        public void entregar() {
            entregado = true;
        }

        @Override
        public void devolver() {
            entregado = false;
        }

        @Override
        public boolean isEntregado() {
            return entregado;
        }

        @Override
        public int compareTo(Object a) {
            return 0;
        }

        @Override
        public String toString() {
            return "Videojuego{" +
                    "titulo='" + titulo + '\'' +
                    ", horasEstimadas=" + horasEstimadas +
                    ", entregado=" + entregado +
                    ", genero='" + genero + '\'' +
                    ", compañia='" + compañia + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        series[0] = new Serie("Serie 1", "Creador 1");
        series[1] = new Serie("Serie 2", "Creador 2");

        videojuegos[0] = new Videojuego("Videojuego 1", 20);
        videojuegos[1] = new Videojuego("Videojuego 2", 15);
 
        series[0].entregar();
        videojuegos[1].entregar();

        int seriesEntregadas = contarEntregados(series);
        int videojuegosEntregados = contarEntregados(videojuegos);
        // ...


        Videojuego videojuegoConMasHoras = encontrarConMayorHoras(videojuegos);

        Serie serieConMasTemporadas = encontrarConMasTemporadas(series);

        System.out.println("Series entregadas: " + seriesEntregadas);
        System.out.println("Videojuegos entregados: " + videojuegosEntregados);
        System.out.println("Videojuego con más horas: " + videojuegoConMasHoras);
        System.out.println("Serie con más temporadas: " + serieConMasTemporadas);
    }

    static int contarEntregados(Entregable[] array) {
        int count = 0;
        for (Entregable item : array) {
            if (item.isEntregado()) {
                count++;
            }
        }
        return count;
    }

    static Videojuego encontrarConMayorHoras(Videojuego[] array) {
        Videojuego mayor = array[0];
        for (Videojuego item : array) {
            if (item.getHorasEstimadas() > mayor.getHorasEstimadas()) {
                mayor = item;
            }
        }
        return mayor;
    }

    static Serie encontrarConMasTemporadas(Serie[] array) {
        Serie mayor = array[0];
        for (Serie item : array) {
            if (item.getNumeroTemporadas() > mayor.getNumeroTemporadas()) {
                mayor = item;
            }
        }
        return mayor;
        
    }
}


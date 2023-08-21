package herencia;

public class ejercicio3 {

    private String ISBN;
    private String titulo;
    private String autor;
    private int numeroPaginas;

    public ejercicio3(String ISBN, String titulo, String autor, int numeroPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    // Métodos getters y setters
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    // Método toString
    @Override
    public String toString() {
        return "El libro con ISBN " + ISBN + " creado por " + autor + " tiene " + numeroPaginas + " páginas.";
    }

    public static void main(String[] args) {
        // Crear objetos Libro
    	ejercicio3 libro1 = new ejercicio3("123456789", "El Gran Libro", "Autor A", 300);
    	ejercicio3 libro2 = new ejercicio3("987654321", "Aventuras Increíbles", "Autor B", 250);

        // Mostrar información por pantalla
        System.out.println(libro1);
        System.out.println(libro2);

        // Comparar número de páginas
        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            System.out.println("El libro 1 tiene más páginas.");
        } else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
            System.out.println("El libro 2 tiene más páginas.");
        } else {
            System.out.println("Ambos libros tienen la misma cantidad de páginas.");
        }
    }
}

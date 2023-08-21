package herencia;

public class ejercicio4 {

	private double a;
    private double b;
    private double c;

    public ejercicio4(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public boolean tieneRaices() {
        return getDiscriminante() >= 0;
    }

    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    public void calcular() {
        double discriminante = getDiscriminante();
        if (tieneRaices()) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Solución 1: " + x1);
            System.out.println("Solución 2: " + x2);
        } else {
            System.out.println("No hay soluciones reales.");
        }
    }

    public void obtenerRaices() {
        if (tieneRaices()) {
            calcular();
        } else {
            System.out.println("No hay soluciones reales.");
        }
    }

    public void obtenerRaiz() {
        if (tieneRaiz()) {
            double x = -b / (2 * a);
            System.out.println("Única raíz: " + x);
        } else {
            System.out.println("No tiene una única raíz.");
        }
    }

    public static void main(String[] args) {
    	ejercicio4 ecuacion1 = new ejercicio4(1, -3, 2);
    	ejercicio4 ecuacion2 = new ejercicio4(1, -4, 4);

        System.out.println("Ecuación 1:");
        ecuacion1.calcular();
        System.out.println();

        System.out.println("Ecuación 2:");
        ecuacion2.obtenerRaices();
        System.out.println();

        System.out.println("Ecuación 1 - Única raíz:");
        ecuacion1.obtenerRaiz();
    }
}

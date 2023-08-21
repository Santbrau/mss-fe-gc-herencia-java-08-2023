package herencia;

public class ejercicio1 {

	protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;
    
    protected static final String COLOR_DEFECTO = "blanco";
    protected static final char CONSUMO_ENERGETICO_DEFECTO = 'F';
    protected static final double PRECIO_BASE_DEFECTO = 100;
    protected static final double PESO_DEFECTO = 5;
    
    protected static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    protected static final double[] PRECIOS_CONSUMO = {100, 89, 60, 50, 30, 10};
    protected static final double[] PRECIOS_PESO = {10, 50, 100, 100};
    
    public ejercicio1() {
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.precioBase = PRECIO_BASE_DEFECTO;
        this.peso = PESO_DEFECTO;
    }
    
    public ejercicio1(double precioBase, double peso) {
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.precioBase = precioBase;
        this.peso = peso;
    }
    
    public ejercicio1(double precioBase, String color, char consumoEnergetico, double peso) {
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
        this.precioBase = precioBase;
        this.peso = peso;
    }
    
    public void comprobarColor(String color) {
        color = color.toLowerCase();
        for (String col : COLORES_DISPONIBLES) {
            if (col.equals(color)) {
                this.color = color;
                return;
            }
        }
        this.color = COLOR_DEFECTO;
    }
    
    public void comprobarConsumoEnergetico(char letra) {
    	for (double precioConsumo : PRECIOS_CONSUMO) {
            if (precioConsumo == letra) {
                this.consumoEnergetico = letra;
                return;
            }
        }
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
    }
    
    public double precioFinal() {
        int indiceConsumo = consumoEnergetico - 'A';
        double precioConsumo = (indiceConsumo >= 0 && indiceConsumo < PRECIOS_CONSUMO.length) ?
                              PRECIOS_CONSUMO[indiceConsumo] : PRECIOS_CONSUMO[PRECIOS_CONSUMO.length - 1];
        
        int indicePeso;
        if (peso < 20) {
            indicePeso = 0;
        } else if (peso < 50) {
            indicePeso = 1;
        } else if (peso < 80) {
            indicePeso = 2;
        } else {
            indicePeso = 3;
        }
        double precioPeso = PRECIOS_PESO[indicePeso];
        
        return precioBase + precioConsumo + precioPeso;
    }
}

class Lavadora extends ejercicio1 {
    protected static final double CARGA_DEFECTO = 5;
    
    private double carga;
    
    public Lavadora() {
        super();
        this.carga = CARGA_DEFECTO;
    }
    
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_DEFECTO;
    }
    
    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }
    
    public double getCarga() {
        return carga;
    }
    
    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (carga > 30) {
            precio += 50;
        }
        return precio;
    }
}

class Television extends ejercicio1 {
    protected static final double RESOLUCION_DEFECTO = 20;
    protected static final boolean SINTONIZADOR_TDT_DEFECTO = false;
    
    private double resolucion;
    private boolean sintonizadorTDT;
    
    public Television() {
        super();
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;
    }
    
    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;
    }
    
    public Television(double precioBase, String color, char consumoEnergetico, double peso, 
                      double resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }
    
    public double getResolucion() {
        return resolucion;
    }
    
    public boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }
    
    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (resolucion > 40) {
            precio *= 1.3;
        }
        if (sintonizadorTDT) {
            precio += 50;
        }
        return precio;
    }


public static void main(String[] args) {
    ejercicio1[] electrodomesticos = new ejercicio1[10];
    electrodomesticos[0] = new Lavadora(150, 50);
    electrodomesticos[1] = new Television(300, "negro", 'A', 30, 50, true);

    double precioTotalElectrodomesticos = 0;
    double precioTotalLavadoras = 0;
    double precioTotalTelevisiones = 0;

    for (ejercicio1 electrodomestico : electrodomesticos) {
        if (electrodomestico instanceof Lavadora) {
            precioTotalLavadoras += electrodomestico.precioFinal();
        } else if (electrodomestico instanceof Television) {
            precioTotalTelevisiones += electrodomestico.precioFinal();
        }
        precioTotalElectrodomesticos += electrodomestico.precioFinal();
    }

    System.out.println("Precio total de Electrodomésticos: " + precioTotalElectrodomesticos);
    System.out.println("Precio total de Lavadoras: " + precioTotalLavadoras);
    System.out.println("Precio total de Televisiones: " + precioTotalTelevisiones);
}


}


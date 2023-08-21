package vehicles;
import java.util.Scanner;

class Vehicle {
    private String licensePlate;
    private String brand;
    private String color;
    private Wheel[] wheels;

    public Vehicle(String licensePlate, String brand, String color) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
        this.wheels = new Wheel[4];
    }

    public void addWheels(Wheel[] wheels) {
        if (wheels.length == 4) {
            this.wheels = wheels;
        } else {
            System.out.println("A vehicle must have exactly 4 wheels.");
        }
    }

    public void printDetails() {
        System.out.println("Vehicle details:");
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Wheels:");
        for (Wheel wheel : wheels) {
            System.out.println("- Brand: " + wheel.getBrand() + ", Diameter: " + wheel.getDiameter());
        }
    }
}

class Wheel {
    private String brand;
    private double diameter;

    public Wheel(String brand, double diameter) {
        this.brand = brand;
        this.diameter = diameter;
    }

    public String getBrand() {
        return brand;
    }

    public double getDiameter() {
        return diameter;
    }
}

public class milestone1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1) Create a Car");
        System.out.println("2) Create a Bike");

        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        Vehicle vehicle;

        if (option == 1) {
            vehicle = new Vehicle(licensePlate, brand, color);

            Wheel[] carWheels = new Wheel[4];

            for (int i = 0; i < 4; i++) {
                System.out.print("Enter wheel brand: ");
                String wheelBrand = scanner.nextLine();

                System.out.print("Enter wheel diameter: ");
                double wheelDiameter = scanner.nextDouble();
                scanner.nextLine();

                carWheels[i] = new Wheel(wheelBrand, wheelDiameter);
            }

            vehicle.addWheels(carWheels);
        } else if (option == 2) {
            vehicle = new Vehicle(licensePlate, brand, color);

            Wheel[] bikeWheels = new Wheel[2];

            for (int i = 0; i < 2; i++) {
                System.out.print("Enter wheel brand: ");
                String wheelBrand = scanner.nextLine();

                System.out.print("Enter wheel diameter: ");
                double wheelDiameter = scanner.nextDouble();
                scanner.nextLine();

                bikeWheels[i] = new Wheel(wheelBrand, wheelDiameter);
            }

            vehicle.addWheels(bikeWheels);
        } else {
            System.out.println("Invalid option.");
            scanner.close();
            return;
        }

        vehicle.printDetails();
        scanner.close();
    }
}

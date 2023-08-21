package vehicles;

import java.util.Date;
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

class VehicleOwner {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean hasInsurance;
    private boolean hasGarage;

    public VehicleOwner(String firstName, String lastName, Date birthDate, boolean hasInsurance, boolean hasGarage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hasInsurance = hasInsurance;
        this.hasGarage = hasGarage;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

class Driver {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private DrivingLicense license;

    public Driver(String firstName, String lastName, Date birthDate, DrivingLicense license) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.license = license;
    }

    public boolean canDrive(Vehicle vehicle) {
        return license.getLicenseType().equals(vehicle.getLicenseType()) && !license.isExpired();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

class DrivingLicense {
    private int ID;
    private String licenseType;
    private String fullName;
    private Date expirationDate;

    public DrivingLicense(int ID, String licenseType, String fullName, Date expirationDate) {
        this.ID = ID;
        this.licenseType = licenseType;
        this.fullName = fullName;
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }

    public String getLicenseType() {
        return licenseType;
    }
}

public class milestone2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1) Create a Car");
        System.out.println("2) Create a Bike");
        System.out.println("3) Create a Truck");

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
        } else if (option == 3) {
            System.out.println("Creating a Truck:");
            System.out.print("Enter license plate: ");
            String truckLicensePlate = scanner.nextLine();

            System.out.print("Enter brand: ");
            String truckBrand = scanner.nextLine();

            System.out.print("Enter color: ");
            String truckColor = scanner.nextLine();

            vehicle = new Truck(truckLicensePlate, truckBrand, truckColor);

            Wheel[] truckWheels = new Wheel[6]; // Trucks have 6 wheels

            for (int i = 0; i < 6; i++) {
                System.out.print("Enter wheel brand: ");
                String wheelBrand = scanner.nextLine();

                System.out.print("Enter wheel diameter: ");
                double wheelDiameter = scanner.nextDouble();
                scanner.nextLine();

                truckWheels[i] = new Wheel(wheelBrand, wheelDiameter);
            }

            vehicle.addWheels(truckWheels);
        } else {
            System.out.println("Invalid option.");
            scanner.close();
            return;
        }

        vehicle.printDetails();
        scanner.close();
    }
}

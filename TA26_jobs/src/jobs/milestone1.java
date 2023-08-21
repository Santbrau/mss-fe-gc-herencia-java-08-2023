package jobs;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculatePayment() {
        // El càlcul del pagament per a empleats normals
        return salary * 0.85;
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculatePayment() {
        // El càlcul del pagament per a gerents
        return super.calculatePayment() * 1.10;
    }
}

class Boss extends Employee {
    public Boss(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculatePayment() {
        // El càlcul del pagament per a caps
        return super.calculatePayment() * 1.50;
    }
}

class Volunteer extends Employee {
    public Volunteer(String name) {
        super(name, 0); // Els voluntaris no cobren
    }

    @Override
    public double calculatePayment() {
        return 0; // Els voluntaris no tenen pagament
    }
}

public class milestone1 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 2000);
        Manager manager1 = new Manager("Alice", 3000);
        Boss boss1 = new Boss("Bob", 4000);
        Volunteer volunteer1 = new Volunteer("Eve");

        System.out.println("Employee 1 payment: $" + employee1.calculatePayment());
        System.out.println("Manager 1 payment: $" + manager1.calculatePayment());
        System.out.println("Boss 1 payment: $" + boss1.calculatePayment());
        System.out.println("Volunteer 1 payment: $" + volunteer1.calculatePayment());
    }
}


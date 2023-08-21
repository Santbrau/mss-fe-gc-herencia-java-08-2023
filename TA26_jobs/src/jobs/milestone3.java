package jobs;

class Employee {
    String name;
    double salaryBrut;
    double salaryNet;

    public Employee(String name, double salaryBrut) {
        this.name = name;
        this.salaryBrut = salaryBrut;
        this.calculateNetSalary();
    }

    public void calculateNetSalary() {
        this.salaryNet = this.salaryBrut * (1 - getIRPF());
    }

    public double calculateAnnualSalary() {
        return salaryBrut * 12;
    }

    public double getIRPF() {
    
        return 0;
    }

    public void emitBonus() {
        double bonus = calculateAnnualSalary() * 0.10;
        System.out.println("Emitting a bonus of $" + bonus + " to " + name);
    }
}

class Junior extends Employee {
    public Junior(String name, double salaryBrut) throws IllegalArgumentException {
        super(name, salaryBrut);
    }

    @Override
    public double getIRPF() {
        return 0.02; 
    }
}

class Mid extends Employee {
    public Mid(String name, double salaryBrut) throws IllegalArgumentException {
        super(name, salaryBrut);
    }

    @Override
    public double getIRPF() {
        return 0.15; 
    }
}

class Senior extends Employee {
    public Senior(String name, double salaryBrut) throws IllegalArgumentException {
        super(name, salaryBrut);
    }

    @Override
    public double getIRPF() {
        return 0.24;
    }
}

class Manager extends Employee {
    public Manager(String name, double salaryBrut) throws IllegalArgumentException {
        super(name, salaryBrut);
    }

    @Override
    public double getIRPF() {
        return 0.26; 
    }
}

class Boss extends Employee {
    public Boss(String name, double salaryBrut) throws IllegalArgumentException {
        super(name, salaryBrut);
    }

    @Override
    public double getIRPF() {
        return 0.32; 
    }
}

class Volunteer extends Employee {
    boolean governmentAid;

    public Volunteer(String name, boolean governmentAid) {
        super(name, 0);
        this.governmentAid = governmentAid;
    }

    @Override
    public void calculateNetSalary() {
        this.salaryNet = governmentAid ? 300 : 0;
    }

    @Override
    public double calculateAnnualSalary() {
        return governmentAid ? 300 * 12 : 0;
    }

    @Override
    public void emitBonus() {
        System.out.println("Volunteers do not receive bonuses.");
    }
}

public class milestone3 {
    public static void main(String[] args) {
        try {
            Junior junior1 = new Junior("John", 1200);
            Mid mid1 = new Mid("Alice", 2200);
            Senior senior1 = new Senior("Bob", 3200);
            Manager manager1 = new Manager("Eve", 4200);
            Boss boss1 = new Boss("Frank", 10000);
            Volunteer volunteer1 = new Volunteer("Grace", true);
            Volunteer volunteer2 = new Volunteer("Alex", false);

            Employee[] employees = { junior1, mid1, senior1, manager1, boss1, volunteer1, volunteer2 };

            for (Employee employee : employees) {
                System.out.println(employee.name + " annual salary: $" + employee.calculateAnnualSalary());
                employee.emitBonus();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

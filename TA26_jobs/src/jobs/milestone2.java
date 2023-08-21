package jobs;

class TheEmployee {
    String name;
    double salary;

    public TheEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculatePayment() {
        return salary;
    }
}

class Junior extends TheEmployee {
    public Junior(String name, double salary) throws IllegalArgumentException {
        super(name, validateSalary("Junior", salary, 900, 1600));
    }
}

class Mid extends TheEmployee {
    public Mid(String name, double salary) throws IllegalArgumentException {
        super(name, validateSalary("Mid", salary, 1800, 2500));
    }
}

class Senior extends TheEmployee {
    public Senior(String name, double salary) throws IllegalArgumentException {
        super(name, validateSalary("Senior", salary, 2700, 4000));
    }
}

class Manager extends TheEmployee {
    public Manager(String name, double salary) throws IllegalArgumentException {
        super(name, validateSalary("Manager", salary, 3000, 5000));
    }
}

class Boss extends TheEmployee {
    public Boss(String name, double salary) throws IllegalArgumentException {
        super(name, validateBossSalary(salary));
    }
}

class Volunteer extends TheEmployee {
    public Volunteer(String name) {
        super(name, 0);
    }
}

public class Milestone2 {
    public static double validateSalary(String employeeType, double salary, double min, double max) throws IllegalArgumentException {
        if (salary < min || salary > max) {
            throw new IllegalArgumentException(employeeType + " salary must be between " + min + " and " + max);
        }
        return salary;
    }

    public static double validateBossSalary(double salary) throws IllegalArgumentException {
        if (salary <= 8000) {
            throw new IllegalArgumentException("Boss salary must be more than 8000");
        }
        return salary;
    }

    public static void main(String[] args) {
        try {
            Junior junior1 = new Junior("John", 1200);
            Mid mid1 = new Mid("Alice", 2200);
            Senior senior1 = new Senior("Bob", 3200);
            Manager manager1 = new Manager("Eve", 4200);
            Boss boss1 = new Boss("Frank", 10000);
            Volunteer volunteer1 = new Volunteer("Grace");

            TheEmployee[] employees = { junior1, mid1, senior1, manager1, boss1, volunteer1 };

            for (TheEmployee employee : employees) {
                System.out.println(employee.name + " payment: $" + employee.calculatePayment());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


package vectorAndMatrix.salaryIncrease.entities;

import java.text.DecimalFormat;

public class Employee {
    private final long id;
    private final String name;
    private double salary;

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void increaseSalary(double percentage) {
        this.salary = this.salary * (1 + (percentage / 100));
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String formattedSalary = decimalFormat.format(salary);

        return id + ", " + name + ", " + formattedSalary;
    }
}

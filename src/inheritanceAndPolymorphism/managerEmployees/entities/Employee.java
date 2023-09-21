package inheritanceAndPolymorphism.managerEmployees.entities;

public class Employee {
    private final String name;
    private final Integer hours;
    private final Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public double payment() {
        return hours * valuePerHour;
    }

    @Override
    public String toString() {
        return name + " - " + String.format("$%.2f", payment());
    }
}

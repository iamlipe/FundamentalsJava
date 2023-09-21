package inheritanceAndPolymorphism.calculateTax.entities;

public abstract class Payer {
    private final String name;
    protected Double income;

    public Payer(String name, Double income) {
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public abstract double tax();
}

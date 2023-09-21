package inheritanceAndPolymorphism.calculateTax.entities;

public class CompanyPayer extends Payer {
    private final Integer employees;

    public CompanyPayer(String name, Double income, int employees) {
        super(name, income);
        this.employees = employees;
    }

    @Override
    public double tax() {
        if (employees <= 10) {
            return income * 0.16;
        }

        return income * 0.14;
    }
}

package inheritanceAndPolymorphism.calculateTax.entities;

import inheritanceAndPolymorphism.calculateTax.entities.Payer;

public class IndividualPayer extends Payer {
    private final Double healthExpenditures;

    public IndividualPayer(String name, Double income, Double healthExpenditures) {
        super(name, income);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        if (income <= 20000.00) {
            return (income * 0.15) - (healthExpenditures * 0.5);
        }

        return (income * 0.25) - (healthExpenditures * 0.5);
    }
}

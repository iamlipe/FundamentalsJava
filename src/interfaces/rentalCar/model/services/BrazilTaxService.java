package interfaces.rentalCar.model.services;

public class BrazilTaxService implements TaxService {

    public double tax(double amout) {
        if (amout < 100) {
            return amout * 0.2;
        }

        return amout * 0.15;
    }
}

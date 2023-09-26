package interfaces.rentalCar.model.services;

import interfaces.rentalCar.model.entities.CarRental;
import interfaces.rentalCar.model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;
        double days = hours / 24.0;
        double basicPayment;

        if (hours <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            basicPayment = pricePerDay * Math.ceil(days);
        }

        double tax = taxService.tax(basicPayment);

        Invoice invoice = new Invoice(basicPayment, tax);

        carRental.setInvoice(invoice);
    }
}

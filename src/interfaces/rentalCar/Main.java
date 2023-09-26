package interfaces.rentalCar;

import interfaces.rentalCar.model.entities.CarRental;
import interfaces.rentalCar.model.entities.Vehicle;
import interfaces.rentalCar.model.services.BrazilTaxService;
import interfaces.rentalCar.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String model = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), formatter);
        System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), formatter);

        Vehicle vehicle = new Vehicle(model);
        CarRental carRental = new CarRental(start, finish, vehicle);

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        BrazilTaxService taxService = new BrazilTaxService();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, taxService);

        rentalService.processInvoice(carRental);

        System.out.println();
        System.out.println("FATURA: ");
        System.out.printf("Pagemento basico: %.2f %n", carRental.getInvoice().getBasicPayment());
        System.out.printf("Imposto: %.2f %n", carRental.getInvoice().getTax());
        System.out.printf("Pagamento total: %.2f %n", carRental.getInvoice().getTotalPayment());

        sc.close();
    }
}

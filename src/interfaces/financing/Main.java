package interfaces.financing;

import interfaces.financing.model.entities.Contract;
import interfaces.financing.model.entities.Installment;
import interfaces.financing.model.services.ContractService;
import interfaces.financing.model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");

        System.out.print("Numero: ");
        int number = sc.nextInt();

        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), formatter);

        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int numberOfInstallments = sc.nextInt();

        Contract contract = new Contract(number, date, totalValue);
        PaypalService paypalService = new PaypalService();
        ContractService contractService = new ContractService(paypalService);

        contractService.processContract(contract, numberOfInstallments);

        System.out.println("Parcelas: ");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}

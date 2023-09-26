package interfaces.loan;

import interfaces.loan.services.BrazilInterestService;
import interfaces.loan.services.InterestService;
import interfaces.loan.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amout = sc.nextDouble();

        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService interestService = new UsaInterestService(1.0);
        double payment = interestService.payment(amout, months);

        System.out.println("Payment after " + months + " months:");
        System.out.printf("%.2f %n", payment);

        sc.close();
    }
}

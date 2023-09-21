package inheritanceAndPolymorphism.calculateTax;

import inheritanceAndPolymorphism.calculateTax.entities.CompanyPayer;
import inheritanceAndPolymorphism.calculateTax.entities.IndividualPayer;
import inheritanceAndPolymorphism.calculateTax.entities.Payer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numbers of tax payers: ");
        int taxPayers = sc.nextInt();

        List<Payer> payers = new ArrayList<>();

        for (int i = 1; i <= taxPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or company (i/c)? ");
            char typePayer;

            do {
                typePayer = sc.next().toLowerCase().charAt(0);

                if (typePayer != 'i' && typePayer != 'c') {
                    System.out.println("Enter a valid shape");
                }
            } while (typePayer != 'i' && typePayer != 'c');

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Anual income: ");
            double income = sc.nextDouble();

            if (typePayer == 'i') {
                System.out.print("Health expenditures: ");
                double helthExpenditures = sc.nextDouble();

                Payer payer = new IndividualPayer(name, income, helthExpenditures);
                payers.add(payer);
            }

            if (typePayer == 'c') {
                System.out.print("Number of employees: ");
                int employees = sc.nextInt();

                Payer payer = new CompanyPayer(name, income, employees);
                payers.add(payer);
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        double totalTaxes = 0;

        for (Payer p : payers) {
            System.out.println(p.getName() + ": " + String.format("$ %.2f", p.tax()));

            totalTaxes += p.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: %.2f", totalTaxes);
    }

}

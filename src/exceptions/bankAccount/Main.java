package exceptions.bankAccount;

import exceptions.bankAccount.model.entities.Account;
import exceptions.checkInHotel.model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");

            System.out.print("Number: ");
            int number = sc.nextInt();

            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amout for withdraw: ");
            double amount = sc.nextDouble();
            System.out.println();

            acc.withdraw(amount);

            System.out.printf("New balance: %.2f", acc.getBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

    }
}

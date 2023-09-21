package inheritanceAndPolymorphism.bankAccount;

import inheritanceAndPolymorphism.bankAccount.entities.Account;
import inheritanceAndPolymorphism.bankAccount.entities.BusinessAccount;
import inheritanceAndPolymorphism.bankAccount.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // UPCASTING
        Account acc2 = new BusinessAccount(1003, "Alex", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DONWCASTING
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        SavingsAccount acc5 = (SavingsAccount) acc3;
        acc5.updateBalance();

        // Override
        Account acc7 = new SavingsAccount(1007, "Maria", 1000.0, 0.01);
        acc7.withdraw(200.0);

        Account acc8 = new BusinessAccount(1008, "Bob", 1000.0, 500.0);
        acc8.withdraw(200.0);

        List<Account> accounts = new ArrayList<>();

        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc7);
        accounts.add(acc8);

        for (Account a : accounts) {
            System.out.println(a.getBalance());
        }

    }
}

package exception.bankAccount.model.entities;

import exception.checkInHotel.model.exceptions.DomainException;

public class Account {
    private final Integer number;
    private final String holder;
    private Double balance;
    private final Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        }

        if (amount > balance) {
            throw new DomainException("Not enough balance");
        }

        balance -= amount;
    }
}

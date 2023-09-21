package inheritanceAndPolymorphism.bankAccount.entities;

public abstract class Account {
    private Integer number;
    private String holder;
    protected Double balance;

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double amout) {
        balance -= amout + 5.0;
    }

    public void deposit(double amout) {
        balance += amout;
    }
}

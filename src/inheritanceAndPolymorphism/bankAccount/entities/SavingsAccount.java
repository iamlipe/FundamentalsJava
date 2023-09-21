package inheritanceAndPolymorphism.bankAccount.entities;

public final class SavingsAccount extends Account {
    private final Double interestRate;

    public SavingsAccount(Integer number, String holder, Double balace, Double interestRate) {
        super(number, holder, balace);
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(double amout) {
        balance -= amout;
    }
}

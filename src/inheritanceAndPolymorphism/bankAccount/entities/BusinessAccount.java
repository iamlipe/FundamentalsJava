package inheritanceAndPolymorphism.bankAccount.entities;

public class BusinessAccount extends Account {
    private final Double loanLimit;

    public BusinessAccount(Integer number, String holder, Double balace, Double loanLimit) {
        super(number, holder, balace);
        this.loanLimit = loanLimit;
    }

    public void loan(double amout) {
        if (amout <= loanLimit) {
            deposit(amout);
        }
    }

    @Override
    public void withdraw(double amout) {
        super.withdraw(amout);
        balance -= 2.0;
    }
}

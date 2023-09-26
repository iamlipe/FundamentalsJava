package interfaces.loan.services;

public class UsaInterestService implements InterestService {
    private final Double interestRate;

    public UsaInterestService(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}

package interfaces.financing.model.services;

import interfaces.financing.model.entities.Contract;
import interfaces.financing.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private final OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double amountPerMonth = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(amountPerMonth, i);
            double fee = onlinePaymentService.paymentFee(amountPerMonth + interest);

            double amount = amountPerMonth + fee + interest;

            Installment installment = new Installment(dueDate, amount);

            contract.addInstallment(installment);
        }
    }
}

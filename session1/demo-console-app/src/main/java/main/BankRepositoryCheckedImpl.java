package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankRepositoryCheckedImpl implements BankRepository {
    @Value("${bank.threshold}")
    private double threshold;

    @Override
    public void update(int accountId, double amount) {
        if (amount > this.threshold) {
            throw new RuntimeException("Amount REJECTED by being greater than threshold. [" +
                    amount + " > " + this.threshold + "]");
        }
        System.out.printf("\tIn RepositoryImpl.update(%d, %.2f)\n", accountId, amount);
    }
}

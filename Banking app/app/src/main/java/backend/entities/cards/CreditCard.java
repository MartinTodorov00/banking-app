package backend.entities.cards;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    public CreditCard(BigDecimal balance, BigDecimal paymentLimit, BigDecimal withdrawalLimit) {
        super(balance, paymentLimit, withdrawalLimit);
    }
}

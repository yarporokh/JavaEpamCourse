package com.company.task7;

import java.math.BigDecimal;

public class LongDeposit extends Deposit{

    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amountAfterIncome = getAmount();
        for (float i = 1; i <= getPeriod(); i++) {
            if (i >= 7) {
                amountAfterIncome = amountAfterIncome.add(amountAfterIncome.multiply(new BigDecimal(0.7)));
            }
        }
        BigDecimal res = amountAfterIncome.subtract(getAmount());
        return res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}

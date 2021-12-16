package com.company.task7;

import java.math.BigDecimal;

public class SpecialDeposit extends Deposit{
    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amountAfterIncome = getAmount();
        for (float i = 1f; i <= getPeriod(); i++) {
            amountAfterIncome = amountAfterIncome.add(amountAfterIncome.multiply(new BigDecimal(i / 100))) ;
        }
        BigDecimal res = amountAfterIncome.subtract(getAmount());
        return res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }


}

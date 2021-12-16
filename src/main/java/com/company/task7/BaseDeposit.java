package com.company.task7;

import java.math.BigDecimal;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amountAfterIncome = getAmount();
        for (int i = 0; i < getPeriod(); i++) {
            amountAfterIncome = amountAfterIncome.add(amountAfterIncome.multiply(new BigDecimal(0.05))) ;
        }
        BigDecimal res = amountAfterIncome.subtract(getAmount());
        return res.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }


}

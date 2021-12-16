package com.company.task7;

import java.math.BigDecimal;

public abstract class Deposit {
    private BigDecimal amount;
    private int period;

    public Deposit(BigDecimal depositAmount, int depositPeriod) {
         this.amount = depositAmount;
         this.period = depositPeriod;
    }

    public void setPeriod(int period) {
        if (period <= 0)
            throw new IllegalArgumentException();

        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    abstract BigDecimal income();


}

package com.company.task6;

import java.math.BigDecimal;

public class SalesPerson extends Employee {

    private int percent;


    public SalesPerson(String lastName, double money, int percent) {
        super(lastName, money);
        setPercent(percent);
    }

    public void setPercent(int percent) {
        if (percent <= 0)
            throw new IllegalArgumentException();
        this.percent = percent;
    }

    @Override
    public void setBonus(BigDecimal bonusAmount) {
        if (percent > 200) {
            this.bonus = bonusAmount.multiply(new BigDecimal(3));
        } else if (percent > 100) {
            this.bonus = bonusAmount.multiply(new BigDecimal(2));
        } else {
            this.bonus = bonusAmount;
        }
    }
}




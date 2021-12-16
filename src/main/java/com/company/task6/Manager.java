package com.company.task6;

import java.math.BigDecimal;

public class Manager extends Employee {
    private int quantity;

    public Manager(String lastName, double money, int clientAmount) {
        super(lastName, money);
        setQuantity(clientAmount);
    }

    public void setQuantity(int clientAmount) {
        if (clientAmount <= 0)
            throw new IllegalArgumentException();
        this.quantity = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonusAmount) {
        if (quantity > 150) {
            this.bonus = bonusAmount.add(new BigDecimal(1000));
        } else if (quantity > 100) {
            this.bonus = bonusAmount.add(new BigDecimal(500));
        } else {
            this.bonus = bonusAmount;
        }
    }
}

package com.company.task6;

import java.math.BigDecimal;

public abstract class Employee {
    private String lastName;
    private BigDecimal salary;
    protected BigDecimal bonus;

    public Employee(String lastName, double money) {
        this.lastName = lastName;
        setSalary(new BigDecimal(money));
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        if ((salary.compareTo(new BigDecimal(0)) == -1)
                || (salary.compareTo(new BigDecimal(0)) == 0))
            throw new IllegalArgumentException();
        this.salary = salary;
    }

    public abstract void setBonus(BigDecimal bonusAmount);

    public BigDecimal toPay() {
        return salary.add(bonus);
    }
}

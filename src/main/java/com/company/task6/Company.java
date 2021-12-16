package com.company.task6;

import java.math.BigDecimal;
import java.util.Arrays;

public class Company {
    private Employee[] employees;

    public Company(Employee... staff) {
        employees = Arrays.copyOf(staff, staff.length);
    }

    public void giveEverbodyBonus(BigDecimal bonusAmount) {
        for (Employee employee : employees) {
            employee.setBonus(bonusAmount);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal count = new BigDecimal(0);

        for (Employee employee : employees) {
            count = count.add(employee.toPay());
        }

        return count;
    }

    public String nameMaxSalary() {
        Employee bestEmployee = employees[0];

        for (int i = 0; i < employees.length - 1; i++) {
            if (bestEmployee.toPay().compareTo(employees[i + 1].toPay()) == -1)
                bestEmployee = employees[i + 1];
        }
        return bestEmployee.getLastName();
    }

}

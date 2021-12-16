package com.company.task7;

import java.math.BigDecimal;

public class Client {
    private Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }

    public boolean addDeopist(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome(){
        BigDecimal res = new BigDecimal(0);

        for (Deposit deposit:deposits) {
            if (deposit == null){
                break;
            }
            res = res.add(deposit.income());
        }

        return res;
    }

    public BigDecimal maxIncome(){
        Deposit maxDepostIncome = deposits[0];

        for (int i = 1; i < deposits.length; i++) {
            if (deposits[i] == null){
                break;
            }
            if(maxDepostIncome.income().compareTo(deposits[i].income()) == -1){
                maxDepostIncome = deposits[i];
            }
        }

        return maxDepostIncome.income();
    }

    public BigDecimal getIncomeByNumber(int index){
        if (index - 1 > deposits.length || deposits[index - 1] == null){
            return new BigDecimal(0);
        }

        return deposits[index - 1].income();
    }
}

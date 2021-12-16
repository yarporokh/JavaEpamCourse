package com.company.task7mvc.profile;

public class ProfileModel {
    private String accountLogin;
    private int numberOfAttempts;

    public ProfileModel(String accountLogin) {
        this.accountLogin = accountLogin;
        this.numberOfAttempts = 0;
    }

    public String getAccountLogin() {
        return accountLogin;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setAccountLogin(String accountLogin) {
        this.accountLogin = accountLogin;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}

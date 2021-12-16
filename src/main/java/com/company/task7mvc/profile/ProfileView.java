package com.company.task7mvc.profile;

import java.util.HashMap;

public class ProfileView {
    public void profileInfo(String accountLogin, int numberOfAttempts) {
        System.out.printf("Login: %s\nYour attempts: %d", accountLogin, numberOfAttempts);
    }

    public void profileInfo(HashMap<String, Integer> allProfiles) {
        for (String key: allProfiles.keySet()){
            System.out.println(key +" = "+allProfiles.get(key));
        }
    }

    public void profManager(){
        System.out.print("Enter login: ");
    }

    public void mainMenu(){
        System.out.println("""
                
                1 - Check statistics of all
                2 - Check statistic of a certain person
                3 - Play game""");
    }

    public void incorrectNumber(){
        System.out.println("Number is incorrect");
    }

    public void incorrectUser(){
        System.out.println("User is incorrect");
    }
}

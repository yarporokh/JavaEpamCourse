package com.company.task7mvc;


import com.company.task7mvc.profile.ProfileController;
import com.company.task7mvc.profile.ProfileView;

public class Main {
    public static void main(String[] args) {
        ProfileView profileView = new ProfileView();
        ProfileController  profileController = new ProfileController(profileView);
        profileController.mainMenu();
    }
}

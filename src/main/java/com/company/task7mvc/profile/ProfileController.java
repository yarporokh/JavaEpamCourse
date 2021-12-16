package com.company.task7mvc.profile;

import com.company.task7mvc.game.GameController;
import com.company.task7mvc.game.GameModel;
import com.company.task7mvc.game.GameView;

import java.util.HashMap;
import java.util.Scanner;

public class ProfileController {
    private ProfileModel profileModel;
    private ProfileView profileView;
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> allProfiles = new HashMap<>();

    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public void setProfileModel(String profileLogin, int attempts) {
        this.profileModel = new ProfileModel(profileLogin);
        profileModel.setNumberOfAttempts(attempts);
    }

    public void checkStatistic(String login) {
        profileView.profileInfo(login, allProfiles.get(login));
    }

    public void mainMenu() {

        while (true) {
            profileView.mainMenu();
            int scanner = sc.nextInt();

            if (scanner == 1) {
                // Show all profiles and their attempts
                profileView.profileInfo(allProfiles);
            } else if (scanner == 2) {
                // Show certain profile
                profileView.profManager();
                String login = sc.next();
                if (allProfiles.containsKey(login)) {
                    profileView.profileInfo(login, allProfiles.get(login));
                } else {
                    profileView.incorrectUser();
                }
            } else if (scanner == 3) {
                // Go to profile manager
                profileManager();
            } else {
                // Incorrect number
                profileView.incorrectNumber();
            }
        }
    }

    public void profileManager() {
        profileView.profManager();
        String login = sc.next();
        if (allProfiles.containsKey(login))
            setProfileModel(login, allProfiles.get(login));
        else
            setProfileModel(login, 0);

        startGame(); // Go to play game
    }

    public void startGame() {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gc = new GameController(gameModel, gameView);
        gc.game(); // Play a game

        // Update attempts info
        allProfiles.put(profileModel.getAccountLogin(),profileModel.getNumberOfAttempts() + gameModel.getHistoryOfNumbers().size());

        mainMenu(); // Go to begin
    }
}

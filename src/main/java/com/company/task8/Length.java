package com.company.task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Length {
    private Scanner file;
    private ArrayList<String> wordsArray;


    public Length() throws FileNotFoundException {
        file = new Scanner(new File("textfileLength.txt"));
        String str = file.nextLine();
        wordsArray = new ArrayList<String>(Arrays.asList(str.split(" ")));
    }

    public String getThreeWords() {
        wordsArray.sort((first, second) -> Integer.compare(second.length(), first.length())); // Sorting words by string length

        String res = wordsArray.get(0) + " ==> " + wordsArray.get(0).length() + "\n" +
                wordsArray.get(1) + " ==> " + wordsArray.get(1).length() + "\n" +
                wordsArray.get(2) + " ==> " + wordsArray.get(2).length();
        return res;
    }

}

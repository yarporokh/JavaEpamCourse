package com.company.task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Duplicates {
    Scanner file;
    private ArrayList<String> wordsArray;
    private ArrayList<StringBuilder> duplicatesWords = new ArrayList<>();

    public Duplicates() throws FileNotFoundException {
        file = new Scanner(new File("textfileDuplicates.txt"));
        String str = file.nextLine();
        wordsArray = new ArrayList<String>(Arrays.asList(str.split(" ")));
    }

    public String findDuplicates() {
        HashSet<String> tempset = new HashSet<>(wordsArray);

        int i = 0;

        for (String str : tempset) {
            StringBuilder sb = new StringBuilder(str.toUpperCase(Locale.ROOT));
            duplicatesWords.add(sb.reverse());

            i++;
            if (i == 3)
                break;
        }


        String res = duplicatesWords.get(0) + "\n" +
                duplicatesWords.get(1) + "\n" +
                duplicatesWords.get(2);

        return res;
    }
}

package com.company.task8;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map;

public class Frequency {
    private Map<String, Integer> words = new HashMap<>();
    private TreeMap<String, Integer> result = new TreeMap<>();
    private String[] wordsArray;
    private Scanner file;

    public Frequency() throws FileNotFoundException {
        file = new Scanner(new File("textfileFrequency.txt"));
        String str = file.nextLine();
        wordsArray = str.split(" ");
        setWordsFrequency();
    }


    private void setWordsFrequency() {
        for (String word : wordsArray) {
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        sortWords();
    }

    private void sortWords() {
        String[] tempWords = words.keySet().toArray(new String[0]);
        Integer[] tempNumbers = words.values().toArray(new Integer[0]);

        int n = tempNumbers.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (tempNumbers[j] < tempNumbers[j + 1]) {
                    int temp = tempNumbers[j];
                    tempNumbers[j] = tempNumbers[j + 1];
                    tempNumbers[j + 1] = temp;

                    String tempStr = tempWords[j];
                    tempWords[j] = tempWords[j + 1];
                    tempWords[j + 1] = tempStr;
                }

        for (int i = 0; i < 3; i++) {
            result.put(tempWords[i], tempNumbers[i]);
        }
    }

    public String getResult() {
        String res = "";
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            res += key + " ==> " + value + "\n";
        }
        return res;
    }
}

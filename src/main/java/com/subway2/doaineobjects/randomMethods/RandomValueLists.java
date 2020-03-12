package com.subway2.doaineobjects.randomMethods;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueLists {

    public static List adcToList(String alphabet) {
//        alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        Random generate = new Random();
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int randomInt = generate.nextInt(alphabet.length());
            char c = alphabet.charAt(randomInt);
            chars.add(c);
        }

        return chars;
    }

    public static List numToList(Long time) {
        List<Integer> digits = new ArrayList<>();

//        time = System.currentTimeMillis();
        String timeS = time.toString();

        for (char c : timeS.toCharArray()) {
            digits.add(Character.getNumericValue(c));
        }

        return digits;
    }

}

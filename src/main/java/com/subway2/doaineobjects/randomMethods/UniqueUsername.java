package com.subway2.doaineobjects.randomMethods;

import com.subway2.doaineobjects.randomMethods.RandomValueLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniqueUsername extends RandomValueLists {
    Random generate = new Random();

    public String username(String alphabet, Long time){
        List<Character> usernameList = new ArrayList<>();

        List<Integer> myDigits = numToList(time);
        List<Character> myLetters = adcToList(alphabet);

        for (int nameLength = 0; nameLength < 8; nameLength++){
            int randomInt = generate.nextInt(myDigits.size());
            int timeDigit = myDigits.get(randomInt);

            char letter = myLetters.get(timeDigit);
            usernameList.add(letter);
        }
//        usernameList = myDigits.stream()
//                .map(num -> myDigits.get(num));

        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < usernameList.size(); i++){
//            sb.append(usernameList.get(i));
//        }
        //Declarative approach
        usernameList.stream()
                .forEach(c -> sb.append(c));

        String username = "user-" + sb;
        return username;
    }

}

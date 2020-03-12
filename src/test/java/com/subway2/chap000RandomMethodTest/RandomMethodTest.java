package com.subway2.chap000RandomMethodTest;

import com.subway2.doaineobjects.randomMethods.UniqueUsername;
import org.junit.jupiter.api.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomMethodTest {
    @Test
    public void verifyRandoms() {

        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

        Random generate = new Random();
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int randomInt = generate.nextInt(alphabet.length());
            char c = alphabet.charAt(randomInt);
            chars.add(c);
        }
        System.out.println(chars);

        List<Integer> digits = new ArrayList<>();

        long time = System.currentTimeMillis();
        String timeS = Long.toString(time);

        for (char c : timeS.toCharArray()) {
            digits.add(Character.getNumericValue(c));
        }
        System.out.println(digits);

        //.....................................
        // Create random chars

        List<Character> usernameList = new ArrayList<>();

        for (int nameLength = 0; nameLength < 8; nameLength++){
            int randomInt = generate.nextInt(digits.size());
            int timeDigit = digits.get(randomInt);

            char letter = chars.get(timeDigit);
            usernameList.add(letter);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < usernameList.size(); i++){
            sb.append(usernameList.get(i));
        }

        String username = "user-" + sb;
        System.out.println(username);

    }

    @Test
    public void verifyMySkills(){
        UniqueUsername user = new UniqueUsername();
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        long time = System.nanoTime();

        List<String> usernames = new ArrayList<>();
        HashSet<String> setNames = new HashSet<>();

        for (int i = 0; i < 100; i++){
            String username = user.username(alphabet, time);
            usernames.add(username);
            setNames.add(username);
        }
        System.out.println(usernames.size() + "\n" + setNames.size());

        int allNames = usernames.size();
        int setAllNames = setNames.size();

        assertEquals(allNames , setAllNames);
    }
}

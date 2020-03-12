package com.subway2.chap021collectionsrevisited.examples;

import com.subway2.domainentities.DuplicateUserComparator;
import com.subway2.domainentities.House;
import com.subway2.domainentities.User;
import com.subway2.domainentities.UserComparator;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {
    @Test
    public void verifyDifference() {
        Collection<Integer> simple = new ArrayList<>();
        List<Integer> justList = new ArrayList<>();
    }

    @Test
    public void exampleSetTest() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("a");
        alphaset.add("b");
        alphaset.add("a");
        alphaset.add("c");

        assertEquals(4, alphaset.size());

        String[] alphas = new String[alphaset.size()];
        alphaset.toArray(alphas);

        System.out.println(Arrays.toString(alphas));

        assertEquals("a", alphas[0]);
        assertEquals("b", alphas[1]);
        assertEquals("c", alphas[2]);
        assertEquals("d", alphas[3]);

        System.out.println(alphaset.headSet("c"));
        System.out.println(alphaset.tailSet("c"));
        System.out.println(alphaset.subSet("b", "d"));
    }

    @Test
    public void canRetrieveFirstFromSortedSet() {
        SortedSet<String> alphaset = new TreeSet<>();

        alphaset.add("c");
        assertEquals("c", alphaset.first());
        assertEquals("c", alphaset.last());

        alphaset.add("d");
        assertEquals("c", alphaset.first());
        assertEquals("d", alphaset.last());


        alphaset.add("b");
        assertEquals("b", alphaset.first());
        assertEquals("d", alphaset.last());


        alphaset.add("a");
        assertEquals("a", alphaset.first());
        assertEquals("d", alphaset.last());

        alphaset.add("555555");
        assertEquals("555555", alphaset.first());

        SortedSet<String> subset = alphaset.tailSet("c");
        assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);
        assertEquals("c", alphas[0]);
        assertEquals("d", alphas[1]);

    }

    @Test
    public void verifyExampleFromInternetComparable() {
        House house1 = new House(22, 195000, "Washington", false);
        House house2 = new House(51, 1195000, "New York", true);
        House house3 = new House(21, 180000, "New York", false);
        House house4 = new House(23, 200000, "Chicago", false);
        House house5 = new House(23, 200000, "London", false);

        SortedSet<House> houseCatalog = new TreeSet<>();
        houseCatalog.add(house1);
        houseCatalog.add(house2);
        assertEquals(house1, houseCatalog.first());
        houseCatalog.add(house4);
        assertEquals(house1, houseCatalog.first());
        houseCatalog.add(house3);
        assertEquals(house3, houseCatalog.first());
        houseCatalog.add(house5); // it is SorterSet motherfucker


        System.out.println(houseCatalog);
    }

    @Test
    public void verifyUserSetWithComparator() {
        User user = new User();
        User sasha = new User("sasha", "password1"); // 14
        User bogdan = new User("bogdan", "passwooooord2"); // 19
        User harry = new User("harry", "pass1"); // 10
        User hilary = new User("hilary", "passwordd1"); // 15
        User alex = new User("alex", "passcoder"); // 13
        User aleg = new User("aleg", "passcoder"); // 13
        User alex2 = new User("alex", "passc");
        User alex3 = new User("alex", "passc");
        User alex4 = new User("alex", "passcodddddd");

        SortedSet<User> userSortedList = new TreeSet<User>(new DuplicateUserComparator());

        userSortedList.add(sasha);
        userSortedList.add(bogdan);
        userSortedList.add(harry);
        userSortedList.add(hilary);
        userSortedList.add(alex);
        userSortedList.add(aleg);
        userSortedList.add(alex2);
        userSortedList.add(alex3);
        userSortedList.add(alex4);

//        System.out.println(userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        int num = 1;
        for (User i : users) {
            System.out.println(num + ". Username: " + i.getUsername() + ", password: " + i.getPassword());
            num++;
        }
//        Arrays.stream(users)
//                .filter(userLoop -> userLoop.getUsername().equals(us.getUsername()))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

//        assertEquals(sasha.getUsername(), users[3].getUsername());

        // Sort usernames by alphabetical order
        SortedSet<String> userSortedAlphabet = new TreeSet<>();

        userSortedAlphabet.add(sasha.getUsername());
        userSortedAlphabet.add(bogdan.getUsername());
        userSortedAlphabet.add(harry.getUsername());
        userSortedAlphabet.add(hilary.getUsername());
        userSortedAlphabet.add(alex.getUsername());
        userSortedAlphabet.add(alex2.getUsername());
        userSortedAlphabet.add(alex3.getUsername());
        userSortedAlphabet.add(alex4.getUsername());

        System.out.println("\n Sort in alphabetical order \n" + userSortedAlphabet.toString());
    }

    @Test
    public void verifyMap() {
        SortedMap<String, String> myMap = new TreeMap<>();
        myMap.comparator();
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        myMap.put("key3", "value3");
        myMap.put("key4", "value4");
        myMap.put("key10", "value10");
        myMap.put("key5", "value5");
        myMap.put("key9", "value9");
        myMap.put("key11", "value11");

        assertEquals("key1", myMap.firstKey());
//        assertEquals("key6", myMap.lastKey());
        System.out.println(myMap.get("key10") + "\n" + myMap.keySet());

        SortedMap<String, String> headMap;
        headMap = myMap.headMap("key3");
        assertEquals(4, headMap.size());

        SortedMap<String, String> tailMap;
        tailMap = myMap.tailMap("key3");
        assertEquals(4, tailMap.size());
    }

    @Test
    public void userMapValue() {
        SortedMap<User, String> usersMap = new TreeMap<>(new DuplicateUserComparator());
        User alex = new User("alex", "password");
        User oleg = new User("oleg", "password");
        User veronika = new User("veronika", "password");
        User veronika2 = new User("veronika", "password");

        usersMap.put(alex, "VP of Engineering");
        usersMap.put(oleg, "Manager");
        usersMap.put(veronika, "Doctor");
        usersMap.put(veronika, "Doctor2");
        usersMap.put(veronika2, "Doctor");

        for (User i : usersMap.keySet()){
            System.out.println(i.getUsername() + " --- " + i.getPassword() + " --- " + usersMap.get(i));
        }

        User[] users = new User[usersMap.size()];
        usersMap.keySet().toArray(users);

        assertEquals(alex.getUsername(), users[0].getUsername());
        assertEquals(oleg.getUsername(), users[1].getUsername());
        assertEquals(veronika.getUsername(), users[2].getUsername());
    }
    //...........................................................................................
    //EXERCISE: Access Values in a Map in Key order
    @Test
    public void myKeyOrder(){
        List<Integer> digits = new ArrayList<>();
        Map<Integer, String> numbers = new LinkedHashMap<>();
        SortedSet<Integer> keys = new TreeSet<>();

        long timeWhole = System.currentTimeMillis();
        String time = valueOf(timeWhole);
        System.out.println(time);

        for (char c : time.toCharArray()){
            digits.add(Character.getNumericValue(c));
            for (int i : digits){
                numbers.put(i, "test-" + i);
                for (int x : numbers.keySet()){
                    keys.add(x);
                }
            }
        }
        System.out.println(numbers.keySet());
        System.out.println(keys.toString());

    }
}


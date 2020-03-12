package com.subway2.domainentities;

import java.util.Comparator;

public class DuplicateUserComparator extends UserComparator implements Comparator {

    public int compare(Object oUser1, Object oUser2) {

        User user1 = (User)oUser1;
        User user2 = (User)oUser2;

        int duplicate = user1.getUsername().compareTo(user2.getUsername());

        return duplicate;
    }

}

package edu.uncc.cci.mobileapps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MainPart2 {
    /*
    * Question 2:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to count the number of users living each state.
    * - Print out the list of State, Count order in ascending order by count.
    * */

    public static void main(String[] args) {

        HashMap<String, Integer> countMap = new HashMap<> ();

        //example on how to access the Data.users array.
        for (String str : Data.users) {
            String[] temp = str.split (",");
            User user = new User();
            user.setFirstname (temp[0]);
            user.setLastname (temp[1]);
            user.setAge (Integer.parseInt (temp[2]));
            user.setEmail (temp[3]);
            user.setGender (temp[4]);
            user.setCity (temp[5]);
            user.setState (temp[6]);

            countMap.put (user.getState (), countMap.getOrDefault (user.getState (), 0) +1);
        }
        countMap.entrySet().stream()
                .sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }
}
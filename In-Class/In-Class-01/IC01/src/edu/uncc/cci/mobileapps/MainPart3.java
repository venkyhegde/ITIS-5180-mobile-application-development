package edu.uncc.cci.mobileapps;

import java.util.*;

public class MainPart3 {
    /*
    * Question 3:
    * - In this question you will use the Data.users and Data.otherUsers array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to print out the users that are exist in both the Data.users and Data.otherUsers.
    * Two users are equal if all their attributes are equal.
    * - Print out the list of users which exist in both Data.users and Data.otherUsers.
    * */

    public static void main(String[] args) {

        Set<User> userList = new LinkedHashSet<User>();
        List<User> finalList = new ArrayList<> ();

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

            userList.add (user);
        }

        for( String str: Data.otherUsers){
            String[] temp = str.split (",");
            User user = new User();
            user.setFirstname (temp[0]);
            user.setLastname (temp[1]);
            user.setAge (Integer.parseInt (temp[2]));
            user.setEmail (temp[3]);
            user.setGender (temp[4]);
            user.setCity (temp[5]);
            user.setState (temp[6]);
            if(userList.contains (user)){
                finalList.add (user);
            }
        }

        for(User user: finalList)
            System.out.println (user);
    }
}
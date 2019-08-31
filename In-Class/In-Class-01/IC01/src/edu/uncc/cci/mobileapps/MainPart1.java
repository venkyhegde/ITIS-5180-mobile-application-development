package edu.uncc.cci.mobileapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainPart1 {
    /*
    * Question 1:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - Insert each of the users in a list.
    * - Print out the TOP 10 oldest users.
    * */

    public static void main(String[] args) {
        List<User> userList = new ArrayList<User> ();
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
           userList.add (user);
        }

        Collections.sort (userList, ((o1, o2) -> (o1.getAge () < o2.getAge ()) ? 1 : (o1.getAge () > o2.getAge ()) ?  -1 :  0));

        for(int i=0; i<10; i++){
            System.out.println (userList.get (i));
        }
    }
}
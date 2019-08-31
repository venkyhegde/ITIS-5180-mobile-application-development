package edu.uncc.cci.mobileapps;

//import java.util.HashMap;

import java.util.HashMap;

public class MainPart4{
    /*
      Question 4
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record. Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element in the array represents a single item record. Each record is a string formatted as : ID, quantity. You are asked to perform the following tasks:
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record.
      Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called
      shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element the array represents a single item record. Each record is a string formatted as : ID,quantity. You are asked to perform the following tasks:
     1. Your implementation for this question should be included in MainPart3.java file.
     2. Create a StoreItem class that should parse all the parameters for each item. Hint: extract each value from a item's record using Java's String.split() method and set the
        delimiter to a comma, see provided code below. Each item record should to be assigned to a StoreItem object.
     3. Create the most efficient data structure that best fit the goal. Hint: The selected data structure should facilitate the retrieval of the item details based on the ID.
     4. The goal is to print out the receipt bill in the following format:
        ID  Name    Quantity    Price * Quantity
        123 Tomatoes 10         $30
        .
        .
        Total Bill: $400
    */

    public static void main(String[] args) {

        HashMap<Integer, Integer> shoppingCart = new HashMap<> ();
        for(String str: Data.shoppingCart){
            String[] temp = str.split (",");
            shoppingCart.put (Integer.parseInt (temp[0]), Integer.parseInt (temp[1]));
        }

        for(String str: Data.items){
            String[] temp = str.split (",");
            StoreItem item = new StoreItem ();
            item.setName (temp[0]);
            item.setId (Integer.parseInt (temp[1]));
            item.setPrice (Double.parseDouble (temp[2]));
            if(shoppingCart.containsKey (item.getId ())){
                System.out.println ("ID \t Name \t Quantity \t Price * Quantity");
                System.out.print (item.getId ()+"\t");
                System.out.print (item.getName ()+"\t");
                System.out.print (shoppingCart.get (item.getId ())+"\t");
                System.out.print (shoppingCart.get (item.getId ()) * item.getPrice ()+"\t");
                System.out.println ();
            }

        }
    }
}
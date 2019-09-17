package edu.uncc.bmicalculator.utility;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
/**
 * Homework 01
 * InputRange.java
 * Chaitanya Deshpande, Akash Atul Khiste, Venky Shantharam Hegde
 */

public class InputRange implements InputFilter {
    private int minValue;
    private int maxValue;

    /**
     * Constructor
     * @param minValue
     * @param maxValue
     */
    public InputRange(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * This method checks if the input is in range or not.
     * @param input - input entered by user
     * @return boolean. Returns true if input is in range, else returns false;
     */
    private boolean checkRange(float input){
        return (input >= this.minValue && input < this.maxValue);
    }

    /**
     * This method checks if the input is in range or not.
     * @param input - input entered by user
     * @return boolean. Returns true if input is in range, else returns false;
     */
    private boolean checkRange(int input){
        return (input >= this.minValue && input < this.maxValue);
    }

    /**
     * This method checks if the input is in range or not.
     * @param input - input entered by user
     * @return boolean. Returns true if input is in range, else returns false;
     */
    private boolean checkRange(double input){
        return (input >= this.minValue && input < this.maxValue);
    }


    @Override
    public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
        try {
            // getting input
            float ipNumber = Float.parseFloat(spanned.toString() + charSequence.toString());
            // check if the number is in range.
            if (checkRange(ipNumber))
                return null;
        }catch (NumberFormatException e){
            Log.e("error", e.getMessage());
        }
        return "";
    }
}

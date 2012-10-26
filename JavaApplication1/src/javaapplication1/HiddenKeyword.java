/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class HiddenKeyword {

    private String fValue;
    private StringBuffer pValue;
    public int lfoundNumber = 0;
    public String rword;
    private final int errors;

    public HiddenKeyword() {
        /*
         * Setting the errors to 0
         */
        errors = 0;
        init();
    }

    private void init() {
        /*
         * Enter the wordslist, separated by a | here:
         */
        String str = "dark|water|watermelon|country|cat|rule|papaya|big|yellow|law|orange|small|pen|knife|option|hair|computer|spoon|keyboard|hard|notebook|life|box|black|paper|fork|show|dream|phone|change|done|sexy|mouse|chair|blue|rice|body|scissors|telephone|milk|moon|ball|call|friut|soap|medicine|red|cold|flower|engineer|work|summer|pink|food|clock|rain|environment|drink|green|warm|science|apple|tree|hospital|air|banana|school|game|shoe|internet|univercity|picture|fire|city";
        String[] temp;

        /*
         * delimiter
         */
        String delimiter = "\\|";

        /*
         * given string will be split by the argument delimiter provided.
         */
        temp = str.split(delimiter);  // แบ่งเป็นคำๆ

        /*
         * Setting the seed
         */
        Random randomGenerator = new Random();

        /*
         * Generating random number
         */
        int randomInt = randomGenerator.nextInt(temp.length);
        this.setRword(new String(temp[randomInt]));
    }

    public void setRword(String rword) {
        this.rword = rword;
        char positions[] = new char[rword.length()];
        for (int i = 0; i < rword.length(); i++) {
            positions[i] = '-';

        }
        String s = new String(positions);
        pValue = new StringBuffer(s);       
    }
    
    public boolean found() {
        System.out.println("Letters found:" + lfoundNumber/2 + "/" + getRword().length());
        return (lfoundNumber/2 == getRword().length());
    }

    public boolean guess(char c) {
        int index = getRword().indexOf(c);
        if (index == -1) {
            return false;
        } else {
            lfoundNumber = lfoundNumber + findOccurances(c);
            return true;
        }
    }

    private int findOccurances(char c) {
        int idx = getRword().indexOf(c);
        pValue.setCharAt(idx, getRword().charAt(idx));
        int counter = 1;
        while (idx != -1) {
            int idxx = getRword().indexOf(c, idx + 1);
            idx = idxx;
            if (idx != -1) {
                counter++;
                pValue.setCharAt(idx, getRword().charAt(idx));
            }
        }
        return counter;
    }

    public void print() {
        System.out.println(pValue);
    }

    /**
     * @return the rword
     */
    public String getRword() {
        return rword;
    }

    @Override
    public String toString() {
        return pValue.toString();
    }
}
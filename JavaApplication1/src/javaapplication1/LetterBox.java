/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Administrator
 */
public class LetterBox {

    private char[] lbox = new char[24];
    private int counter = 0;

    public boolean contains(char c) {
        for (int i = 0; i < counter; i++) {
            if (lbox[i] == c) {
                return true;
            }
        }
        lbox[counter] = c;
        counter++;
        return false;
    }

    public void print() {
        System.out.print("\nLetterBox:");
        for (int i = 0; i < counter; i++) {
            System.out.print(lbox[i]);
        }
        System.out.println("");
    }
}

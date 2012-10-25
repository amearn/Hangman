/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Random;

/**
 *
 * @author Usre
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hangman a = new Hangman();
        

        }
    
    class HangmanSession {
  
         private HiddenKeyword hiddenKeyword;
         private LetterBox letterBox;
         private int triesNumber = 7;
  

    public HangmanSession() {
   
         hiddenKeyword = new HiddenKeyword();
         letterBox = new LetterBox();
  }
   class HiddenKeyword {
        private String rword;
        private StringBuffer pValue;
        private int lfoundNumber = 0;

        public HiddenKeyword() {
      
      
        String str = "computer|radio|calculator|teacher|bureau|police|geometry|president|subject|country|enviroment|classroom|animals|province|month|politics|puzzle|instrument|kitchen|language|vampire|ghost|solution|service|software|virus25|security|phonenumber|expert|website|agreement|support|compatibility|advanced|search|triathlon|immediately|encyclopedia|endurance|distance|nature|history|organization|international|championship|government|popularity|thousand|feature|wetsuit|fitness|legendary|variation|equal|approximately|segment|priority|physics|branche|science|mathematics|lightning|dispersion|accelerator|detector|terminology|design|operation|foundation|application|prediction|reference|measurement|concept|perspective|overview|position|airplane|symmetry|dimension|toxic|algebra|illustration|classic|verification|citation|unusual|resource|analysis|license|comedy|screenplay|production|release|emphasis|director|trademark|vehicle|aircraft|experiment";
                String[] temp;
				
                /* delimiter */
                String delimiter = "\\|";
				
                /* given string will be split by the argument delimiter provided. */
                temp = str.split(delimiter);  // แบ่งเป็นคำๆ
				
		/* Setting the seed */
		Random randomGenerator = new Random();
				
		/* Generating random number */
		int randomInt = randomGenerator.nextInt(temp.length);
                
                  rword = new String(temp[randomInt]);
                  char positions[] = new char[rword.length()];
                  System.out.print(rword);
                  
                for (int i=0; i<rword.length(); i++) {
                        positions[i] = '-';
                }
                
                String s = new String(positions);
                System.out.print(s);
//                gword = new StringBuffer(s);
//                tfLetter.setText("");
//  
//                // Delete the messages
//                message="";
//                information = "";
//                repaint();

        } 
    
    
    }
   
        class LetterBox {
            private char[] lbox = new char[24];
            private int counter = 0;

        public boolean contains( char c ) {
            for( int i = 0; i < counter; i++ ) {
             if( lbox[i] == c )
            return true;
        }
            lbox[counter] = c;
            counter++;
            return false;
            }
        }
        
    }
}
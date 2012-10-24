
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * text based version of hangman
 */
public class Hangman_1 {
  public static void main( String[] args ) {
    HangmanSession hangmanSession = new HangmanSession();
    hangmanSession.play();
  }
}
class HangmanSession {
  private Player player;
  private HiddenKeyword hiddenKeyword;
  private LetterBox letterBox;
  private int triesNumber = 7;

  public HangmanSession() {
    player = new Player();
    player.askName();
    hiddenKeyword = new HiddenKeyword();
    letterBox = new LetterBox();
  }

  private void printState() {
    letterBox.print();
    System.out.print( "Hidden word : " );
    hiddenKeyword.print();
    System.out.print( "Tries left: " + triesNumber + "\n<guess letter:>" );
  }

  public void play() {
    boolean bool = true;
    while( true ) {
      bool = true;
      printState();
      char ch = player.takeGuess();
      if( letterBox.contains( ch ) ) {
        System.out.println( "Try again, you've already used letter " + ch );
        bool = false;
      }
      if( bool ) {
        if( hiddenKeyword.guess( ch ) ) {
          System.out.println( "Success, you have found letter " + ch );
        }
        else {
          triesNumber--;
        }
        if( triesNumber < 1 )
          gameOver();

        if( hiddenKeyword.found() )
          congratulations();
      }
    } //end of bool
  }

  public void congratulations() {
    System.out.println( "Congratulations " + player + ", you win a banana!" );
    System.exit( 0 );
  }

  public void gameOver() {
    System.out.println( "Sorry " + player + ", this time you lose!" );
    System.exit( 0 );
  }
}



class HiddenKeyword {
  private String fValue;
  private StringBuffer pValue;
  private int lfoundNumber = 0;
  String rword;
  private final int errors;

  public HiddenKeyword() {
      
      
      
      
                  
      		/* Setting the errors to 0 */
                errors=0;
				
				
		/* Enter the wordslist, separated by a | here: */
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
                for (int i=0; i<rword.length(); i++) {
                        positions[i] = '_';
    fValue = new String( "banana" );
    pValue = new StringBuffer( "-------" );
  }

  public boolean found(){
    System.out.println( "Letters found:" + lfoundNumber + "/" + rword.length() );
    return ( lfoundNumber == rword.length() );
  }


  public boolean guess( char c ) {
    int index = fValue.indexOf( c );
    if( index == -1 )
      return false;
    else {
      lfoundNumber = lfoundNumber + findOccurances( c );
      return true;
    }
  }

  private int findOccurances( char c ) {
    int idx = fValue.indexOf( c );
    pValue.setCharAt( idx, fValue.charAt( idx ) );
    int counter = 1;
    while( idx != -1 ) {
      int idxx = fValue.indexOf( c, idx + 1 );
      idx = idxx;
      if( idx != -1 ) {
        counter++;
        pValue.setCharAt( idx, fValue.charAt( idx ) );
      }
    }
    return counter;
  }

  public void print() {
    System.out.println( pValue );
  }

}


class Player {
  private String fName = "";

  public void askName() {
    System.out.print( "\nPlayer, enter your name:" );
    fName = receiveInput();
  }

  public char takeGuess() {
    return receiveInput().charAt( 0 );
  }

  private String receiveInput() {
    String str = " ";
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    try {
      str = br.readLine();
    }
    catch( IOException ex ) {
      ex.printStackTrace();
    }
    return str;
  }

  public String toString() {
    return fName;
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

  public void print() {
    System.out.print( "\nLetterBox:" );
    for( int i = 0; i < counter; i++ ) {
      System.out.print( lbox[i] );
    }
    System.out.println( "" );
  }
}
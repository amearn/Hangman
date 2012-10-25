package javaapplication1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * text based version of hangman
 */
public class Hangman {
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
      
    System.out.println( "Congratulations " + player + ", you win ");
    System.exit( 0 );
  }

  public void gameOver() {
      
    System.out.println( "Sorry " + player + ", this time you lose!");
    System.exit( 0 );
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


/* @author: Timmy Macdonald, Mike Rice, Billy McCormick
 * DATE: 27 April 2009
 * PROGRAM NAME: Hangman.java
 * PROGRAM DESCRIPTION: Lets the user play the game of hangman.
 *
 *Copyright (C) 2009  Timmy Macdonald <timmy@tsmacdonald.com>
 *Copyright (C) 2009 Mike Rice
 *Copyright (C) 2009 Billy McCormick

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

//import statements
import java.util.*;
import java.io.*;
import java.lang.Math;
 
public class Hangman
{
	//global variables
	public static ArrayList<String> wordList;
	public static String word;
	public static String guess;
	public static int numGuesses = 0;
	public static Scanner scan = new Scanner(System.in);
	
	//global constants
	public static final int MAX_GUESSES = 6;
	public static final String fileName = "words.txt";
	

 
 	/* Display the instructions for the game.
 	 */
 	public static void displayInstructions()
 	{
		System.out.println("1. Guess a letter. If you get it right the letter will appear in the proper places. "+
			"If you are incorrect a body part will be added to the hangman. You will get six tries. If the body"+
			" is completed, you lose! So guess wisely.");

 	}
 
 	/**
  	* Determines if the game is done or still playing.
  	* Returns true if it is won or lost.
  	* Returns false otherwise.
  	*/
  	public static boolean done()
	{
		if(lost() || won())
		{
			return true;
		}
		return false;
		
	}
 
  	/**
  	* Determines if the game has been won by guessing the word.
  	*/
 	public static boolean won()
 	{
  		if(guess.equals(word))
  		{
  			return true;
  		}
  		
  		return false;
 	}
 
 	/**
  	* Determines if the game has been lost.
  	*/
 	public static boolean lost()
 	{
		if(numGuesses == MAX_GUESSES)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
 
  	/**
  	* Determines whether the word contains the user's guess.
  	*/
 	public static boolean hasLetter(String guess, String word)
 	{

		if(word.indexOf(guess) != -1)//guess is not in word
		{
			return true;
		}
			return false;

		
 	}

 	/**
  	* Replaces letter in word with "-"
  	* Replaces the corresponding letter in guess with letter.
  	* It must account for every instance of letter.
  	*/ 	
  	public static void addGuess(String letter)
  	{
  		int index = 0;
  		int len = guess.length();
  		
  		for(int i = 0; i < len; i++)
  		{
	  		index = word.indexOf(letter, index);

	  		if (index != -1)//Check to make sure letter is in the guess
	  		{
		  		String start = guess.substring(0, index);
		  		//substring from (index + 1) to start with the letter
		  		//after the letter guessed
		  		String end = guess.substring((index + 1), guess.length());
		  		guess = start + letter + end;
		  		index++;  //increment index to move to the next letter in word
	  		}
  		}
  	}
  	
 	/**
  	* Prompts the user for a letter.
  	* Return user's input.
  	*/
 	public static String getGuess()
 	{
  		System.out.print("Please enter a guess: ");
  		return scan.next();
 	}
 
 	/**
  	* Returns a string of length size.
  	* The string will contain only "-" characters.
  	*/
 	public static String setEmptyString(int size)
 	{
		size = word.length();
		guess ="";
		
		for(int count = 0; count < size; count++)
		{
			guess += "-";
		}
		
		return guess;
 	}
  
 	/**
  	* Chooses a word from the ArrayList.
  	* Returns the chosen word as a String.
  	* The word is chosen at random.
	*/
 	public static String chooseWord(ArrayList<String> list)
 	{
  		int index = (int)(Math.random() * list.size());
  
  		return list.get(index);
 	}
  
 	/**
  	* Gets a list of words from the given file.
  	* Returns the list as an ArrayList of Strings.
  	*/
 	public static ArrayList<String> getWords(String fileName) throws FileNotFoundException
 	{
   		Scanner file = new Scanner(new File(fileName));
  
  		ArrayList<String> words = new ArrayList<String>();
 
  		while(file.hasNextLine())
  		{
   			words.add(file.nextLine());
  		}
  		
  		return words;
 	}
 	
 	/**
 	 *Draws the gallows.
 	 */
 	public static void drawGallows()
 	{
 		//Declare some body parts
 		String top = 
 		"...............................\n"+
 		"|    .........................|\n"+
 		"|    /            |            ";
 		
 		String head = 
 		"|    |           ___           \n"+
 		"|    |          /x x\\          \n"+
 		"|    |          \\ - /          \n"+
 		"|    |            |              ";
 		
 		String noHead = 
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|    |                           ";
 		
 		String body =
 		"|    |            |            \n"+
 		"|    |            |            \n"+
 		"|    |            |            \n"+
 		"|    |            |              ";
 		
 		String noBody =
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|    |                           ";
 		
 		String arm =
 		"|    |         /==|            \n"+
 		"|    |        /   |              ";
 		
 		String arms =
 		"|    |         /==|==\\         \n"+
 		"|    |        /   |   \\          ";
 		
 		String noArms =
 		"|    |                         \n"+
 		"|    |                           ";
 		String leg =
 		"|    |           /             \n"+
 		"|    |          /              \n"+
 		"|    |        _/   			  ";
 		
 		String bothLegs =
 		"|    |           /  \\         \n"+
 		"|    |          /    \\        \n"+
 		"|    |        _/      \\_        ";
 		
 		String noLegs =
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|    |                           ";
 		
 		String bottom =
 		"|    |                         \n"+
 		"|    |                         \n"+
 		"|     \\                        \n"+
 		"-------------------------------  ";
 		
 	
 		//Actually draw it, based on how many guesses are done
 		switch(numGuesses)
 		{
 			case 0:
 			{
 				System.out.println(top);
 				System.out.println(noHead);
 				System.out.println(noArms);
 				System.out.println(noBody);
 				System.out.println(noLegs);
 				System.out.println(bottom);
 				break;
 			}
 			case 1:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(noArms);
 				System.out.println(noBody);
 				System.out.println(noLegs);
 				System.out.println(bottom);
 				break;
 			}
 			case 2:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(arm);
 				System.out.println(noBody);
 				System.out.println(noLegs);
 				System.out.println(bottom);
 				break;
 			}
 			case 3:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(arms);
 				System.out.println(noBody);
 				System.out.println(noLegs);
 				System.out.println(bottom);
 				break;
 			}
 			case 4:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(arms);
 				System.out.println(body);
 				System.out.println(noLegs);
 				System.out.println(bottom);
 				break;
 			}
 			case 5:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(arms);
 				System.out.println(body);
 				System.out.println(leg);
 				System.out.println(bottom);
 				break;
 			}
 			case 6:
 			{
 				System.out.println(top);
 				System.out.println(head);
 				System.out.println(arms);
 				System.out.println(body);
 				System.out.println(bothLegs);
 				System.out.println(bottom);
 				break;
 			}
 		}
	
	}
 	
 
 	/**
  	* The main loop for gameplay. Calling various methods, it gets input, evaluates what should happen with
  	* word and guess, draws the gallows, and deals with winning and losing appropriately.
  	*/
 	public static void playGame()
 	{
 		String letterList = "";//A string with space-separated letters already guessed.
 		String letter;//The user's input
		while(!done())//The main loop for getting and evaluating a guess.
		{
			/* Print guess */
 			System.out.println(guess); 	
			if(letterList.length() > 0)
			{
					System.out.println("Letters already guessed: " + letterList);
			}
			/*Get user input */
			letter = getGuess();
			
			/*Add to letterList */
			letterList += letter + " ";
						
			/*Evaluate whether it matches word*/
			if(letter.equals(word))//The guess is the word--break out of guessing loop.
			{
				break;
			}
			else if(letter.length() > 1)//They guessed a word, but it was wrong.
			{
				System.out.println("Wrong word!");
				numGuesses++;
			}
			else//It's a single letter guess
			{
				if(hasLetter(letter, word))//Good guess
				{
					addGuess(letter);//Reflect the guess in the word
				}
				else//Bad guess
				{
					numGuesses++;
					System.out.println("Bad guess!");
				}
			}	
			drawGallows();//Redraw the gallows
					
		}		
 	}
 	
 	public static void main(String[] args) throws FileNotFoundException
	{
		boolean playAgain = true;
		String userInput;
		while(playAgain)
 		{
	 		//initializes wordList by getting the words from fileName.
	  		//initializes word by choosing a word from wordList.
	  		//initializes guess as an empty string.
	  		displayInstructions();
	  		System.out.println("");
	  		System.out.println("Here is your word template");
	 		wordList = getWords(fileName);
	   		word = chooseWord(wordList);
	   		guess = setEmptyString(word.length());
	   		
	   		playGame();//The main loop
	 		
	 		if(lost())
	 		{ 		
	 			System.out.println("You fail at life. Or at least at hangman."
	 				+ ".<||{GAME OVER!}||>.");
	
	 		}
	 		else//Win
	 		{
	 			System.out.println("");
	 			System.out.println("Good job! You won!");
	 			System.out.println("The word was " + word);
	 			System.out.println("\n\n         ^__^\n"+
	                                   "         (oo) < {Moo!!!}\n"+
	                                   "   /-----(__)\n"+
	                                   "  / | ||     \n"+
	                                   " * /\\---/\\   \n"+
	                                   "    ~~ ~~    \n");
	 		}
	 	
		
			boolean validInput = false;
			while(!validInput)
			{
				System.out.print("Want to play again? (y or n) : ");
				userInput = scan.next();
				if(userInput.equals("y"))
				{
					validInput = true;
					playAgain = true;
					numGuesses = 0;
				}
				if(userInput.equals("n"))
				{
					validInput = true;
					playAgain = false;
				}          
			}
 		}
	}
}

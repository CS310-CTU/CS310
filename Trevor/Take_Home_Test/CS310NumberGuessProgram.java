/**
 *
 * @author  Trevor Cullingsworth
 *          CS310 - Mobile App Programming
 *          Take home quiz - Question # 2 - number guessing program
 *          Purpose:
 *          	- Generate a random number between -10 to +10. 
 *          	- Note: It MUST be able to crank out both POSITIVE and NEGATIVE numbers RANDOMLY.
 *          	- Ask the user to guess the number, and let the user have 5 tries.
 *          	- If the user DOES  guess the correct number, then have the program print out to the 
 *          	  screen the following message:
 *          		"CONGRATULATIONS! You GUESSED IT!!!"
 *          	- If the user does NOT guess the correct number, then have the code print out the 
 *          	  following message:
 *          		"You didn’t guess the correct number, you DOLT!!"
 *          		"The CORRECT NUMBER is: <numberYourProgramGenerated>"
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class CS310NumberGuessProgram {
	
	//----------------------------------------------------------------------
	// FUNCTIONS
	//----------------------------------------------------------------------
	
	public static int generateRandomNumber(int minRange, int maxRange)
	{
	    Random randomNumber = new Random();
	    return randomNumber.nextInt((maxRange - minRange) + 1) + minRange;
	}
	
	//----------------------------------------------------------------------
	// MAIN
	//----------------------------------------------------------------------
	public static void main(String[] args) 
	{
		// Set up variables
		String inputString = "";
		int minRange = -10;
		int maxRange = 10;
		int NumberToGuess;
		int maxGuesses = 5;
		int userGuess;
		
		Scanner input = new Scanner(System.in);
		Boolean continueGame = true;
		
		// Set up user interface
        while(continueGame)
        {
        	System.out.println("----------------------------------------------");
            System.out.println("|  Come one Come all and guess the number!!! |");
            System.out.println("----------------------------------------------");
            System.out.println("|                                            |");
            System.out.println("| Try to guess the number I am thinking of   |");
            System.out.println("| between -10 and 10                         |");
            System.out.println("|                                            |");
            System.out.println("| You get 5 guesses                          |");
            System.out.println("----------------------------------------------");
            System.out.println();
            
            // Calls function generateRandomNumber to get random number between
            // -10 and 10 for a number the user is asked to guess
        	NumberToGuess = generateRandomNumber(minRange, maxRange);
        	int guessNumber = 1;
        	String correctGuess = "No";
        	
        	// user gets 5 guesses
        	while(guessNumber <= maxGuesses)
        	{
        		// Make sure user is entering a valid number
        		try
        		{
        			System.out.print("Guess # " + guessNumber + " : ");
        			userGuess = input.nextInt();
        			
        			if (userGuess == NumberToGuess)
            		{
            			System.out.println();
            			System.out.println("CONGRATULATIONS! You GUESSED IT!!!");
            			correctGuess = "Yes";
            			guessNumber = 6;
            		} else
            		{
            			if (userGuess < NumberToGuess)
            			{
            				System.out.println("Nope - higher");
            				System.out.println();
            				guessNumber++;
            			} else
            			{
            				System.out.println("Nope - lower");
            				System.out.println();
            				guessNumber++;
            			}
            		}
        		} catch (Exception E)
        		{
        			System.out.println();
        			System.out.println("You complete fool! Number guessing game means you actually enter");
        			System.out.println("a number as your guess.  Please try again with a VALID number");
        			System.out.println();
        			input.nextLine();
        		} 
        	}
        	
        	// Check if user guessed the number right within 5 guesses
        	// If not displkay to user what the number to guess was
        	if (correctGuess == "No")
        	{
        		System.out.println("You didn’t guess the correct number, you DOLT!!");
        		System.out.println("The CORRECT NUMBER is: " + NumberToGuess);
        	}
        	input.nextLine();
        	System.out.println();
        	
        	// Check if user wants to play game again
    		System.out.print("Do you wish to play again (Y / N)? ");
    		inputString = input.nextLine();
    		if (inputString.equals("y") || inputString.equals("Y"))
    		{
    			continueGame = true;
    		} else 
    		{
    			continueGame = false;
    		}
        }

	}

}

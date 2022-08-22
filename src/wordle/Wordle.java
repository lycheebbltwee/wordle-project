package wordle;

import java.util.Scanner;

public class Wordle {
	private static final int maximumGuesses = 6;

	public static void main(String[] args) {
		// New constructors
		User newUser = new User();
		new Computer();
		Word word = new Word();
		Scanner keyboard = new Scanner(System.in);
		
		// Generate a new random word
		String wordToBeGuessed = word.randomWord();
//		System.out.println(wordToBeGuessed);
		
		// Game instructions
		Computer.greeting();
		
		// Keep track of number of guesses
		int guessCount = 0;
		// Initiate game
		guessCount = checkGuess(newUser, keyboard, wordToBeGuessed, guessCount);
		
		// Display message based on number of guesses
		if (guessCount == 1) {
			System.out.println("You guessed it in one try!");
		} else if (guessCount < 6){
			System.out.println("You guessed it in " + guessCount + " tries!");
		} else {
			System.out.println("You failed to guess the word...");
		}
		
		keyboard.close();
		
	}

	private static int checkGuess(User newUser, Scanner keyboard, String wordToBeGuessed, int guessCount) {
		while (guessCount < maximumGuesses) {
			guessCount++;
			System.out.println("\n" + guessCount + ".");
			String guess = newUser.userGuess(keyboard);
			
			if(guess.equals(wordToBeGuessed)) {
				System.out.println("\nYou got it!\n");
				break;
		
			} else if (!guess.equals(wordToBeGuessed)) {
				
				for (int i = 0; i < guess.length(); i++) {
					if (!wordToBeGuessed.contains(String.valueOf(guess.charAt(i)))) {
						System.out.print("_ ");
					} else if (wordToBeGuessed.indexOf(guess.charAt(i)) == guess.indexOf(guess.charAt(i)) && wordToBeGuessed.contains(String.valueOf(guess.charAt(i)))) {
						System.out.print(guess.charAt(i) + " ");
					} else if (wordToBeGuessed.contains(String.valueOf(guess.charAt(i)))) {
						System.out.print("(" + guess.charAt(i) + ") ");
					} 
				}
				
				System.out.println();
			}
			
		}
		return guessCount;
	}

}

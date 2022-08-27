package wordle;

import java.util.List;
import java.util.Scanner;

public class Wordle {
	private static final int maximumGuesses = 6;
	
	public static String generateRandomWord(String src) {
		RandomWordList randomList = new RandomWordList(src);
		List<String> wordList = randomList.createRandomWordList();
		String randomWord = randomList.randomWord(wordList);
		System.out.println(randomWord);
		return randomWord;
	}
	
	public static void playWordle() {
		new Computer();
		Scanner keyboard = new Scanner(System.in);
		Computer.greeting();
		
		// Prompt user to play
		String response = Computer.askToPlay(keyboard);
		
		// Loop while user enters "y"
		while (response.equals("y")) {
			// Generate new random word
			String randomWord = generateRandomWord("src/wordle/word-list.json");
			// Counter for guesses
			int guessCount = 0;
			
			// Loop while maximum guess hasn't been reached
			while (guessCount < maximumGuesses) {
				// Increment guess counter
				guessCount++;
				
				// Display current guess count
				System.out.println("\n" + guessCount + ".");
				
				// Prompt user to make a guess
				String guess = userGuess(keyboard);
				
				// Guess word check for equality
				if (guess.equals(randomWord)) {
					System.out.println("\nYou got it!\n");
					break;
				} else {
					checkGuess(randomWord, guess, guessCount);
				};
			}
			
			// Display final guess count
			guessFinalMessage(guessCount);
			// Ask to play again
			response = Computer.askToPlay(keyboard);
		}
		keyboard.close();
	}
	
	public static String userGuess(Scanner s) {
		String userGuess;
		
		System.out.println("\nPlease enter a five-letter word:");
		userGuess = s.next();
		
		// Validation for guesses that are not repeating letters more than 2 times and is not 5 characters long
		while (userGuess.matches(".*([a-z])\\1{2}.*") || userGuess.length() != Word.wordLength ) {
			System.out.println("\nInvalid input. Please enter a five-letter word.\n");
			userGuess = s.next();
		}
		
		return userGuess;
	}
	
	public static void guessFinalMessage(int guessCount) {
		if (guessCount == 1) {
			System.out.println("You guessed it in one try!");
		} else if (guessCount < 6){
			System.out.println("You guessed it in " + guessCount + " tries!");
		} else {
			System.out.println("\nYou failed to guess the word...");
		}
	}
	
	public static void checkGuess(String randomWord, String userGuess, int guessCount) {
			System.out.println("\n" + guessCount + ".");
			
			if (!userGuess.equals(randomWord)) {
				
				for (int i = 0; i < userGuess.length(); i++) {
					char evalChar = userGuess.charAt(i);
					boolean containedInWord = randomWord.contains(String.valueOf(evalChar));
					
					if (!containedInWord) {
						System.out.print("_ ");
					} else if (containedInWord) {
						if (randomWord.indexOf(evalChar) == userGuess.indexOf(evalChar)) {
							System.out.print(evalChar + " ");
						} else {
						System.out.print("(" + evalChar + ") ");
						}
					} 
					
				}
				
				System.out.println();
			}

	}

}

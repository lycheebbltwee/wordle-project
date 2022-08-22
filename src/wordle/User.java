package wordle;

import java.util.Scanner;

public class User {
	/*
	 * Fields
	 */
	private String name;

	/*
	 * Constructor
	 */
	public User() {
	}
	
	public String getName() {
		return this.name;
	}
	
//	public void setName() {
//		// New scanner
//		Scanner scanner = new Scanner(System.in);
//		
//		// Prompt user name
//		System.out.println("\nPlease enter your name:");
//		String userName = scanner.nextLine();
//		
//		// Set user name
//		this.name = userName;
//		
//		scanner.close();
//	}

	
	public String userGuess(Scanner s) {
		
		// New user guess
		String userGuess;
		
	
		System.out.println("\nPlease enter a five-letter word:");
		userGuess = s.next();
		
		while (userGuess.matches(".*([a-z])\\1{2}.*") || userGuess.length() != Word.wordLength ) {
			System.out.println("\nInvalid input. Please enter a five-letter word.\n");
			userGuess = s.next();
		}
		
		
		return userGuess;
	}
	
	
}

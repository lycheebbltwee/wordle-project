package wordle;

import java.util.Scanner;

public class Computer {
	public Computer() {};
	
	public static void greeting() {
		System.out.println("\nWelcome to Wordle. You might know this game.");
		System.out.println("You have six guesses to correctly find out the five-letter word.");
		System.out.println("Can you guess the word?");
	}
	
	public static void askToPlay(Scanner s) {
		System.out.println("\nWould you like to play? [y/n]");
		String answer = s.next().toLowerCase();
		
		while (answer != "y" && answer != "n") {
			System.out.println("Invalid input. Please enter either y or n.\n");
			System.out.println("Would you like to play? [y/n]");
			answer = s.next().toLowerCase();
		}
		
		System.out.println("Cool!");
		
	}
}

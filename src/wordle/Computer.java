package wordle;

import java.util.Scanner;

public class Computer {
	public Computer() {};
	
	public static void greeting() {
		System.out.println("\nWelcome to Wordle. You might know this game.");
		System.out.println("You have six guesses to correctly find out the five-letter word.");
	}
	
	public static String askToPlay(Scanner s) {
		System.out.println("\nWould you like to play? [y/n]");
		String answer = s.next().toLowerCase();
		
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.println("Invalid input. Please enter either y or n.\n");
			System.out.println("Would you like to play? [y/n]");
			answer = s.next().toLowerCase();
		}
		
		return answer;
	}
}

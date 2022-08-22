package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
	/*
	 * Fields
	 */
	private String word;
	public static final int wordLength = 5;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	/*
	 * Constructor
	 */
	public Word() {
	}
	
	/*
	 * Method to create word list
	 */
	private List<String> createRandomWordList() {
		// File location
		File file = new File("//Users/thuynguyen/_nology/Java/Wordle Project/src/wordle/word-list.json");
		// New scanner
		Scanner scanner;
		// New array list
		List<String> data = new ArrayList<>();
		
		// Create list from file
		try {
			// Scanning file
			scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String words = scanner.nextLine().replaceAll("[^\\w]", "");
				data.add(words);
			}
			
			scanner.close();
			
			data.removeAll(Arrays.asList("", null));
			
			return data;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public String randomWord() {
		List<String> wordList = createRandomWordList();
		
		Random rand = new Random();
		
		String word = wordList.get(rand.nextInt(wordList.size()));
		this.word = word;
		
		return this.word;
	}
	
	

}

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
	
	/*
	 * Constructor
	 */
	public Word() {
	}
	
	/*
	 * Method to create word list
	 */
	private List<String> createWordList() {
		// File location
		File file = new File("//Users/thuynguyen/_nology/Java/Wordle Project/src/wordle/word-list.json");
		// Scanning file
		Scanner scanner;
		// New array list
		List<String> data = new ArrayList<>();
		
		// Create list from file
		try {
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
		List<String> wordList = createWordList();
		
		Random rand = new Random();
		
		String word = wordList.get(rand.nextInt(wordList.size()));
		this.word = word;
		
		return this.word;
	}

}

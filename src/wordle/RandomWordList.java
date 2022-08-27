package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomWordList {
	private File file;
	private String src;

	public RandomWordList(String src) {
		this.src = src;
		this.file = new File(src);
	}
	
	public String getSrc() {
		return this.src;
	}
	
	public List<String> createRandomWordList() {
		Scanner scanner;
		List<String> data = new ArrayList<>();
		
		try {
			scanner = new Scanner(this.file);
			
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
	
	public String randomWord(List<String> wordList) {
		
		Random rand = new Random();
		Word word;
		
		word = new Word(wordList.get(rand.nextInt(wordList.size())));
		
		return word.getWord();
	}
}

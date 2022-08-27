package wordle;

public class Word {
	/*
	 * Fields
	 */
	private String word;
	public static final int wordLength = 5;
	
	/*
	 * Constructor
	 */
	public Word(String word) {
		this.word = word;
	}
	
	
	/*
	 *  Methods
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return this.word;
	}
}

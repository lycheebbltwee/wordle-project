package wordle;

public class Wordle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word word = new Word();
		String nextWord = word.randomWord();
		System.out.println(nextWord);
	}

}

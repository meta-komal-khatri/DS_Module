package ds_session_5_algorithm_1;

public class Word {
	private String word;
	private String meaning;
	private Word leftWord;
	private Word rightWord;
	/**
	 * @param word
	 * @param meaning
	 */
	public Word(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
		leftWord=null;
		rightWord=null;
	}
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}
	
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the leftWord
	 */
	public Word getLeftWord() {
		return leftWord;
	}
	/**
	 * @param leftWord the leftWord to set
	 */
	public void setLeftWord(Word leftWord) {
		this.leftWord = leftWord;
	}
	/**
	 * @return the rightWord
	 */
	public Word getRightWord() {
		return rightWord;
	}
	/**
	 * @param rightWord the rightWord to set
	 */
	public void setRightWord(Word rightWord) {
		this.rightWord = rightWord;
	}

	public void setMeaning(String meaning) {
	
		this.meaning=meaning;
	}
	
	
}

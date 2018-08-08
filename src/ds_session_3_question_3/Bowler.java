package ds_session_3_question_3;

public class Bowler {
	private String bowlerName;
	private int numberOfBallsBowlerHaving;
	
	Bowler(String bowlerName,int numberOfBallsbowlerHaving){
		this.setBowlerName(bowlerName);
		this.setNumberOfBallsBowlerHaving(numberOfBallsbowlerHaving);
	}

	/**
	 * @return bowlers name
	 */
	public String getBowlerName() {
		return bowlerName;
	}

	/**
	 * set bowler name
	 * @param bowlerName
	 */
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	/**
	 * @return number of balls 
	 */
	public int getNumberOfBallsBowlerHaving() {
		return numberOfBallsBowlerHaving;
	}

	/**
	 * set number of balls
	 * @param bowlerName
	 */
	public void setNumberOfBallsBowlerHaving(int numberOfBallsBowlerHaving) {
		this.numberOfBallsBowlerHaving = numberOfBallsBowlerHaving;
	}
	
}

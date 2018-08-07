package ds_session_3_question_3;

public class Bowler {
	private String bowlerName;
	private int numberOfBallsBowlerHaving;
	
	Bowler(String bowlerName,int numberOfBallsbowlerHaving){
		this.setBowlerName(bowlerName);
		this.setNumberOfBallsBowlerHaving(numberOfBallsbowlerHaving);
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public int getNumberOfBallsBowlerHaving() {
		return numberOfBallsBowlerHaving;
	}

	public void setNumberOfBallsBowlerHaving(int numberOfBallsBowlerHaving) {
		this.numberOfBallsBowlerHaving = numberOfBallsBowlerHaving;
	}
	
}

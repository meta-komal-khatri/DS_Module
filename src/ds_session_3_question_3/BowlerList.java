package ds_session_3_question_3;

import java.util.ArrayList;
import java.util.List;

public class BowlerList {
	private List<Bowler> bowlerList;
	BowlerList(){
		bowlerList=new ArrayList<Bowler>();
	}
	public void addBowlersToList(String bowlerName,int numberOfBallsBowlerHaving){
		bowlerList.add(new Bowler(bowlerName,numberOfBallsBowlerHaving));
	}
	public List<Bowler> getBowlerList(){
		return bowlerList;
	}
}

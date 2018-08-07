package ds_session_3_question_3;

import java.util.List;
import ds_session_3_question_2.*;
public class MatchFixing {
	List<Bowler> bowlerList;
	int totalNumberOfBowlers;
	int totalNumberOfBalls;
	MatchFixing(int totalNumberOfBowlers,int totalNumberOfBalls,List<Bowler> bowlerList){
		this.totalNumberOfBowlers=totalNumberOfBowlers;
		this.totalNumberOfBalls=totalNumberOfBalls;
		this.bowlerList=bowlerList;
		validate();
	}
	private void validate(){
		int totalBalls=0;
		for(Bowler bowler:bowlerList){
			totalBalls=totalBalls+bowler.getNumberOfBallsBowlerHaving();
		}
		if(totalNumberOfBalls>totalBalls ||totalNumberOfBalls<totalBalls ){
			throw new AssertionError("NotD divided equally");
		}
	}
	public void setBowlersOrder(){
		PriorityQueue priorityQueue=new PriorityQueue(totalNumberOfBowlers);
		for(Bowler bowler:bowlerList){
			priorityQueue.insertIntoPriorityQueue(bowler.getBowlerName(), bowler.getNumberOfBallsBowlerHaving());
		}
	}
	
	
}

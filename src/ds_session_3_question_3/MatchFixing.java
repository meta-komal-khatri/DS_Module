package ds_session_3_question_3;

import java.util.ArrayList;
import java.util.List;

import ds_session_3_question_2.*;
public class MatchFixing {
	List<Bowler> bowlerList;
	int totalNumberOfBowlers;
	int totalNumberOfBalls;
	PriorityQueue priorityQueue;
	MatchFixing(int totalNumberOfBowlers,int totalNumberOfBalls,List<Bowler> bowlerList){
		this.totalNumberOfBowlers=totalNumberOfBowlers;
		this.totalNumberOfBalls=totalNumberOfBalls;
		this.bowlerList=bowlerList;
		priorityQueue=new PriorityQueue(totalNumberOfBowlers);
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
		for(Bowler bowler:bowlerList){
			priorityQueue.insertIntoPriorityQueue(bowler.getBowlerName(), bowler.getNumberOfBallsBowlerHaving());
		}
	}
	public List<Bowler> getOrderOfBowlers(){
		List<Bowler> orderListOfBowlers=new ArrayList<Bowler>();
		Task task;
		for(int i=0;i<totalNumberOfBowlers;i++){
			task=priorityQueue.remove();
			orderListOfBowlers.add(new Bowler(task.getJob(),task.getPriority()));
		}
		return orderListOfBowlers;
	}
	
	
}

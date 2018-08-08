package ds_session_3_question_3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ds_session_3_question_2.PriorityQueue;

public class MatchFixingTest {
	MatchFixing matchFixing;
	@Test
	public void test() {
		BowlerList bowlerList=new BowlerList();
		bowlerList.addBowlersToList("Bowler1", 3);
		bowlerList.addBowlersToList("Bowler2", 2);
		bowlerList.addBowlersToList("Bowler3", 5);
		bowlerList.addBowlersToList("Bowler4", 1);
		matchFixing=new MatchFixing(4, 11,bowlerList.getBowlerList() );
		matchFixing.setBowlersOrder();
		List<Bowler> bowlerListExpected=new ArrayList<Bowler>();
		bowlerListExpected.add(new Bowler("Bowler3",5));
		bowlerListExpected.add(new Bowler("Bowler1",3));
		bowlerListExpected.add(new Bowler("Bowler2",2));
		bowlerListExpected.add(new Bowler("Bowler4",1));
		
		List<Bowler> bowlerListActual=matchFixing.getOrderOfBowlers();
		for(int i=0;i<4;i++){
			assertEquals(bowlerListExpected.get(i).getBowlerName(),bowlerListActual.get(i).getBowlerName());
		}
		
	}
	@Test(expected=AssertionError.class)
	public void throwsErrorIfBallsAreNotDividedProperly(){
		BowlerList bowlerList=new BowlerList();
		bowlerList.addBowlersToList("Bowler1", 3);
		bowlerList.addBowlersToList("Bowler2", 2);
		bowlerList.addBowlersToList("Bowler3", 5);
		bowlerList.addBowlersToList("Bowler4", 2);
		matchFixing=new MatchFixing(4, 11,bowlerList.getBowlerList() );
		matchFixing.setBowlersOrder();
	}

}

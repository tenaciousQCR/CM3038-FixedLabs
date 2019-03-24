package cm3038.lab07.queen;

import cm3038.search.local.*;

/**
 * This class run a N-Queen problem.
 * @author Kit-ying Hui
 *
 */
public class RunNQueen
{
public static void main(String[] arg)
{
int n=8;
LocalSearchProblem nqueenProblem=new NQueenHillClimbingProblem();		//create an N-Queen problem as Hill Climbing search
//LocalSearchProblem nqueenProblem=new NQueenSidewayMove();			//create an N-Queen problem as Hill Climbing search
//LocalSearchProblem nqueenProblem=new NQueenSimulatedAnnealing(n);	//create an N-Queen problem as Simulated Annealing
State startState=new NqState(n);										//create a random starting state
System.out.println(startState.toString());							//print starting state
State solution=nqueenProblem.search(startState);						//search
System.out.println("Solution found:\n"+solution.toString()+"\n");		//print result
System.out.println("Objective value:"+nqueenProblem.objective(solution));	//print objective value of final result
} //end method
} //end class

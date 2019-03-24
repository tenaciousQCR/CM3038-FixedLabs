package cm3038.lab07.queen;

import java.util.*;
import cm3038.search.local.*;

/**
 * This class models the N-Queen problem as a Hill Climbing local search.
 * @author Kit-ying Hui
 *
 */
public class NQueenHillClimbingProblem extends LocalSearchProblem
{
/**
 * This method overrides the {@link LocalSearchProblem.objective(State) objective(State)} method
 * to define the objective function of the N-Queen problem.
 * 
 * In this implementation, we count the number of conflicts.
 * @return The number of conflicts.
 */

@Override
public double objective(State state)
{
int result=0;										//initially no conflict

NqState nqState=(NqState)state;						//cast State into NqState for easier work
for (int row=0;row<nqState.columns.length;row++)		//loop through the rows
	{
	for (int rest=row+1;rest<nqState.columns.length;rest++)	//for each row, look into the rows beyond
		if (nqState.columns[row]==nqState.columns[rest])		//another queen on the same column as the current one
			result++;										//1 more conflict
		else	{												//if not, check for diagonal conflict
				int rowDiff=Math.abs(rest-row);										//find row difference
				int colDiff=Math.abs(nqState.columns[row]-nqState.columns[rest]);		//find column difference
				if (rowDiff==colDiff)												//if they are the same, there is a diagonal conflict
					result++;														//1 more
				}
	}
return -1*result;	//negate result as we want to maximise the negation of conflict count
} //end method

/**
 * This method overrides the {@link LocalSearchProblem#search(State) search(State)} method to
 * perform hill climbing local search.
 * 
 * Ideally this should be defined in a domain-independent class which supplies the hill climbing algorithm to all domains.
 *  
 * @param state	The current state.
 * @return	The final state which cannot be improved further using hill climbing.
 */
public State search(State state)
{
State currentState=state;								//the initial state
double currentScore=this.objective(currentState);		//calculate its objective function value

while (true)												//loop forever
	{
	Set<State> neighbours=currentState.neighbours();		//get all neighbours
	if (neighbours.isEmpty())							//if there is no neighbour
		return currentState;								//the current state is the solution
	
	Object[] neighbourObjects=neighbours.toArray();		//get all neighbours as an array
	
	State bestNeighbour=(State)neighbourObjects[0];			//initialise best neighbour as 1st one
	double bestNeighbourScore=this.objective(bestNeighbour);	//best neighbour score
	for (int i=1;i<neighbourObjects.length;i++)				//scan through the rest to find the best
		{
		State neighbour=(State)neighbourObjects[i];			//get i-th neighbour
		double neighbourScore=this.objective(neighbour);		//get this neighbour's score
		//
		//***Complete the search method here!!!
		//***
		//***This loop is already iterating through the remaining neighbours.
		//***For each neighbour, find its objective function value.
		//***If its value is higher than the best neighbour score so far,
		//***make it the best neighbour and remember its score.
		//***
		//***When you finish this loop, bestNeighbour and bestNeightbourScore
		//***should the neighbour with the highest objective function value and its score.
		//
		System.out.println("*** Complete search(State) in NQueenHillingClimbingProblem*** to find the best neighbour and its score.");
		} //end for
	
	//
	//***Now we have found the best neighbour, check to see if we should move over there.
	//***
	//***If current state has a higher score than the best neighbour, you hit an optimal.
	//***Return current state as the answer.
	//
	if (currentScore>=bestNeighbourScore)	//current state is better than any neighbour
		return currentState;					//return it
	
	//
	//***If the best neighbour is better, make it our current state (and update the current score too).
	//***We will continue the while loop.
	//
	System.out.println("*** Complete search(State) in NQueenHillingClimbingProblem*** to move to the best neighbour if it is better than our current state.");

	System.out.println("Moving to neighbour with score: "+currentScore);	//print score of the state where we are moving to
	System.out.println(currentState.toString());							//print out the state
	} //end while
} //end method
} //end class

package cm3038.lab07.queen;

import java.util.*;
import cm3038.search.local.*;

/**
 * This class solves the N-Queen problem using Simulated Annealing.
 * It is extending the NQueenHillClimbingProblem class as we will simply override the search() method.
 * @author Kit-ying Hui
 *
 */
public class NQueenSimulatedAnnealing extends NQueenHillClimbingProblem
{
private static double THRESHOLD=0.0001;			//temperature threshold for stopping the search
private static double MAX_TEMPERATURE=1000.0;	//the maximum temperature at time 0
protected int MAX_OBJECTIVE=0;					//this value is needed n calculating probability

/**
 * Creates an 8-Queen problem when no problem size is specified.
 */
public NQueenSimulatedAnnealing()
{
this(8);
} //end method

/**
 * The main purpose of this constructor is to initialise the MAX_OBJECTIVE attribute based on the size of the problem.
 * Our objective function counts the number of conflicting pairs.
 * So the maximum possible objective function is the number of combinations in choosing 2 out of n queens.
 * @param n
 */
public NQueenSimulatedAnnealing(int n)
{
MAX_OBJECTIVE=n*(n-1)/2;
} //end method

/**
 * This method overrides the one defined in {@link NQueenHillClimbingProblem} to implement
 * Simulated Annealing local search.
 * 
 * @param state The starting state of the search.
 * @return The final solution state.
 */
@Override
public State search(State state)
{
State currentState=state;								//keep the current state
double currentScore=this.objective(currentState);		//the objective function value of the current state
int time=0;												//time starts from 0
double temperature=MAX_TEMPERATURE;						//temperate starts from maximum

while (true)											//keep looping
	{
	temperature=getTemperature(time,temperature);		//get temperature according to time and current temperature
	System.out.println("Time: "+time+" Temperature: "+temperature+" Score: "+this.objective(currentState));
	if (temperature<THRESHOLD)							//when it is cold enough
		return currentState;							//return current state as solution
	
	Set<State> neighbours=currentState.neighbours();	//get all neighbours
	
	if (neighbours.isEmpty())							//if there is no neighbour
		return currentState;							//the current state is the solution
	
	Object[] neighbourObjects=neighbours.toArray();		//get all neighbours as an array

	int randomIndex=(int)(Math.random()*neighbourObjects.length);	//get a random number in 0..-length-1
	State randomNeighbour=(State)neighbourObjects[randomIndex];		//pick a random neighbour
	double randomNeighbourScore=this.objective(randomNeighbour);	//get score of this random neighbour
	if (randomNeighbourScore>currentScore)							//neighbour is better
		{
		System.out.print("Moving to better neighbour with score: "+randomNeighbourScore);
		System.out.print("\n"+randomNeighbour.toString());
		currentState=randomNeighbour;								//move!
		currentScore=randomNeighbourScore;
		}
	else	{
			//
			// If random neighbour is not better, there is still a chance for us to move
			// to this "worse" neighbour.
			//
			double probability=probability(currentScore,randomNeighbourScore,temperature);		//find probability to move according to states and temperature
			if (Math.random()<probability)														//not better but probability allows
				{
				System.out.print("Probability "+probability+" allows moving to worse neighbour with score: "+randomNeighbourScore);
				System.out.print("\n"+randomNeighbour.toString());
				currentState=randomNeighbour;						//move
				currentScore=randomNeighbourScore;
				}
			else System.out.println("Probability: "+probability+" Not moving to worse neighbour.");	//otherwise not moving
			}
	time++;															//increment time
	} //end while
} //end method

/**
 * Find temperature from time.
 * Temperate should decrease when time increases.
 * In the current implementation temperature drops 5% in each call.
 * 
 * @param time Time in the search. Start from 0.
 * @param temperature Current temperature.
 * @return	The new temperature.
 */
private double getTemperature(int time,double temperature)
{
if (time==0)
	return MAX_TEMPERATURE;
return temperature*0.95;	//every time reduces by 0.05 of current temperature
} //end method



/**
 * Based on the current state score, neighbour state score and temperature
 * find the probability of moving to a "worse" neighbour.
 * @param e1 The current state score/objective function value.
 * @param e2 The random neighbour score.
 * @param temperature The temperature.
 * @return The probability of moving to a "worse" neighbour.
 */
private double probability(double e1,double e2,double temperature)
{
double difference=Math.abs(e1-e2);	//find difference between scores
return temperature/MAX_TEMPERATURE*(1.0-difference/MAX_OBJECTIVE);
} //end method
} //end class

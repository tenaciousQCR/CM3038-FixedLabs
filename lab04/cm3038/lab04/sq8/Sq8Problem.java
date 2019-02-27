package cm3038.lab04.sq8;

import cm3038.search.*;				//use some classes in the uninformed search library
import cm3038.search.informed.*;	//use the informed search library
import cm3038.lab03.sq8solution.*;	//this lab uses states and actions defined in lab#3

/**
 * This is a informed search problem specialised for the 8-Puzzle problem.
 * @author kit
 *
 */
public class Sq8Problem extends BestFirstSearchProblem
{
	/**
	 * Construct a Sq8Problem object from the initial and goal state.
	 * @param initialState	The initial state.
	 * @param goalState		The goal state.
	 */
	public Sq8Problem(State initialState, State goalState) {
		super(initialState, goalState);
	}

	/**
	 * The evaluation function required by an informed search.
	 * @param node	The node to be evaluated.
	 * @return The score of the node. The lower the score, the more promising the node.
	 */
	public double evaluation(Node node) {
		//
		//*** Update this evaluation function.
		//*** Currently it is doing Greedy best-first by using the heuristic alone.
		//*** It does not take into consideration the cost from the root to "node" so far.
		//*** You can get the cost from the root to node to far by this.getCost().
		//
		return heuristic(node.state);	//f(n)=h(n) mean greedy best-first
	}
		
	/**
	 * This heuristic function estimate how far this state is from a goal.
	 * Note: You can always access the goal state by "this.goalState" as it is stored as an attribute.
	 * @return The remaining distance/cost of the current state to a goal.
	 */
	public double heuristic(State currentState) {
		//*** Explore different ways to estimate the distance of the current state to the goal state.
		//*** The misplaced tile heuristic is implemented as an example.
		//***
		return this.misplacedTiles(currentState);
	}

	/**
	 * Counting the number of misplaced tiles in the current state.
	 * @param currentState
	 * @return the no. of misplaced tiles in the state
	 */
	public double misplacedTiles(State currentState) {
		double result = 0.0;
		int tiles[][] = ((Sq8State)currentState).tiles;
		int goalTiles[][] = ((Sq8State)this.goalState).tiles;

		//
		//***The current implementation is "counting the number of misplaced tiles".
		//***Note that we only look for tiles in counting mismatches, not the space.
		//***Including the space in counting mismatches will over-estimate.
		//
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (tiles[row][col] != 0 &&						//if current tile is not a space
					tiles[row][col] != goalTiles[row][col])	{	//and it does not match the one in goal
					result++;									//increment count by 1
				}
			}
		}
		
		return result;
	}

	/**
	 * This isGoal testing method defines that the a state must be
	 * equal to the goal state (as an attribute in the problem object)
	 * to be a goal.
	 */
	@Override
	public boolean isGoal(State state) {
		return state.equals(this.goalState);
	}
}

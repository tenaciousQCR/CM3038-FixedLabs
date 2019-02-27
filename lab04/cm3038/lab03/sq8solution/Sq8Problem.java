package cm3038.lab03.sq8solution;

import java.util.*;
import cm3038.search.*;

public class Sq8Problem extends SearchProblem {
	public State goalState;			//the goal state required

	public Sq8Problem(State start, State goal) {
		super(start);
		this.goalState = goal;
	}

	/**
	 * This method adds a child node into the fringe.
	 * It controls the search strategy.
	 */
	protected void addChild(List<Node> fringe, Node childNode) {
		fringe.add(childNode);	//***adding a child to the end of the queue give a breadth-first behaviour
	}

	@Override
	/**
	 * This method tests if the current Sq8State is a goal state.
	 * @return Return true if the current state is a goal. false otherwise.
	 */
	public boolean isGoal(State state) {
		return state.equals(this.goalState);
	}
}

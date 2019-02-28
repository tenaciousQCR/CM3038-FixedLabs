package cm3038.lab02.mc;

import java.util.List;

import cm3038.search.*;

/**
 * This subclass of SearchProblem defines a specialised search problem for the M&C domain.
 * @author Kit-ying Hui
 *
 */
public class MissionariesCannibals extends SearchProblem {
    /**
     * The raft size defined as a class-level constant in the class.
     */
    public static final int RAFT_SIZE = 2;

    /**
     * In general, a state object has a isGoal(State) method defined on it to tell if that state is a goal.
     * For the M&C class, I stored the generally accepted goal state of a 3-3 M&C problem.
     * The isGoal(State) method in our specialised McState class is testing if this goal state is reached.
     * If you want to change the number of missionaries and cannibals, you need to change this object too.
     */
    public McState goalState = null;


    /**
     * Given an initial state, this constructor creates a problem object.
     * @param initialState The initial problem state.
     */
    public MissionariesCannibals(McState initialState, McState goalState) {
        super(initialState);
        this.goalState = goalState;
    }

    /**
     * Our MissionariesCannibals class currently uses the inherited addChild(...) method from its superclass cm3038.search.SearchProblem.
     * 
     * If you want to change how children are added to the fringe, uncomment this method and it will override the one defined in the superclass.
     * 
     * The default implementation below adds a child node to the end of the fringe.
     */
    /*
    protected void addChild(List<Node> fringe,Node childNode) {
        fringe.add(childNode);  //*** Adding child node to end of fringe. Fringe is a FIFO queue.
    }
    */

    /**
     * Testing if the current state is a goal.
     * In our implementation of the M&C problem, we have defined a goal state in the {@link MissionariesCannibals} class.
     * Note that if you want a different goal state (e.g. apart from the 3M+3C setting), you must change the
     * goal state in the {@link MissionariesCannibals} class.
     */
    public boolean isGoal(State state) {
        return state.equals(this.goalState);
    }
}

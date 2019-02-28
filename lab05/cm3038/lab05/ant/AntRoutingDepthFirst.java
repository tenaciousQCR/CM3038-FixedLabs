package cm3038.lab05.ant;

import java.util.*;
import cm3038.search.*;

/**
 * This class models the ant routing finding problem as a depth-first search.
 * It extends our uninformed search library class cm3038.search.SearchProblem.
 * @author kit
 *
 */
public class AntRoutingDepthFirst extends SearchProblem {
    /**
     * The goal state.
     */
    public AntState goal;

    /**
     * A reference to the ant world.
     */
    public AntWorld world;

    /**
     * Create an AntRoutingDepthFirst object from the initial state, goal state, and ant world.
     * @param start The initial state.
     * @param goal  The goal state.
     * @param world The world as an AntWorld object.
     */
    public AntRoutingDepthFirst(AntState start, AntState goal, AntWorld world)
    {
        super(start);
        this.goal = goal;
        this.world = world;
    }

    /**
     * We override the addChild(List<Node>,Node) method to add the new child to the beginning of the fringe.
     * This gives a depth-first behaviour.
     */
    protected void addChild(List<Node> fringe, Node childNode)
    {
        fringe.add(0, childNode);
    }

    /**
     * This method override the superclass isGoal(...) method to check for a goal state.
     * It simply checks if the state in question equals to the goal state (stored in the goal attribute).
     */
    @Override
    public boolean isGoal(State state)
    {
        return state.equals(this.goal);
    }
}

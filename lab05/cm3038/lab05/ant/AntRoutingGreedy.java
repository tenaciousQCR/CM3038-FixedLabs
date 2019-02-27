package cm3038.lab05.ant;

import cm3038.search.*;

public class AntRoutingGreedy extends AntRoutingAStarManhattan
{
public AntRoutingGreedy(State start, State goal, AntWorld world)
{
super(start, goal, world);
} //end method

@Override
public double evaluation(Node node)
{
return this.heuristic(node.state);
} //end method
} //end class

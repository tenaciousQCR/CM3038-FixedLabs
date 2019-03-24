package cm3038.search.local;

public abstract class LocalSearchProblem {
    /**
     * This method performs a local search on the problem.
     * It should be overridden in different sub-classes which implement specific local search algorithms.
     * 
     * @param state The starting state.
     * @return The final solution.
     */
    public abstract State search(State state);

    /**
     * The objective function on a state.
     * This method should be overridden in different sub-classes which defined problems in specific domains.
     * 
     * @return The objective function value that measures how good a state is.
     */
    public abstract double objective(State state);
}
package cm3038.lab07.queen;

import java.util.*;
import cm3038.search.local.*;

public class NQueenSidewayMove extends NQueenHillClimbingProblem {
    private static int MAX_SIDEWAY_MOVE = 100;

    /**
     * This method overrides the {@link NQueenHillClimbingProblem#search(State) search(State)} method in
     * {@link NQueenHillClimbingProblem} to perform hill climbing with sideway move.
     * The number of consecutive sideway moves allowed is 100.
     * 
     * @param state The current state.
     * @return  The final state which cannot be improved further.
     */
    @Override
    public State search(State state) {
        int sidewayMoves = 0;   //initially no sideway move
        
        //
        // *** You should copy your implementation of the search(State) method from NQueenHillClimbingProblem
        // *** into here and then modify it to allow sideway move.
        //
        
        System.out.println("*** Modify the search(State) method in NQueenSidewayMove to allow sideway moves in hill climbing.");
        return super.search(state); //current we take our superclass' version of search
    }
}

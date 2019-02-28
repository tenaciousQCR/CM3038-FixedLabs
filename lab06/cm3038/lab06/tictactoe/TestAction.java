package cm3038.lab06.tictactoe;

import cm3038.search.adversarial.*;

public class TestAction {
    public static void main(String[] arg) {
        int[][] symbol =    {
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0}
                            };
        
        TttState initialState = new TttState(symbol);                   //create initial state of empty board
        System.out.println("Initial state:\n" + initialState.toString());

        TttAction action = new TttAction(1, 2, Symbol.CROSS);
        System.out.println("Action: " + action.toString());

        TttState nextState = initialState.applyAction(action);

        System.out.println("New state:\n" + nextState.toString());
    }
}

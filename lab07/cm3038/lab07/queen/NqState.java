package cm3038.lab07.queen;

import java.util.*;
import cm3038.search.local.*;

/**
 * This class models a problem state in the N-Queen problem.
 */
public class NqState implements State {
    /**
     * This int array stores the columns of all queens.
     * We don't need to store the rows as these are implicit in the array index.
     */
    public int columns[];

    /**
     * This constructor creates a NqState with random position.
     * This is usually if we want to start search from a random state.
     * @param size The value of N. i.e. The size of the N*N board.
     */
    public NqState(int size) {
        this.columns = new int[size];                       //create an int array of the correct size
        
        for (int i = 0; i < size; i++) {                            //loop through all elements
            this.columns[i] = (int) (Math.random() * size); //assign a column value of 0..size-1
        }
    }

    /**
     * The constructor creates a NqState from a given int array.
     * @param positions The column values of the queen in an int array.
     */
    public NqState(int[] positions) {
        this.columns = new int[positions.length];           //create an int array of the correct size
        for (int i = 0; i < positions.length; i++) {            //loop through each row
            this.columns[i] = positions[i];             //set column as stated in int array
        }
    }

    /**
     * Return the N-Queen problem state as a String (which can be printed).
     * @return The current N-Queen problem state as a String.
     */
    public String toString() {
        String result = "";
        
        for (int row = 0; row < this.columns.length; row++) {
            //
            //***Complete this method to return the NqState as a String.
            //***
            //***The for loop is already iterating through the rows.
            //***For each row, append a "." or "Q" depending on there is space or a queen.
            //***You can tell what to append by looking at the column position of the queen at the current row.
            //***That will give you 1 row.
            //***I have already added the "\n" after each row (see the line below).
            //
            result += "\n"; //append newline to result String at the end of each row
        }
        
        return result;      //return result String
    }

    /**
     * Generate all neighbouring states of current state.
     * @return A Set of State.
     */
    @Override
    public Set<State> neighbours() {
        Set<State> result = new HashSet<State>();           //create result as an empty set of State

        //
        // ***Remember that the constructor of NqState takes an int array to create a NqState.
        // ***This temporary int array will be used to hold some temporary int values. 
        //
        int[] temp = new int[this.columns.length];      //create int array of same size

        for (int i = 0; i < this.columns.length; i++) {         //copy values from current state into temp array
            temp[i] = this.columns[i];
        }

        //
        //The loop on row will iterate through all rows.
        //
        for (int row = 0; row < this.columns.length; row++) {   //loop through the rows
            int originalColumn = temp[row];                         //remember column number at this row
            
            //
            //***For the queen in each row, find out the other column positions it can go apart
            //***from its current column.
            //
            for (int column = 0; column < this.columns.length; column++) {  //loop through all column values
                //
                //***Complete the neighbours method here!!!
                //***Given the current state, it should find out all possible neighbours and add them into the rest set.
                //***
                //***The loop on "column" will iterate through all possible column positions for this queen.
                //***Every column value will give a neighbouring state, EXCEPT when it is the same value
                //***as the queen's current column position.
                //***
                //***For each neighbour state, use the "temp" int array to create a new NqState and add
                //***it into the "result" set.
                //***Remember that only the queen of the current row should change its column value.
                //
            }
            
            temp[row] = originalColumn;                             //restore original column number at this row
        }
        
        return result;
    }
}

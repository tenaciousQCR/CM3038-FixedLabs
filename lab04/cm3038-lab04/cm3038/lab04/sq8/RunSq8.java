package cm3038.lab04.sq8;

import cm3038.lab03.sq8solution.*;	//use state and action etc. defined in lab#3
import cm3038.search.*;				//use some classes defined in the uninformed search library

/**
 * Solving the 8-Puzzle problem using best-first search.
 * @author kit
 *
 */
public class RunSq8
{
public static void main(String[] arg)
{
int[][] initialBoard={{8,7,6},{5,4,3},{2,1,0}};				//the initial board as an int array
int[][] goalBoard={{0,1,2},{3,4,5},{6,7,8}};				//the goal board
Sq8State initialState=new Sq8State(initialBoard);	//create initial state
Sq8State goalState=new Sq8State(goalBoard);			//create goal state

SearchProblem problem=new Sq8Problem(initialState,goalState);	//create problem instance

System.out.println("Searching...");		//print some message
Path path=problem.search();				//perform search, get result
System.out.println("Done!");			//print some message
if (path==null)							//if it is null, no solution
	System.out.println("No solution");
else	{
		path.print();							//otherwise print path
		System.out.println("Nodes visited: "+problem.nodeVisited);
		System.out.println("Cost: "+path.cost+"\n");
		}
} //end method
} //end class

package cm3038.lab06.tictactoe;

import cm3038.search.adversarial.*;

public class TestTicTacToe {
public static void main(String[] arg)
{
int[][] symbol={
				{0,0,0},
				{0,0,0},
				{0,0,0}
				};
TttState initialState=new TttState(symbol);					//create initial state of empty board
System.out.println(initialState.toString());
MiniMaxSearch ttt=new TttProblem();	//create minimax problem instance
ActionScorePair result=ttt.search(initialState,PlayerRole.MAX);		//start search as max player
System.out.println("Score: "+result.score+" Action:"+result.action.toString());
} //end method
} //end class

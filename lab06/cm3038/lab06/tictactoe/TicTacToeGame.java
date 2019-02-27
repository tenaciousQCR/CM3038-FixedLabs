package cm3038.lab06.tictactoe;

import cm3038.search.*;
import cm3038.search.adversarial.*;

public class TicTacToeGame 
{
public static void main(String[] arg)
{
TttState gameState=new TttState();	//create initial state of empty board
MiniMaxSearch ttt=new TttProblem();	//create minimax problem instance
//MiniMaxSearch ttt=new TttAlphaBetaProblem();	//When your alpha-beta version is ready,
												//uncomment this line and comment out the line above
												//to create a TttAlphaBetaProblem object.

Player player1=new HumanPlayer("Human",PlayerRole.MAX);
Player player2=new ComputerPlayer("Computer 2",PlayerRole.MIN);
Player currentPlayer=player1;

System.out.println(gameState.toString());

while (!ttt.isTerminal(gameState))
	{
	Action action=currentPlayer.getAction(ttt,gameState);
	System.out.println("Action: "+action.toString());
	gameState=gameState.applyAction(action);
	System.out.println(gameState.toString());			//print new game state
	if (currentPlayer==player1)
		currentPlayer=player2;
	else currentPlayer=player1;
	} //end while
System.out.println("Game Ended!");
} //end method
} //end class

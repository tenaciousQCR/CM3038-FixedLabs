package cm3038.lab06.tictactoe.test;

import cm3038.lab06.tictactoe.*;
import cm3038.search.adversarial.PlayerRole;

public class TestSuccessor {
public static void main(String[] arg)
{
int[][] symbol={	{1,0,2},
				{0,0,0},
				{2,0,1},
				};

TttState s=new TttState(symbol);		//create game state
System.out.println("State:\n"+s.toString());
System.out.println("Successors for MAX player:\n");
System.out.println("All action-state:\n"+s.successor(PlayerRole.MAX).toString());

System.out.println("Successors for MIN player:\n");
System.out.println("All action-state:\n"+s.successor(PlayerRole.MIN).toString());
} //end method
} //end class
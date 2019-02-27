package cm3038.lab06.tictactoe;

import java.util.*;
import cm3038.search.*;
import cm3038.search.adversarial.*;

public class TestSuccessor {
public static void main(String[] arg)
{
int[][] symbol={
				{0,0,0},
				{0,1,0},
				{0,0,2}
				};
TttState state=new TttState(symbol);					//create initial state of empty board

List<ActionStatePair> children=state.successor(PlayerRole.MIN);

System.out.println("State:\n"+state.toString());
System.out.print("\nChildren:\n");
System.out.println(children);
} //end method
} //end class

package cm3038.lab06.tictactoe;

import cm3038.search.*;

public class TttAction extends Action {
public int x;
public int y;
public Symbol symbol;

public TttAction(int x,int y,Symbol symbol)
{
this.x=x;
this.y=y;
this.symbol=symbol;	
} //end method

@Override
public String toString()
{
String result="";

switch (this.symbol)
	{
	case CROSS:		result+="Put X at ";
					break;
	case NAUGHT:	result+="Put O at ";
					break;
	default:		break;
	} //end switch
	result+="("+this.x+","+this.y+")";
	return result;
} //end method
} //end class

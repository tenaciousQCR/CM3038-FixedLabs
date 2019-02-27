package cm3038.lab06.tictactoe;

import cm3038.search.adversarial.*;

public class TttProblem extends MiniMaxSearch
{
	/**
	 * Check if this is a terminal state. i.e. either X or O wins.
	 * @param state	The board state.
	 * @return		true if the state is terminate. false otherwise.
	 */
	@Override
	public boolean isTerminal(cm3038.search.adversarial.State state) {
		int blankCount = 0;

		TttState tttState = (TttState) state;	//cast State into TttState

		for (int y = 0; y < tttState.board.length; y++) {		//look for blanks
			for (int x = 0; x < tttState.board[y].length; x++) {
				if (tttState.board[y][x] == Symbol.BLANK) {
					blankCount++;
				}
			}
		}
		
		if (blankCount == 0) {	//no more blank?
			return true;		//end of game
		}
		
		for (int y = 0; y < tttState.board.length; y++) {	//look at each row
			if (rowSymbolCount(tttState, y, Symbol.CROSS) == 3) {	//3 Xs in a row
				return true;
			}
			
			if (rowSymbolCount(tttState, y, Symbol.NAUGHT) == 3) {	//or 3 Os in a row
				return true;
			}
		}
		
		for (int x = 0; x < tttState.board[0].length; x++) {	//look at each column
			if (columnSymbolCount(tttState, x, Symbol.CROSS) == 3) {	//3 Xs in a column
				return true;
			}
			
			if (columnSymbolCount(tttState, x, Symbol.NAUGHT) == 3) {	//3 Xs in a column
				return true;
			}
		}
		
		if (upDiagonalSymbolCount(tttState, Symbol.CROSS) == 3) {	//3 Xs in the upward diagonal
			return true;
		}
		
		if (upDiagonalSymbolCount(tttState, Symbol.NAUGHT) == 3) {	//or 3 Os in the upward diaganol
			return true;
		}
		
		if (downDiagonalSymbolCount(tttState, Symbol.CROSS) == 3) {	//or 3 Xs in the downward diagonal
			return true;
		}
		
		if (downDiagonalSymbolCount(tttState, Symbol.NAUGHT) == 3) {	//or 3 Os in the downward diagonal
			return true;
		}
		
		return false;	//otherwise, not a terminal state
	}

	/**
	 * Count the number of a symbol in a row.
	 * @param state	The board state.
	 * @param y		The row number (0-2).
	 * @param symbol	The symbol to count.
	 * @return		The number of symbol in a row.
	 */
	private int rowSymbolCount(TttState state, int y, Symbol symbol)
	{
		int result = 0;

		for (int x = 0; x < state.board[y].length; x++) {
			if (state.board[y][x] == symbol) {
				result++;
			}
		}
		
		return result;
	}

	/**
	 * Count the number of symbol in a column.
	 * @param state	The board state.
	 * @param x		The column number (0-2).
	 * @param symbol	The symbol to count.
	 * @return		The number of symbol in column.
	 */
	private int columnSymbolCount(TttState state, int x, Symbol symbol) {
		int result = 0;

		for (int y = 0; y < state.board.length; y++) {
			if (state.board[y][x] == symbol) {
				result++;
			}
		}
		
		return result;
	}

	/**
	 * Count the number of symbol in the upward diagonal.
	 * @param state	The board state.
	 * @param symbol	The symbol to count.
	 * @return		The number of symbols in the upward diagonal.
	 */
	private int upDiagonalSymbolCount(TttState state, Symbol symbol) {
		int result = 0;
		int y = 2;

		for (int x = 0; x < state.board[0].length; x++) {
			if (state.board[y][x] == symbol) {
				result++;
			}
			
			y--;
		}
		
		return result;
	}

	/**
	 * Count the number of symbol in the downward diagonal.
	 * @param state	The board state.
	 * @param symbol	The symbol to count.
	 * @return		The number of symbols in the downward diagonal.
	 */
	private int downDiagonalSymbolCount(TttState state, Symbol symbol) {
		int result = 0;
		int y = 0;

		for (int x = 0; x < state.board[0].length; x++) {
			if (state.board[y][x] == symbol) {
				result++;
			}
			
			y++;
		}
		
		return result;
	}

	/**
	 * Calculate the utility value of a state towards a player.
	 * @param state	The board state.
	 * @param role	The player role.
	 * @return		The score of the state towards this player.
	 */
	@Override
	public double utility(cm3038.search.adversarial.State state, PlayerRole role)
	{
		double blankScore;
		int blankCount = 0;

		TttState tttState = (TttState) state;	//cast State into TttState

		for (int y = 0; y < tttState.board.length; y++) {			//count blanks
			for (int x = 0; x < tttState.board[0].length; x++) {
				if (tttState.board[y][x] == Symbol.BLANK) {
					blankCount++;
				}
			}
		}

		blankScore = blankCount * 100.0;		//every blank gives 100 score
		if (role == PlayerRole.MIN) {
			blankScore = -1.0 * blankScore;	//negate for min player
		}

		//
		// *** Apart from the usual minimax score, we add in the blank score as
		// *** we prefer to win ASAP (i.e. end up in a state with more blanks) rather than later.
		//
		return utility(state, Symbol.CROSS) - utility(state, Symbol.NAUGHT) + blankScore;
	}

	/**
	 * Calculate the utility score w.r.t. a symbol.
	 * @param state	The board state.
	 * @param symbol	The player symbol (i.e. X/O).
	 * @return		The utility score of the state towards the symbol.
	 */
	private double utility(cm3038.search.adversarial.State state, Symbol symbol)
	{
		double result = 0.0;
		int[] count = new int[4];

		TttState tttState = (TttState)state;

		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		int symbolCount = 0;
		
		for (int y = 0; y < tttState.board.length; y++) {
			symbolCount = rowSymbolCount(tttState, y, symbol);
			count[symbolCount]++;
		}

		for (int x = 0; x < tttState.board[0].length; x++) {
			symbolCount = columnSymbolCount(tttState, x, symbol);
			count[symbolCount]++;
		}
		
		symbolCount = upDiagonalSymbolCount(tttState, symbol);
		count[symbolCount]++;

		symbolCount = downDiagonalSymbolCount(tttState, symbol);
		count[symbolCount]++;

		result += count[3] * 1000 + count[2] * 10 + count[1] * 1;
		return result;
	}
}
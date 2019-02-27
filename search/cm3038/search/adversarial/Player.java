package cm3038.search.adversarial;

import cm3038.search.Action;

/**
 * This class models a player in the game.
 * @author kit
 *
 */
public abstract class Player {
	/**
	 * We assume that every player has a name.
	 */
	public String name;

	/**
	 * The player's role in the game. It must be PlayerRole.MAX or PlayerRole.MIN.
	 */
	public PlayerRole role;

	/**
	 * Fill in the attribute values.
	 * @param name
	 * @param role
	 */
	public Player(String name, PlayerRole role) {
		this.name = name;
		this.role = role;	
	}

	public abstract Action getAction(MiniMaxSearch problem, State state);
}

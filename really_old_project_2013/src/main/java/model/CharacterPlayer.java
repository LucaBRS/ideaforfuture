package model;


/**
 * @author Luca Barsottini
 *this class is needed for the subclass of the type of player : Alein Human
 */
public abstract class  CharacterPlayer {
	
	// this method will return the current position of the selected character
	public abstract String givePosition();
	
	/**
	 * @param playerChoose this is the position choose by the player and it will stored 
	 * in the position of the selected player
	 */
	public abstract void getPosition(String playerChoose) ;
	// it will return the address of the player
	public abstract String givePlayerName();
	// it will return the type of the selecterd player : Alien or Human
	public abstract String giveType();
	
		
	
	
}

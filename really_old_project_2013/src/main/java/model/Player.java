package model;

import java.io.*;
import java.util.ArrayList;

import exceptionGame.*;


public class Player {
	private int playerNumber;
	private ArrayList<CharacterPlayer> arrayPlayer=new ArrayList<CharacterPlayer>();
	private static int maxPlayer = 8;
	private static int minPlayer = 2;
	private int counterAlien=0;
	private int counterHuman=0;
	private int currentPlayer=0;
	
	public Player(int playerNumber) throws ErrorNumberPlayer {
		if (playerNumber>maxPlayer || playerNumber<minPlayer)
			throw new ErrorNumberPlayer();
		else
			
		this.playerNumber=playerNumber;
	}

/**
 * this method will create an array with the "playerNumber" size and each player in the game  
 * will be assigned to the type Alien or Human each
 * @throws IOException
 */
public void createCharacter() throws IOException {
	
	
	//SAME LINE OF CODE ARE USELESS BUT NOT SURE IF DELETE IT...
//control if number of player is even or odd, if is odd subtract one.
	int evenPlayerNumber=0;
	if(playerNumber%2==0){
		 evenPlayerNumber=playerNumber;
		 for(int i=0; i<playerNumber; i++){
		 if(Math.random()>=0.5 && counterAlien<(evenPlayerNumber/2)){
		 
		 arrayPlayer.add(new AlienCharacter("Player"+" "+(char)(i+49)));
		 counterAlien++;
		 } else if (counterHuman<evenPlayerNumber/2){
		 
		 arrayPlayer.add(new HumanCharacter("Player"+" "+(char)(i+49)));
		 counterHuman++;
		 }
		 else i--;
		 }
		 }
		 else{
		 evenPlayerNumber=playerNumber-1;
		 for(int i=0; i<playerNumber; i++){
		 if(Math.random()>=0.5 && counterAlien<(evenPlayerNumber/2)+1){
		 
		 arrayPlayer.add(new AlienCharacter("Player"+" "+(char)(i+49)));
		 counterAlien++;
		 } else if (counterHuman<evenPlayerNumber/2){
		 
		 arrayPlayer.add(new HumanCharacter("Player"+" "+(char)(i+49)));
		 counterHuman++;
		 } else i--;
		 }
		 } 

		 
		 }

	
	//it pass the current player
	public CharacterPlayer givePlayer(int i){
		return this.arrayPlayer.get(i);
	}
	//it return the number of human that are currently play. It is helpful in case of alien attack.
	public int giveCounterHuman(){
		return this.counterHuman;
	}
	
	public void decrementHuman() throws AlienWin{
		if(this.counterHuman==0)
		this.counterHuman--;
		else
			throw new AlienWin();
	}
	
	
	//it return the current size of array that contains the number of player.
	public int giveArraySize(){
		return this.arrayPlayer.size();
	}
	//it remove a player if an alien or an human is dead.
	public void removePlayer(int i){
		this.arrayPlayer.remove(i);
		this.currentPlayer--;
	}
	
	public void incrementPlayerTurn(){
		if (this.currentPlayer>=this.arrayPlayer.size()-1)
			this.currentPlayer=0;
		else
		this.currentPlayer++;
	}	
	public int currentPlayer(){
	 return this.currentPlayer;
	}
}






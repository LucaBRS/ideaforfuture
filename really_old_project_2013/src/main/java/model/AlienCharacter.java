package model;

import java.io.*;
import java.util.Scanner;

public class AlienCharacter extends CharacterPlayer {
	private String whoAreYou =new String();
	private String currentPosition=new String("L06");
	
	
	public AlienCharacter(String namePlayer) throws IOException{
		//if player is alien, it set the sector 'AAA' as start position for the aliens.
		whoAreYou=namePlayer;
		currentPosition= "AAA";
		// the alien will start from here
	}
		public String givePlayerName(){
		return this.whoAreYou;
		}
		//assign the start position
		public String givePosition(){
			return this.currentPosition;
		}
		//pass the current position of the current alien
		@Override
		public void getPosition(String playerChoose) {
			this.currentPosition=playerChoose;
	
		}
		//pass type Alien 
		public String giveType(){
			return "Alien";
		}
}
	
	
	
	
	
	



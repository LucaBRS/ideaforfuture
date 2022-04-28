package model;
import  java.io.*;
import java.util.Scanner;
public class HumanCharacter extends CharacterPlayer {
	private String whoAreYou= new String();
	private String currentPosition=new String();
	
	
    
	public HumanCharacter(String namePlayer) throws IOException{
		whoAreYou= namePlayer;
		this.currentPosition="HHH";
	}
	
		// this will give the position to the interested one
		public String givePlayerName(){
			return this.whoAreYou;
		}
		
		public String givePosition(){
			return this.currentPosition;
		}

		@Override
		public void getPosition(String playerChoose) {
			this.currentPosition=playerChoose;
		}
	
		public String giveType(){
			return "Human";
		}

		

		
}

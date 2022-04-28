package it.polimi.ingsw.dilaurobarsottini;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import model.AlienCharacter;
import model.CharacterPlayer;
import model.HumanCharacter;
import model.Player;

import org.junit.Test;

public class TestPlayer {
	
	
	private Player player;
	
	@Test
	public void testPlayer() {
		ArrayList<CharacterPlayer> arrayPlayer1=new ArrayList<CharacterPlayer>();
		ArrayList<CharacterPlayer> arrayPlayer2=new ArrayList<CharacterPlayer>();
		int playerNumber=8;
		boolean flag=false;
		
		
		for(int i=0; i<arrayPlayer1.size(); i++){
		
			arrayPlayer1.add(player.givePlayer(playerNumber));
		}
		
		for(int i=0; i<arrayPlayer2.size(); i++){
		
			arrayPlayer2.add(player.givePlayer(playerNumber));
		}
		for(int i=0;i<arrayPlayer1.size();i++){
			assertNotEquals(arrayPlayer1.get(i), arrayPlayer2.get(i));
		
		if(arrayPlayer1.get(i) instanceof  AlienCharacter || arrayPlayer1.get(i) instanceof  HumanCharacter)
			flag=true;
		assertTrue(flag==true);

	}
	}

}

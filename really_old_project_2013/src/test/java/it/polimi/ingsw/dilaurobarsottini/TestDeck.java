package it.polimi.ingsw.dilaurobarsottini;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import model.AnyPositionCard;
import model.Deck;
import model.SectorCard;
import model.SilentCard;
import model.YourPositionCard;

import org.junit.Test;

public class TestDeck {

	private Deck deck = new Deck();
	
	//In this test i would verify the method to shuffle the deck.
	//So i create two decks and the i verify if they are equals or not.
	//If the two deck are not equals, the test has success.
	@Test
	public void testShuffleDeck() throws IOException {
		
		ArrayList<SectorCard> deck1= new ArrayList<SectorCard>();
		ArrayList<SectorCard> deck2= new ArrayList<SectorCard>();
		
		deck.shuffleDeck();

		for(int i=0;i<deck1.size();i++){
			
			deck1.add(deck.getCard());
		}
		deck.shuffleDeck();
		for(int i=0;i<deck1.size();i++){
			
			deck2.add(deck.getCard());
		}
		for(int i=0;i<deck1.size();i++)
		assertNotEquals(deck1.get(i), deck2.get(i));
		
	}


	//In this test i would verify the method getCrad() to create another the deck when the first is finish.
	//If deck2 contains the 3 type of cards, the test has success.
	@Test
	public void testGetCard() throws IOException {
	
		ArrayList<SectorCard> deck1= new ArrayList<SectorCard>();
		ArrayList<SectorCard> deck2= new ArrayList<SectorCard>();
		boolean flag=false;
		
		deck.shuffleDeck();
		for(int i=0;i<(2*25);i++){
			if (i<25){
				deck1.add(deck.getCard());
			}
			else{
				
				deck2.add(deck.getCard());
			}
		}
		for(int i=0;i<deck2.size();i++){
			if(deck2.get(i) instanceof  SilentCard || deck2.get(i) instanceof YourPositionCard || deck2.get(i) instanceof AnyPositionCard)
				flag=true;
			}
			assertTrue(flag==true);
		
	}
}
 


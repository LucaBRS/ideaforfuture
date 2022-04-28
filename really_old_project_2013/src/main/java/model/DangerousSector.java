package model;


import java.io.IOException;





/**
 * @author Luca Barsottini
 *Creation of dangerous sector with the method actionSector that will draw a card
 */
public class DangerousSector extends MapSector {
private Deck deck=new Deck();


	/* 
	 * This is the method that will draw a card and store the eventual "NOISE" in stringa
	 * and return that string
	 */
	
	@Override
	
	public SectorCard actionSector() throws IOException {
		deck.shuffleDeck();
		
		return deck.getCard();
			
		/* Metodo che mi fara pescare una carta random*/
		
		/*probabile metodo per passare il turno*/
	}

}

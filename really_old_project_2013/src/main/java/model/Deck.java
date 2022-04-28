package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private int index=0;
	private ArrayList<SectorCard> deck= new ArrayList<SectorCard>();
	
	   
	
	
	/**Create deck card that is compose by 10 YourPositionCard, 10 AnyPositionCard and 5 SilentCard.
	Create method to shuffle the deck card**/
	public void shuffleDeck(){
		int silentCard=5;
		int anyPositionCard = 10;
		int yourPositionCard = 10;
		int counterS=0,counterI=0,counterA=0;
		Random random=new Random();
		
		for(int cont=0;cont<25;cont++){
			int t = random.nextInt(3);
			if (t==0 && counterS<silentCard ){
		    	deck.add(new SilentCard());
		    	counterS++;
		    	
		     }	
		      if ( t==1 && counterA<anyPositionCard){
		    	 deck.add(new AnyPositionCard());
		    	 counterA++;
		    	 
		     }
		      if (t==2 && counterI<yourPositionCard){
		    	 deck.add(new YourPositionCard());
		    	 counterI++;
		    	 
		     }
		     else {
		    cont--;
		     }
		  	if (counterA>9 && counterI>9 &&counterS>4)
				cont=10101;
		  	counterS=0;counterI=0;counterA=0;
		  	
		}
	}
	//Create the method to pick-up a card and re-shuffle the deck when it's finish 
	public SectorCard getCard() throws IOException{
		
		int NumbSectorCards=25;
		
			if (this.index==NumbSectorCards){
			this.index=0;
			for (int i=0;i<NumbSectorCards;i++)
				deck.remove(i);
			shuffleDeck();
			getCard();
			
			
			}
			else
			this.index++;
			return deck.get(index-1);	
			
		}
			
	}


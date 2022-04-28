package model;


import java.io.IOException;




import exceptionGame.ErrorMoviment;

/**
 **@author Luca Barsottini
 **this class is usefull for controll the moviment for the alien and also for the human
 **from the choose of the player.
 */
public class ControlMoviment {
	private Moviment moviment=new Moviment();
	private String allNearPosition=new String();
	private String nextPosition=new String();
	
	public  ControlMoviment() throws IOException {}
	
public void controllAlienMoviment(String playerChoose, Player player,int i) throws IOException, ErrorMoviment{
		
		boolean flag;
		flag=false;
		this.nextPosition=playerChoose;
		//it will take all the sectors near the current position (of the alien character) and also all the sectors near the near sectors
		this.allNearPosition=this.moviment.alienMoviment(player.givePlayer(i).givePosition());
		
		//with this cycle it will iterate all the string position
		for (int index=0;index < allNearPosition.length()-2;index++){
			
			// if the player choose sector is equal to one of the sectors on the string it will put the flag to true 
			
			if (this.nextPosition.equals(""+this.allNearPosition.charAt(index)+this.allNearPosition.charAt(index+1)+this.allNearPosition.charAt(index+2))==true){
				flag=true;}
			
		}
		
		//If the flag is true and the initial position of the player is different from the player choose 
		// this will set the player choose like the new position of the alien character.
		if (flag==true&&player.givePlayer(i).givePosition().equals(this.nextPosition)==false){
			player.givePlayer(i).getPosition(this.nextPosition);
		}	
			else{
				
				throw new ErrorMoviment(); 
			
			}
	}

 public void controllHumanMoviment(String playerChoose, Player player,int i) throws IOException, ErrorMoviment {
	
	 boolean flag;
		flag=false;
		this.nextPosition=playerChoose;
		//it will take all the sectors near the current position of the human character.
		this.allNearPosition=this.moviment.humanMoviment(player.givePlayer(i).givePosition());
		
		//with this cycle il will iterate all the string position
		for (int index=0;index < allNearPosition.length()-2;index++){
			
			// if the player choose sector is equal to one of the sectors on the string it will put the flag to true
			
			if (this.nextPosition.equals(""+this.allNearPosition.charAt(index)+this.allNearPosition.charAt(index+1)+this.allNearPosition.charAt(index+2))==true){
				flag=true;}
			
		}
		
		//If the fla gis true and the initial position of the player is different from the player choose 
				// this will set the player choose like the new position of the human character.
		if (flag==true&&player.givePlayer(i).givePosition().equals(this.nextPosition)==false){
					player.givePlayer(i).getPosition(this.nextPosition);
			
		}	
		else{
			
			throw new ErrorMoviment();
		}
		
		
		
	
	
}


}

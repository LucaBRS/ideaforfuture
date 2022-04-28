package model;


import java.io.IOException;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
















import observer_observable.*;
import exceptionGame.*;

;



/**
 * @author Luca Barsottini
 *this class is used for a little of the game engine
 * like the link to the control movement of each players
 *the attack for the alien players and the dead for the human players if the attack is successful
 */
public class GameEngine extends UnicastRemoteObject implements SubjectModel, RemoteEngine  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;







	public GameEngine() throws RemoteException,IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private Player player;
	private MapCreation sector= new MapCreation();
	private int counterTurn=0;
	private SectorCard card;
    private ControlMoviment controlMoviment= new ControlMoviment();
    private ArrayList<RemoteView> obs = new ArrayList<RemoteView>();
    private ArrayList<Integer> listClient = new ArrayList<Integer>();
    private int numberClient=0;
  
    
    

    	
  
    
    public void typePlayer(){
    	for (int i=0;i<player.giveArraySize();i++)
    		notifyObserversString("Player "+(i+1)+" is:"+player.givePlayer(i).giveType());
    }
    
    public  String startingInformationPlayer(int clientID) throws InterruptedException{
    		
    	
    	return "U are Player "+(clientID+1)+"type: "+player.givePlayer(clientID).giveType()+".\nIn position: "+player.givePlayer(clientID).givePosition();
    }
    
    
	/*
	 * this method create the number of players and call the Player which create 
	 * each type of players
	 * @returnreturn the number of players insert
	 * @throws IOException
	 */
	public void  getPlayerNumber() throws IOException, ErrorNumberPlayer {
		
		player= new Player(listClient.size());
		player.createCharacter();	
		typePlayer();
	}
		
		
		
		
		
		/**
		 * Class for the control movement of the players
		 * @param i it is useful for get the number of player
		 * @return 
		 * @throws IOException
		 * @throws ErrorMoviment 
		 */
	public String movimentActionPlayer(int currentPlayer,String playerChoose) throws IOException, ErrorMoviment{
			
			if (player.givePlayer(currentPlayer).giveType().equals("Alien")){
				 controlMoviment.controllAlienMoviment(playerChoose, player, currentPlayer);
			return "Movement correct good one bro.\nPress Y or N to attack (if u want...)";}
			else {
				 controlMoviment.controllHumanMoviment(playerChoose, player, currentPlayer);
				 return "Bro movement correct !.\nPress ENTER";}
			
	
			
		
		}
		
		
		/**this method will do the attack for the alien and also will control
		 * if is human or alien to allow it to attack and remove the player from the 
		 * cycle (and from the arrayList)
		 * @param i this is useful for focus on the player number
		 * @throws IOException
		 * @throws ErrorAttack 
		 * @throws AlienWin 
		 * @throws HumanWin 
		 */
	public String alienAttack(int clientID,String choose) throws IOException, ErrorAttack, AlienWin, HumanWin{ 
		
			
			
			if(player.givePlayer(clientID).giveType().equals("Alien")){
			
			
			
			if(choose.equals("Y")){
				
				
				for(int j=0;j<player.giveArraySize();j++){
					
						
						if(player.givePlayer(j).givePosition().equals(player.givePlayer(clientID).givePosition())&&player.givePlayer(j)!=player.givePlayer(clientID)){
							
							notifyObserversString("You have successfuly attacked Player "+(j+1)+". Player "+(j+1)+" is death.");
						
							
							
							if (player.givePlayer(j).giveType().equals("Human")){
							player.decrementHuman();
							player.removePlayer(j);
							}
						}
						else{
							
							notifyObserversString("Attack no results");
							}
					
					
				}
			
				notifyObserversString("Player "+(clientID+1)+" is an Alien");
				
				
				
			}
			else if(choose.equals("N"))
					return drawCard(clientID);
				else {
					throw new ErrorAttack();
					
				}
			}
			else
				return drawCard(clientID);
			
			
			return"";
		}
		
		

	
	
	/**
	 * Class to make the player draw a card and do the rules of the card
	 * @param i useful to get the number of player
	 * @return return the flag if the flag is false the Human will win
	 * @throws IOException
	 * @throws HumanWin 
	 */
	public String drawCard(int clientID) throws IOException, HumanWin{
		
			
		 card = sector.getSector(player.givePlayer(clientID).givePosition()).actionSector();
		 if (card instanceof AnyPositionCard){
			 return"You draw a NOISE IN ANY SECTOR.\nInsert a position where do you want to declare a noise:\n";
			 
			 }
			 else if(card instanceof YourPositionCard){
			 return"Yuo draw a NOISE IN YOUR SECTOR card.\nPress ENTER to go forward.\n";
			 
			 }
			 else if(card instanceof SilentCard){
			 return"You draw a SILENT card.\nPress ENTER to go forward.\n";
			 
			 
			 }
			 else
			 return"You are in safe sector.\n";
	
			 
	
	}
	
	
	public void doCardAction(String position,int clientID) throws IOException, IncorrectPosition{
		if (card instanceof YourPositionCard)
			position= player.givePlayer(clientID).givePosition();
		if (card!=null)
		notifyObserversString(card.actionCard(position));	
		else
			notifyObserversString("The player"+(clientID+1)+" did not drow");
	}
	
	
	/**
	 * @return the size of the array player
	 */
	
	
	public void controlTurn() throws AlienWin{

		this.counterTurn++;
		if (this.counterTurn==40)
			throw new AlienWin();
		notifyObserversString("TURN "+this.counterTurn);	
	}
	
	public void incrementPlayerTurn(){
		player.incrementPlayerTurn();
	}
	
	public void cyclePlayerTurn() throws AlienWin{
		
				if (player.currentPlayer()==0){
					controlTurn();	
				}	
				notifyObserversString("Is Player "+(player.currentPlayer()+1)+" turn \n"
				);
				
			incrementPlayerTurn();
		
	}

	public int connectClients(){
		 if (numberClient<8){
		 listClient.add(numberClient);
		 numberClient++;
		 return numberClient-1;
		 }
		 return 100 ;
		 }
		 
		 
		 public synchronized void amIThePlayer(int clientID) throws InterruptedException{
		 if (clientID!=player.currentPlayer()){
			
		 this.wait();
		 amIThePlayer(clientID);}
		 }
		 
		 public synchronized void wakeUpPlayers(){
		 this.notifyAll();
		 }
	
	
	
	
	@Override
	public void registerObserver(RemoteView o) {
			obs.add(o);
		
	}

	@Override
	public void unregisterObserver(int index) {
		obs.remove(index);
		
	}

	@Override
	public void notifyObserversString(String string) {
		for(int i=0;i<obs.size();i++)
			try {
				obs.get(i).updateString(string);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	
	
}

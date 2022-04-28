package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;







import java.nio.charset.Charset;
import java.rmi.RemoteException;

import model.*;
import exceptionGame.AlienWin;
import exceptionGame.ErrorAttack;
import exceptionGame.ErrorMoviment;
import exceptionGame.ErrorNumberPlayer;
import exceptionGame.HumanWin;
import exceptionGame.IncorrectPosition;
import observer_observable.*;



public class ViewObserverObservable implements RemoteView , SubjectView{
	private InputStreamReader reader=new InputStreamReader(System.in);
	private BufferedReader myInput= new BufferedReader(reader);
	
	
	private ClientInterface obsC;
	
	
	
	private PhysicsMaps map =new PhysicsMaps();
	
	public ViewObserverObservable() throws IOException {}
	
	@Override
	public void updateString(String string) {
			System.out.println(string);
	}
	
	
	
	
	
	
	@Override
	public void registerObserver(ClientInterface o) {
		this.obsC=o;
		
	}


	@Override
	public void unregisterObserver(ClientInterface o) {
		// TODO Auto-generated method stub
		
	}


	
	public void startLog(){
		System.out.println("Welcome to the league of DRAVEN!!!!!!\n");
		System.out.println("O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O O.O\n\n");
		System.out.println("WELCOME INTO THIS AMAZING GAME: ESCAPE FROM ALIENS!!!\n"
				+ "VERY IMPORTANT : WHITE CELL ARE WITH THE FIRST LETTER UPPER-CASE AND THE DANGEROUS SECTOR ARE DOWN-CASE\n\n");
		System.out.println(":O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O :O\n");
	}
	
	@Override
	public void startingInformationPlayer()
			throws InterruptedException, RemoteException {
	
		System.out.println( obsC.startingInformationPlayer());
	}

	@Override
	public void movimentActionPlayer() throws IOException,HumanWin {
			
		System.out.println("Where do you want to move?");
	
			try {
				System.out.println( obsC.movimentActionPlayer(myInput.readLine().toUpperCase()));
			
		} catch (IOException | ErrorMoviment e) {
			System.err.println("Movement not correct");
			movimentActionPlayer();
		}
		
	}


	@Override
	public void alienAttack() throws IOException, AlienWin, HumanWin {
		try {
			System.out.println( obsC.alienAttack(myInput.readLine().toUpperCase()));
		}  catch (ErrorAttack e) {
			System.err.println("Incorrect.\nInsert only Y or N to decide.");
			 alienAttack();
		}
	}


	@Override
	public void doCardAction() throws IOException{
		
			try {
				obsC.doCardAction(myInput.readLine());
			} catch (IOException | IncorrectPosition e) {
				System.out.println("Incorrect. Please insert an existing sector");
				doCardAction();
			}
			
		
		
	}

	public void cyclePlayerTurn() throws AlienWin, RemoteException{
		System.out.println("Press ENTER to go forward:");
		try {
			myInput.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		try {
			map.galileiMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obsC.cyclePlayerTurn();
	}

	
	public void connect() throws IOException{
		obsC.connect();
	}
	 public void amIThePlayer() throws InterruptedException, RemoteException{
		 obsC.amIThePlayer();
	 }
	 
	 public void wakeUpPlayers() throws RemoteException{
		 obsC.wakeUpPlayers();
	 }

	
	
	
}

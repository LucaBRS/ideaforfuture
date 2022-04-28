package client;

import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import observer_observable.ClientInterface;
import observer_observable.RemoteEngine;
import observer_observable.RemoteView;
import exceptionGame.*;


public class Client implements ClientInterface{
	private RemoteView remoteView;
	private RemoteEngine game;
	private int  clientID=0;
	private String name = "RemoteGame";
	private Registry registry=null;
	
	
	public Client(RemoteView remoteView){
		this.remoteView=remoteView;
	}
	
	
	public void connect() throws IOException {
		 
		 try {
		 registry = LocateRegistry.getRegistry(2026);
		 System.out.println("connect");
		 } catch (RemoteException e) { 
		 e.printStackTrace();
		 
		 }
		 
		 try {
		 game = (RemoteEngine) registry.lookup(name);
		// ((CallableClient) registry.lookup(clientName)).setClientPort(2026);
		 } catch (AccessException e) {
		 e.printStackTrace();
		 
		 } catch (RemoteException e) {
		 e.printStackTrace();
		 
		 } catch (NotBoundException e) {
		 e.printStackTrace();
		 
		 }
		
		 clientID=game.connectClients();
		  try {
			registry.bind((char)clientID+"",this.remoteView );
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
	
	
	 public void amIThePlayer() throws InterruptedException, RemoteException{
		 game.amIThePlayer(this.clientID);
	 }
	
	
	
	public String startingInformationPlayer() throws RemoteException{
		try {
			return game.startingInformationPlayer(clientID);
		} catch (InterruptedException e) {
			startingInformationPlayer( );
			
		}return"lol";
	}

	


	@Override
	public String movimentActionPlayer(String playerChoose) throws IOException, ErrorMoviment {
		return game.movimentActionPlayer(this.clientID, playerChoose);
		
		
	}


	@Override
	public String alienAttack(String choose) throws IOException, ErrorAttack, AlienWin, HumanWin {
	return 	game.alienAttack(this.clientID, choose);
		
	}

	@Override
	public void doCardAction(String position) throws IOException,
			IncorrectPosition {
		game.doCardAction(position, this.clientID);
		
	}


	@Override
	public void cyclePlayerTurn() throws AlienWin, RemoteException {
		game.cyclePlayerTurn();
		
	}
	
	
	 public void wakeUpPlayers() throws RemoteException{
		 game.wakeUpPlayers();
		 }



	



	
}

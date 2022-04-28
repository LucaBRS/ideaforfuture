package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import exceptionGame.ErrorNumberPlayer;
import observer_observable.RemoteEngine;
import model.GameEngine;

public class ServerRMI {
	public static void main(String[] args) throws IOException, NotBoundException{
		 Registry registry = null;
		 String name = "RemoteGame";
		 //**************************************
		 InputStreamReader reader=new InputStreamReader(System.in);
		 BufferedReader myInput= new BufferedReader(reader);
		 GameEngine game2= new GameEngine();
		 
		 try{
		 
		 RemoteEngine game = game2;
		 registry = LocateRegistry.createRegistry(2026);
		 
		 registry.bind(name, game);
		 System.out.println("ComputeEngine bound");
		 } catch(Exception e) {
		 System.err.println("ComputeEngine exception:");
		 e.printStackTrace();
		 registry = null;
		 }
		 
		 
			System.out.println("Press Enter to start the game");
			myInput.readLine();
			try {
				game2.getPlayerNumber();
			} catch (ErrorNumberPlayer e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	

		
}

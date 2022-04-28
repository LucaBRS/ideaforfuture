package observer_observable;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptionGame.AlienWin;
import exceptionGame.ErrorAttack;
import exceptionGame.ErrorMoviment;
import exceptionGame.ErrorNumberPlayer;
import exceptionGame.HumanWin;
import exceptionGame.IncorrectPosition;

public interface RemoteEngine extends Remote  {
	public String startingInformationPlayer(int clientID) throws RemoteException, InterruptedException;
	public String movimentActionPlayer(int currentPlayer,String playerChoose) throws RemoteException,IOException, ErrorMoviment;
	public String alienAttack(int clientID,String choose) throws RemoteException,IOException, ErrorAttack, AlienWin, HumanWin;
	public void doCardAction(String position,int clientID) throws RemoteException, IOException, IncorrectPosition;
	public void cyclePlayerTurn() throws RemoteException, AlienWin;
	public int connectClients() throws RemoteException;
	public void amIThePlayer(int clientID) throws RemoteException, InterruptedException;
	public void wakeUpPlayers() throws RemoteException;
}

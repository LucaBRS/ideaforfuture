package observer_observable;

import java.io.IOException;
import java.rmi.RemoteException;

import exceptionGame.AlienWin;
import exceptionGame.ErrorAttack;
import exceptionGame.ErrorMoviment;
import exceptionGame.HumanWin;
import exceptionGame.IncorrectPosition;

public interface ClientInterface {
	public String startingInformationPlayer() throws RemoteException ;
	public String movimentActionPlayer(String playerChoose) throws RemoteException, IOException, ErrorMoviment;
	public String alienAttack(String choose) throws RemoteException, IOException, ErrorAttack, AlienWin, HumanWin;
	public void doCardAction(String position) throws  RemoteException,IOException, IncorrectPosition;
	public void cyclePlayerTurn() throws AlienWin, RemoteException;
	public void connect() throws RemoteException,IOException;
	public void amIThePlayer() throws RemoteException,InterruptedException;
	public void wakeUpPlayers() throws RemoteException;
}

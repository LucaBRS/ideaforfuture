package observer_observable;

import java.io.IOException;
import java.rmi.RemoteException;

import exceptionGame.AlienWin;
import exceptionGame.ErrorAttack;
import exceptionGame.ErrorMoviment;
import exceptionGame.HumanWin;
import exceptionGame.IncorrectPosition;
import model.SectorCard;

public interface SubjectView {
	public void registerObserver(ClientInterface o);
	public void unregisterObserver(ClientInterface o);
	public void startLog();
	public void startingInformationPlayer() throws InterruptedException, RemoteException;
	public void movimentActionPlayer() throws IOException, HumanWin;
	public void alienAttack() throws IOException, AlienWin, HumanWin;
	public void doCardAction() throws IOException;
	public void cyclePlayerTurn() throws AlienWin, RemoteException;
	 public void amIThePlayer() throws InterruptedException, RemoteException;
	 public void wakeUpPlayers() throws RemoteException;
	public void connect() throws IOException;
}

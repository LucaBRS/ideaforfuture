package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import observer_observable.SubjectView;
import exceptionGame.AlienWin;
import exceptionGame.ErrorNumberPlayer;
import exceptionGame.HumanWin;
import view.ViewObserverObservable;

public class MainView {
	public static void main( String[] args ) throws IOException, ErrorNumberPlayer, InterruptedException   {
		 InputStreamReader reader=new InputStreamReader(System.in);
		 BufferedReader myInput= new BufferedReader(reader);
	SubjectView	startView= new ViewObserverObservable ();
	
		//startView.registerObserver(new Client());
		
		startView.startLog();
		startView.connect();
		
		myInput.readLine();
		
		while(true){
			
			startView.amIThePlayer();
			startView.startingInformationPlayer();
			try {
				startView.cyclePlayerTurn();
			} catch (AlienWin e1) {
				System.out.println("ALIENIIIIII");
				e1.printStackTrace();
			}
			
			startView.startingInformationPlayer();
			
			try {
				startView.movimentActionPlayer();
			} catch (HumanWin e) {
				System.out.println("HUMAAAAAAAAAAAN");
				e.printStackTrace();
			}
			try {
				startView.alienAttack();
			} catch (AlienWin e) {
				System.out.println("ALIENIIIII!");
				e.printStackTrace();
			} catch (HumanWin e) {
				System.out.println("HUMAAAAAAAAAAAN");
				e.printStackTrace();
			}
			startView.doCardAction();
			startView.wakeUpPlayers();
			
			
		}
	}
	
	
}

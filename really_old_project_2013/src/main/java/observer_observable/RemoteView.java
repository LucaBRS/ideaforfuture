package observer_observable;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface RemoteView extends Remote{
	public void updateString(String string) throws RemoteException;
	
	
}

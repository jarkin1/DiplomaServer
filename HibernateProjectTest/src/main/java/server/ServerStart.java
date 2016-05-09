package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;



public class ServerStart {
	public static void main(String[] args) throws RemoteException {
		try {
			ServerImpl server = new ServerImpl();
			Naming.rebind("rmi://localhost:1099/Server", server);
			System.out.println("Server is ready!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

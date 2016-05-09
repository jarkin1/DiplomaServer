package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.Server;

public class BaseClient {
	public static Server getServer(){
		Server server = null;
		try {
			server = (Server) Naming.lookup("rmi://localhost:1099/Server");
			return server;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}		
		return server;
	}
	
	
	
}

package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Error, Server not found, please launch server!");
		} catch (NotBoundException e) {
			e.printStackTrace();
		}		
		return server;
	}
	
	
	
}

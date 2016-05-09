package client;

import java.rmi.RemoteException;

import dm.entity.Login;

public class LoginClient {
	
	public static boolean checkLogin(String userName, String password){
		try {
			return BaseClient.getServer().checkLogin(userName, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void saveLogin(Login login){
		try {
			BaseClient.getServer().saveLogin(login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

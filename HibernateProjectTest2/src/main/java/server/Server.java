package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dm.entity.Goods;
import dm.entity.Login;
import dm.entity.OrderLine;



public interface Server extends Remote{
	
	boolean checkLogin(String userName, String password) throws RemoteException;
	
	List<Goods> findAllGoods() throws RemoteException;
	
	void saveGoods(Goods goods) throws RemoteException;
	void removeGoods(int id) throws RemoteException;
	Goods findById(int id) throws RemoteException;
	
	void saveOrderLine(OrderLine orderLine) throws RemoteException;
	
	void saveLogin(Login login) throws RemoteException;
	
}

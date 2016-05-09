package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;

import dm.daoimpl.GoodsDAOImpl;
import dm.daoimpl.LoginDAOImpl;
import dm.entity.Goods;
import dm.entity.Login;




@SuppressWarnings("serial")
public class ServerImpl extends UnicastRemoteObject implements Server{
	protected ServerImpl() throws RemoteException {
		LocateRegistry.createRegistry(1099);
	}
	private GoodsDAOImpl goodsDAOImpl = new GoodsDAOImpl();
	private LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
	
	@Override
	public boolean checkLogin(String userName, String password) throws RemoteException {
		List<Login> list = loginDAOImpl.findAll();
		Login login = new Login(userName, password);
		Iterator<Login> iterator = list.iterator();
		while(iterator.hasNext()){
			Login temp = iterator.next();
			if(temp.getUserName().equals(login.getUserName()) && temp.getPassword().equals(login.getPassword())){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Goods> findAllGoods() throws RemoteException {
		return goodsDAOImpl.findAll();
	}

	@Override
	public void saveGoods(Goods goods) throws RemoteException {
		Goods good = (Goods)goods;
		goodsDAOImpl.save(good);
	}


	@Override
	public void saveLogin(Login login) throws RemoteException {
		loginDAOImpl.save((Login)login);
	}

	@Override
	public void removeGoods(Goods goods) throws RemoteException {
		Goods good = (Goods)goods;
		goodsDAOImpl.remove(good);
	}

	@Override
	public Goods findById(int id) throws RemoteException {
		return goodsDAOImpl.findById(id);
	}

	
	
	
	


}

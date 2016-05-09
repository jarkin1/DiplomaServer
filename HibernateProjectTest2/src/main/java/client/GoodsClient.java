package client;

import java.rmi.RemoteException;
import java.util.List;

import dm.entity.Goods;

public class GoodsClient {
	
	public static List<Goods> findAllGoods(){
		try {
			return (List<Goods>) BaseClient.getServer().findAllGoods();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void saveGoods(Goods goods){
		try {
			BaseClient.getServer().saveGoods(goods);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public static Goods findById(int id){
		try {
			return (Goods)BaseClient.getServer().findById(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void removeGoods(Goods goods){
		try {
			Goods good = (Goods)goods;
			BaseClient.getServer().removeGoods(good);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

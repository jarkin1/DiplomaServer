package client;

import java.rmi.RemoteException;

import dm.entity.OrderLine;

public class OrderLineClient {
	
	public static void saveOrderLine(OrderLine orderLine){
		try {
			BaseClient.getServer().saveOrderLine(orderLine);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}

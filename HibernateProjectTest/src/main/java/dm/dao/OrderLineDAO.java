package dm.dao;

import java.util.List;

import dm.entity.OrderLine;

public interface OrderLineDAO{
	OrderLine findById(int id);
	void save(OrderLine orderLine);
	void remove(OrderLine orderLine);
	OrderLine update(OrderLine orderLine);
	List<OrderLine> findAll();
}

package dm.dao;

import java.util.List;

import dm.entity.Order2;

public interface OrderDAO{
	Order2 findById(int id);
	void save(Order2 order);
	void remove(Order2 order);
	Order2 update(Order2 order);
	List<Order2> findAll();
}

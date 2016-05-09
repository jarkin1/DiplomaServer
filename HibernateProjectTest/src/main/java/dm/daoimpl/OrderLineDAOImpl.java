package dm.daoimpl;

import java.util.List;
import org.hibernate.Session;
import dm.dao.OrderLineDAO;
import dm.entity.OrderLine;

public class OrderLineDAOImpl implements OrderLineDAO{
	static Session session = HibernateUtil.getSessionFactory().openSession();
	public OrderLine findById(int id) {
		session.beginTransaction();
		OrderLine object = (OrderLine) session.get(OrderLine.class, id);
		session.getTransaction().commit();
		return object;
	}

	public void save(OrderLine orderLine) {
		session.beginTransaction();
		session.save(orderLine);
		session.getTransaction().commit();		
	}

	public void remove(OrderLine orderLine) {
		session.beginTransaction();
		session.delete(orderLine);
		session.getTransaction().commit();		
	}

	public OrderLine update(OrderLine orderLine) {
		session.beginTransaction();
		OrderLine object = (OrderLine) session.get(OrderLine.class, orderLine.getId());
		session.getTransaction().commit();
		return object;
	}

	public List<OrderLine> findAll() {
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrderLine> orderLine = (List<OrderLine>) session.createQuery("Select u FROM OrderLine u ").list();
		session.getTransaction().commit();
		return orderLine;
	}

}

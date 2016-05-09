package dm.daoimpl;

import java.util.List;
import org.hibernate.Session;
import dm.dao.OrderDAO;
import dm.entity.Order2;

public class OrderDAOImpl implements OrderDAO{
	static Session session = HibernateUtil.getSessionFactory().openSession();

	public Order2 findById(int id) {
		session.beginTransaction();
		Order2 object = (Order2) session.get(Order2.class, id);
		session.getTransaction().commit();
		return object;
	}

	public void save(Order2 order) {
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();		
	}

	public void remove(Order2 order) {
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();		
	}

	public Order2 update(Order2 order) {
		session.beginTransaction();
		Order2 object = (Order2) session.get(Order2.class, order.getId());
		session.getTransaction().commit();
		return object;
	}

	public List<Order2> findAll() {
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Order2> orders = (List<Order2>) session.createQuery("Select u FROM Order2 u ").list();
		session.getTransaction().commit();
		return orders;
	}
}

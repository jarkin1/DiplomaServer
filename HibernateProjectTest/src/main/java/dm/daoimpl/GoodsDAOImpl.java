package dm.daoimpl;

import java.util.List;
import org.hibernate.Session;
import dm.dao.GoodsDAO;
import dm.entity.Goods;

public class GoodsDAOImpl implements GoodsDAO{
	

	static Session session = HibernateUtil.getSessionFactory().openSession();

	public Goods findById(int id) {
		session.beginTransaction();
		Goods object = (Goods) session.get(Goods.class, id);
		session.getTransaction().commit();
		return object;
	}

	public void save(Goods goods) {
		session.beginTransaction();
		session.save(goods);
		session.getTransaction().commit();		
	}

	public void remove(int id) {
		session.beginTransaction();
		Goods goods = (Goods)session.load(Goods.class, id);
		session.delete(goods);
		session.getTransaction().commit();		
	}

	public Goods update(Goods goods) {
		session.beginTransaction();
		Goods object = (Goods) session.get(Goods.class, goods.getId());
		session.getTransaction().commit();
		return object;
	}

	public List<Goods> findAll() {
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Goods> goods = (List<Goods>) session.createQuery("Select u FROM Goods u ").list();
		session.getTransaction().commit();
		return goods;
	}

}

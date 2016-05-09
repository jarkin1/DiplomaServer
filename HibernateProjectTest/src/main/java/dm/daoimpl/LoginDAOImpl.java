package dm.daoimpl;

import java.util.List;

import org.hibernate.Session;

import dm.dao.LoginDAO;
import dm.entity.Login;

public class LoginDAOImpl implements LoginDAO{
	static Session session = HibernateUtil.getSessionFactory().openSession();

	public Login findById(int id) {
		session.beginTransaction();
		Login object = (Login) session.get(Login.class, id);
		session.getTransaction().commit();
		return object;
	}

	public void save(Login login) {
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();		
	}

	public void remove(Login login) {
		session.beginTransaction();
		session.delete(login);
		session.getTransaction().commit();		
	}

	public Login update(Login login) {
		session.beginTransaction();
		Login object = (Login) session.get(Login.class, login.getId());
		session.getTransaction().commit();
		return object;
	}

	public List<Login> findAll() {
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Login> login = (List<Login>) session.createQuery("Select u FROM Login u ").list();
		session.getTransaction().commit();
		return login;
	}
	
}

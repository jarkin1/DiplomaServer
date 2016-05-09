package dm.dao;


import java.util.List;

import dm.entity.Login;


public interface LoginDAO {
	Login findById(int id);
	void save(Login login);
	void remove(Login login);
	Login update(Login login);
	List<Login> findAll();
}

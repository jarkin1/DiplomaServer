package dm.dao;

import java.util.List;
import dm.entity.Goods;

public interface GoodsDAO {
	Goods findById(int id);
	void save(Goods goods);
	void remove(Goods goods);
	Goods update(Goods goods);
	List<Goods> findAll();
	
}

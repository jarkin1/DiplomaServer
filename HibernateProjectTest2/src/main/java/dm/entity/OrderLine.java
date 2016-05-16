package dm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable{
	private static final long serialVersionUID = -2928528834656517658L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private int discount;
	@ManyToOne
	private Goods goods;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order2 order;
	
	//Constructor
	public OrderLine(int amount, int discount, Goods goods) {
		this.amount = amount;
		this.discount = discount;
		this.goods = goods;
	}
	public OrderLine() {
	}

	//Methods
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Order2 getOrder() {
		return order;
	}
	public void setOrder(Order2 order) {
		this.order = order;
	}
	
	
}

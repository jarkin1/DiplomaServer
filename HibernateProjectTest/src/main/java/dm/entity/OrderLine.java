package dm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private int discount;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Goods goods;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order2 order;
	
	//Constructor
	public OrderLine(int amount, int discount, Goods goods, Order2 order) {
		this.amount = amount;
		this.discount = discount;
		this.goods = goods;
		this.order = order;
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

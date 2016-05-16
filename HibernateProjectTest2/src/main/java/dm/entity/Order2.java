package dm.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;


@Entity
public class Order2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	@Type(type="timestamp")
	private Date createDate;
	@Column(length = 20)
	private String deliveryAddress;
	@Enumerated(EnumType.STRING)
	private ShippingType shippingType;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	@OneToMany(mappedBy = "order")
	private List<OrderLine> orderLine;
	@ManyToOne
	private Customer customer;
	
	
	//Constructor
	public Order2(Date createDate, String deliveryAddress, ShippingType shippingType, OrderStatus orderStatus,
			List<OrderLine> orderLine) {
		super();
		this.createDate = createDate;
		this.deliveryAddress = deliveryAddress;
		this.shippingType = shippingType;
		this.orderStatus = orderStatus;
		this.orderLine = orderLine;
	}
	public Order2() {
	}
	
	
	//Methods
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public ShippingType getShippingType() {
		return shippingType;
	}
	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderLine> getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
	
}
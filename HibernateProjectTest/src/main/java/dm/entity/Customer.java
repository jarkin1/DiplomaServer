package dm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String secondName;
	@Column(length = 30)
	private String phone;
	@Column(length = 30)
	private String email;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade=CascadeType.ALL)
	List<Order2> orders;
	public Customer(String firstName, String secondName, String phone, String email) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.phone = phone;
		this.email = email;
	}
	public Customer() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order2> getOrders() {
		return orders;
	}
	public void setOrders(List<Order2> orders) {
		this.orders = orders;
	}
	
	
}

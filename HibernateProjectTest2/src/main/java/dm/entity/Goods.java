package dm.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goods implements Serializable{
	private static final long serialVersionUID = 3912322017877317448L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 10)
	private String code;
	@Column(length = 30)
	private String name;
	private int price;
	private double weight;
	private int amount;
	
	
	//Constructor
	public Goods(String code, String name, int price, double weight, int amount){
		this.code = code;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.amount = amount;
	}	
	public Goods(int id, String code, String name, int price, double weight, int amount){
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.amount = amount;
	}	
	public Goods(){
	}

	
	//Methods
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + ", weight=" + weight
				+ ", amount=" + amount + "]";
	}
	
	

}

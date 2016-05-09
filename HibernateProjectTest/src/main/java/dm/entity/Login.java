package dm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login implements Serializable{
	private static final long serialVersionUID = -3956818959242715326L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 30)
	private String userName;
	@Column(length = 30)
	private String password;
	
	
	//Constructor
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Login() {
	}
	
	
	//Methods
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", password=" + password + "] \n";
	}
	
	
	
}

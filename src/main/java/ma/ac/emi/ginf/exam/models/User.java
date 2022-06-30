package ma.ac.emi.ginf.exam.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, insertable = false, updatable = false)
	private int id;
	
	@Column(insertable=false, updatable = false)
	private String mail;
	
	@Column(insertable=false, updatable = false)
	private String username;
	
	@Column(insertable=false, updatable = false)
	private String password;
	
	@Column(insertable=false, updatable = false)
	@Enumerated(EnumType.STRING)
	private UserType role;
	
	
	public User() {
		super();
	}
	
	public User(String mail,String us, String mdp, UserType role) {
		super();
		setMail(mail);
		setUsername(us);
		setMdp(mdp);
		setRole(role);
	}
	
	
	@JsonIgnore
	@JsonProperty(value = "mdp")
	public String getMdp() {
		return(this.mdp);
	}
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId() {
		return(this.id);
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public UserType getRole() {
		return role;
	}
	public void setRole(UserType role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return this.id + " User : " + this.username + " " + this.mdp + " " + this.role;
	}
	
}

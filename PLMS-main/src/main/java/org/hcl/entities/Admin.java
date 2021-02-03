package org.hcl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String firstname;
	private String lastname;
	private String gender;
	private Integer age;
	private String phonenumber;
	@Column(unique = true, nullable = false)
	private String vendorid;
	private String password;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstname, String lastname, String gender, Integer age, String phonenumber, String username,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.phonenumber = phonenumber;
		this.vendorid = username;
		this.password = password;
	}

	public Admin(Integer uid, String firstname, String lastname, String gender, Integer age, String phonenumber,
			String username, String password) {
		super();
		this.uid = uid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
		this.phonenumber = phonenumber;
		this.vendorid = username;
		this.password = password;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return vendorid;
	}

	public void setUsername(String username) {
		this.vendorid = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
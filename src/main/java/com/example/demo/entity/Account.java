package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="ACCOUNTS")
public class Account implements Serializable,Cloneable{

	protected Account(){}

	public Account(String username,String password,boolean isAdmin){
		setId(0);
		setUsername(username);
		setPassword(password);
		setEnabled(true);
		setAdmin(isAdmin);
	}

	@Id
    @Column(name="USERID",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	private int id;

	@Column(name="U_ID",unique = true)
	private String username;

	@Column(name="U_PASS")
	private String password;

	@Column(name="ENABLED")
    private boolean enabled;

	@Column(name="ADMIN")
    private boolean admin;




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
}
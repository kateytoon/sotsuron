package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="TEACHER")
public class Teacher {
	@Id
    @Column(name="T_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int T_ID;

	@Column(name="T_NAME")
	@Size(max = 50)
    private String T_NAME;

	@OneToOne
	@JoinColumn(name = "U_ID")
	private Account account;



	public Account getAccount() {
		return account;
	}



	public int getT_ID() {
		return T_ID;
	}



	public String getT_NAME() {
		return T_NAME;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public void setT_ID(int t_ID) {
		T_ID = t_ID;
	}



	public void setT_NAME(String t_NAME) {
		T_NAME = t_NAME;
	}
}

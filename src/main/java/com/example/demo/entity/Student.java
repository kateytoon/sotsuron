package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="STUDENT")
public class Student implements Serializable, Cloneable{
	@Id
    @Column(name="S_ID")
	@Size(max = 8)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int S_ID;

	@Column(name="S_NAME")
	@Size(max = 50)
    private String S_NAME;

	@Column(name="S_NUM")
    private int S_NUM;

	@Column(name="S_MAIL")
	@Size(max = 50)
    private String S_MAIL;

	@ManyToOne
	@JoinColumn(name="D_ID")
	private Department department;

	@ManyToOne
	@JoinColumn(name="R_ID")
	private Classroom classroom;

	@OneToOne
	@JoinColumn(name="U_ID", referencedColumnName = "U_ID")
	private Account account;

	@Column(name="S_FLG")
    private boolean S_FLG;

	@Column(name="S_YEAR")
    private int S_YEAR;


	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
    private List<Application> application;





	public Account getAccount() {
		return account;
	}

	public List<Application> getApplication() {
		return application;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public Department getDepartment() {
		return department;
	}

	public int getS_ID() {
		return S_ID;
	}

	public String getS_MAIL() {
		return S_MAIL;
	}

	public String getS_NAME() {
		return S_NAME;
	}

	public int getS_NUM() {
		return S_NUM;
	}

	public int getS_YEAR() {
		return S_YEAR;
	}

	public boolean isS_FLG() {
		return S_FLG;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setS_FLG(boolean s_FLG) {
		S_FLG = s_FLG;
	}

	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}

	public void setS_MAIL(String s_MAIL) {
		S_MAIL = s_MAIL;
	}

	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}

	public void setS_NUM(int s_NUM) {
		S_NUM = s_NUM;
	}

	public void setS_YEAR(int s_YEAR) {
		S_YEAR = s_YEAR;
	}



}

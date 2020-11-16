package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMPANYLIST")
public class CompanyList {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int ID;

	public CompanyList() {

	}

	@ManyToOne
	@JoinColumn(name="API_ID")
	private Application application;

	@ManyToOne
	@JoinColumn(name="C_ID")
	private Company company;



	public CompanyList(Application api,Company com) {
		setApplication(api);
		setCompany(com);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}

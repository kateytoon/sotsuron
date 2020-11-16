package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="COMPANY")
public class Company {




	public Company(String c_NAME, String c_URL ) {

		C_NAME = c_NAME;
		C_URL = c_URL;

	}

	public Company() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Id
	@Column(name="C_ID")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	//@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	//@Size(max = 8)
    private int C_ID;

	@Column(name="C_NAME")
	@Size(max = 50)
    private String C_NAME;

	@Column(name="C_URL")
	@Size(max = 50)
    private String C_URL;

	@Column(name="C_NUM")
	@Size(max = 50)
    private String C_NUM;

	@OneToMany(mappedBy="company")
	private List<CompanyList> companylist;

	public int getC_ID() {
		return C_ID;
	}

	public String getC_NAME() {
		return C_NAME;
	}

	public String getC_NUM() {
		return C_NUM;
	}

	public String getC_URL() {
		return C_URL;
	}



	public List<CompanyList> getCompanylist() {
		return companylist;
	}

	public void setCompanylist(List<CompanyList> companylist) {
		this.companylist = companylist;
	}

	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}

	public void setC_NAME(String c_NAME) {
		C_NAME = c_NAME;
	}

	public void setC_NUM(String c_NUM) {
		C_NUM = c_NUM;
	}

	public void setC_URL(String c_URL) {
		C_URL = c_URL;
	}



}

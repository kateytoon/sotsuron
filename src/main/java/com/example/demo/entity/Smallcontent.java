package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="SMALLCONTENT")
public class Smallcontent {
	@Id
	@Column(name="CONTENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	@Size(max = 8)
    private int CONTENT_ID;

	@Column(name="CONTENT_DETAIL")
	@Size(max = 50)
    private String CONTENT_DETAIL;


	@OneToMany(mappedBy="smallcontent", cascade=CascadeType.ALL)
    private List<Application> application;



	public String getCONTENT_DETAIL() {
		return CONTENT_DETAIL;
	}

	public int getCONTENT_ID() {
		return CONTENT_ID;
	}



	public void setCONTENT_DETAIL(String cONTENT_DETAIL) {
		CONTENT_DETAIL = cONTENT_DETAIL;
	}



	public void setCONTENT_ID(int cONTENT_ID) {
		CONTENT_ID = cONTENT_ID;
	}






}

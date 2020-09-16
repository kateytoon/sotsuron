package com.example.demo.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
@Entity
@Table(name="APICOMMENT")
public class Apicomment {
	@Id
	@Column(name="CO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	private int CO_ID;


	@ManyToOne
	@JoinColumn(name="API_ID")
	private Application application;


	@Column(name = "API_COMMENT")
	@Size(max = 255)
	private String API_COMMENT;

	@CreatedDate
	@Column(name="CO_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date CO_TIME;



	public Apicomment(Application api, String hyouka) {
		// TODO 自動生成されたコンストラクター・スタブ
		setApplication(api);
		setAPI_COMMENT(hyouka);
		CO_TIME = new Date();
	}

	public int getCO_ID() {
		return CO_ID;
	}

	public void setCO_ID(int cO_ID) {
		CO_ID = cO_ID;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getAPI_COMMENT() {
		return API_COMMENT;
	}

	public void setAPI_COMMENT(String aPI_COMMENT) {
		API_COMMENT = aPI_COMMENT;
	}

	public Date getCO_TIME() {
		return CO_TIME;
	}

	public void setCO_TIME(Date cO_TIME) {
		CO_TIME = cO_TIME;
	}






}

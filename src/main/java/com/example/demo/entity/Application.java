package com.example.demo.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="APPLICATION")
public class Application implements Serializable, Cloneable {
	@Id
	@Column(name="API_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	private int API_ID;

	@CreatedDate
	@Column(name="API_DATE")
	//@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime API_DATE;

	@CreatedDate
	@Column(name="API_DATE_END")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime API_DATE_END;

	@Column(name="API_LOCATE")
	@Size(max = 50)
	private String API_LOCATE;

	@Column(name="API_ATTEND")
	private int API_ATTEND;


	@CreatedDate
	@Column(name="ATTEND_INFO")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime ATTEND_INFO;


	public void setATTEND_INFO(LocalDateTime aTTEND_INFO) {
		ATTEND_INFO = aTTEND_INFO;
	}


	@Column(name="APPROVED")
	private int APPROVED;


	@Column(name="DENIED")
	private int DENIED;


	@Column(name="UNAPPROVED")
	private int UNAPPROVED;

	@Column(name="REP_FLG")
	private int REP_FLG;

	public int getREP_FLG() {
		return REP_FLG;
	}

	public void setREP_FLG(int rEP_FLG) {
		REP_FLG = rEP_FLG;
	}


	@OneToMany(mappedBy="application", cascade=CascadeType.ALL)
    private List<CompanyList> companyList;

	@ManyToOne
	@JoinColumn(name = "CONTENT_ID" )
	private Smallcontent smallcontent;


	@ManyToOne
	@JoinColumn(name="S_ID")
	private Student student;

	@OneToOne(mappedBy="application")
    private Uebubun uebubun;

	@OneToOne(mappedBy="application")
    private Report report;

	@OneToMany(mappedBy="application", cascade=CascadeType.ALL)
    private List<Apicomment> apicomment;

	public int getAPI_ATTEND() {
		return API_ATTEND;
	}

	public LocalDateTime getAPI_DATE() {
		return API_DATE;
	}



	public LocalDateTime getAPI_DATE_END() {
		return API_DATE_END;
	}

	public int getAPI_ID() {
		return API_ID;
	}





	public String getAPI_LOCATE() {
		return API_LOCATE;
	}


	public List<Apicomment> getApicomment() {
		return apicomment;
	}





	public int getAPPROVED() {
		return APPROVED;
	}



	public List<CompanyList> getCompanyList() {
		return companyList;
	}


	public int getDENIED() {
		return DENIED;
	}


	public Report getReport() {
		return report;
	}


	public Smallcontent getSmallcontent() {
		return smallcontent;
	}


	public Student getStudent() {
		return student;
	}


	public Uebubun getUebubun() {
		return uebubun;
	}


	public int getUNAPPROVED() {
		return UNAPPROVED;
	}


	public void setAPI_ATTEND(int aPI_ATTEND) {
		API_ATTEND = aPI_ATTEND;
	}


	public void setAPI_DATE(LocalDateTime aPI_DATE) {
		API_DATE = aPI_DATE;
	}


	public void setAPI_DATE_END(LocalDateTime aPI_DATE_END) {
		API_DATE_END = aPI_DATE_END;
	}


	public void setAPI_ID(int aPI_ID) {
		API_ID = aPI_ID;
	}



	public void setAPI_LOCATE(String aPI_LOCATE) {
		API_LOCATE = aPI_LOCATE;
	}


	public void setApicomment(List<Apicomment> apicomment) {
		this.apicomment = apicomment;
	}


	public void setAPPROVED(int aPPROVED) {
		APPROVED = aPPROVED;
	}





	public LocalDateTime getATTEND_INFO() {
		return ATTEND_INFO;
	}

	public void setCompanyList(List<CompanyList> companyList) {
		this.companyList = companyList;
	}


	public void setDENIED(int dENIED) {
		DENIED = dENIED;
	}


	public void setReport(Report report) {
		this.report = report;
	}


	public void setSmallcontent(Smallcontent smallcontent) {
		this.smallcontent = smallcontent;
	}


	public void setStudent(Student student) {
		this.student = student;
	}




	public void setUebubun(Uebubun uebubun) {
		this.uebubun = uebubun;
	}


	public void setUNAPPROVED(int uNAPPROVED) {
		UNAPPROVED = uNAPPROVED;
	}


}
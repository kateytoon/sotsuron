package com.example.demo.entity;


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;




@Entity
@Table(name="APPLICATION")
public class Application {
	@Id
	@Column(name="API_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	private int API_ID;

	@CreatedDate
	@Column(name="API_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date API_DATE;

	@CreatedDate
	@Column(name="API_DATE_END")
	@Temporal(TemporalType.TIMESTAMP)
	private Date API_DATE_END;

	@Column(name="API_LOCATE")
	@Size(max = 50)
	private String API_LOCATE;


	@Column(name="API_INFO")
	@Size(max = 50)
	private String API_INFO;


	@Column(name="API_ATTEND")
	private int API_ATTEND;

	@CreatedDate
	@Column(name="ATTEND_INFO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ATTEND_INFO;

	@Column(name="APPROVED")
	private int APPROVED;


	@Column(name="DENIED")
	private int DENIED;

	@Column(name="UNAPPROVED")
	private int UNAPPROVED;

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


	public List<Apicomment> getApicomment() {
		return apicomment;
	}


	public void setApicomment(List<Apicomment> apicomment) {
		this.apicomment = apicomment;
	}


	public int getAPI_ATTEND() {
		return API_ATTEND;
	}


	public Date getAPI_DATE() {
		return API_DATE;
	}


	public Date getAPI_DATE_END() {
		return API_DATE_END;
	}


	public int getAPI_ID() {
		return API_ID;
	}


	public String getAPI_INFO() {
		return API_INFO;
	}

	public String getAPI_LOCATE() {
		return API_LOCATE;
	}


	public int getAPPROVED() {
		return APPROVED;
	}


	public Date getATTEND_INFO() {
		return ATTEND_INFO;
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


	public void setAPI_DATE(Date aPI_DATE) {
		API_DATE = aPI_DATE;
	}


	public void setAPI_DATE_END(Date aPI_DATE_END) {
		API_DATE_END = aPI_DATE_END;
	}


	public void setAPI_ID(int aPI_ID) {
		API_ID = aPI_ID;
	}


	public void setAPI_INFO(String aPI_INFO) {
		API_INFO = aPI_INFO;
	}


	public void setAPI_LOCATE(String aPI_LOCATE) {
		API_LOCATE = aPI_LOCATE;
	}


	public void setAPPROVED(int aPPROVED) {
		APPROVED = aPPROVED;
	}


	public void setATTEND_INFO(Date aTTEND_INFO) {
		ATTEND_INFO = aTTEND_INFO;
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
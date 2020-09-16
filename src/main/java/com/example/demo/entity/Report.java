package com.example.demo.entity;

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
@Table(name="REPORT")
public class Report {
	@Id
    @Column(name="RE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int RE_ID;

	@Column(name="RE_IMP")
	@Size(max = 255)
    private String RE_IMP;

	@OneToOne
	@JoinColumn(name="API_ID")
    private Application application;

	@Column(name="SUBMITTED")

    private int SUBMITTED;

	@Column(name="UNAPPROVED")

    private int UNAPPROVED;

	@Column(name="UNSUBMIT")

    private int UNSUBMIT;

	@Column(name="RESUBMIT")

    private int RESUBMIT;

	@ManyToOne
	@JoinColumn(name="CONTENT_ID")
	private Smallcontent smallcontent;

	@OneToMany(mappedBy="report", cascade=CascadeType.ALL)
    private List<Repcomment> repcomment;

	public Application getApplication() {
		return application;
	}

	public int getRE_ID() {
		return RE_ID;
	}
	public String getRE_IMP() {
		return RE_IMP;
	}

	public int getRESUBMIT() {
		return RESUBMIT;
	}



	public Smallcontent getSmallcontent() {
		return smallcontent;
	}

	public int getSUBMITTED() {
		return SUBMITTED;
	}

	public int getUNAPPROVED() {
		return UNAPPROVED;
	}

	public int getUNSUBMIT() {
		return UNSUBMIT;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public void setRE_ID(int rE_ID) {
		RE_ID = rE_ID;
	}

	public void setRE_IMP(String rE_IMP) {
		RE_IMP = rE_IMP;
	}

	public void setRESUBMIT(int rESUBMIT) {
		RESUBMIT = rESUBMIT;
	}



	public void setSmallcontent(Smallcontent smallcontent) {
		this.smallcontent = smallcontent;
	}

	public void setSUBMITTED(int sUBMITTED) {
		SUBMITTED = sUBMITTED;
	}



	public void setUNAPPROVED(int uNAPPROVED) {
		UNAPPROVED = uNAPPROVED;
	}

	public void setUNSUBMIT(int uNSUBMIT) {
		UNSUBMIT = uNSUBMIT;
	}



}

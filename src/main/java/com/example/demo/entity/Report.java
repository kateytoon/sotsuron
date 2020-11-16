package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="REPORT")
public class Report {






	public Report(String rE_IMP, Application application, int sUBMITTED, int uNAPPROVED, int uNSUBMIT,
			int rESUBMIT, Smallcontent smallcontent) {

		RE_IMP = rE_IMP;
		this.application = application;
		SUBMITTED = sUBMITTED;
		UNAPPROVED = uNAPPROVED;
		UNSUBMIT = uNSUBMIT;
		RESUBMIT = rESUBMIT;
	}
	public Report() {

	}

	public List<Repcomment> getRepcomment() {
		return repcomment;
	}

	public void setRepcomment(List<Repcomment> repcomment) {
		this.repcomment = repcomment;
	}

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

package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="UEBUBUN")
public class Uebubun {
	@Id
    @Column(name="UE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int UE_ID;

	@Column(name="UE_KUBUN")
	@Size(max = 1)
    private int UE_KUBUN;

	@Column(name="UE_LEVEL")
	@Size(max = 1)
    private int UE_LEVEL;

	@OneToOne
    @JoinColumn(name = "API_ID" )
    private Application application;




	@ManyToOne
	@JoinColumn(name = "CONTENT_ID" )
	private BIGcontent bigcontent;

	public BIGcontent getContent() {
		return bigcontent;
	}







	public void setContent(BIGcontent content) {
		this.bigcontent = content;
	}







	public Application getApplication() {
		return application;
	}







	public int getUE_ID() {
		return UE_ID;
	}

	public int getUE_KUBUN() {
		return UE_KUBUN;
	}

	public int getUE_LEVEL() {
		return UE_LEVEL;
	}

	public void setApplication(Application application) {
		this.application = application;
	}





	public void setUE_ID(int uE_ID) {
		UE_ID = uE_ID;
	}

	public void setUE_KUBUN(int uE_KUBUN) {
		UE_KUBUN = uE_KUBUN;
	}

	public void setUE_LEVEL(int uE_LEVEL) {
		UE_LEVEL = uE_LEVEL;
	}

}

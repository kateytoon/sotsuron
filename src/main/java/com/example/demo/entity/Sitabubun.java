package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="SITABUBUN")
public class Sitabubun {
	@Id
    @Column(name="SI_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
    @SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
    private int SI_ID;

	@OneToOne
	@JoinColumn(name="UE_ID")
	@Size(max = 8)
    private Uebubun uebubun;

	@Column(name="SI_RESULT")
	@Size(max = 1)
    private int SI_RESULT;

	public int getSI_ID() {
		return SI_ID;
	}

	public void setSI_ID(int sI_ID) {
		SI_ID = sI_ID;
	}

	public Uebubun getUebubun() {
		return uebubun;
	}

	public void setUebubun(Uebubun uebubun) {
		this.uebubun = uebubun;
	}

	public int getSI_RESULT() {
		return SI_RESULT;
	}

	public void setSI_RESULT(int sI_RESULT) {
		SI_RESULT = sI_RESULT;
	}


}

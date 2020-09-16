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
@Table(name="DEPARTMENT")
public class Department {
	@Id
	@Column(name="D_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	@Size(max = 2)
    private int D_ID;

	@Column(name="D_NAME")
	@Size(max = 50)
    private String D_NAME;

	@Column(name="D_VALUE")
	@Size(max = 50)
    private String D_VALUE;

	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Student> student;

	public int getD_ID() {
		return D_ID;
	}

	public String getD_NAME() {
		return D_NAME;
	}

	public String getD_VALUE() {
		return D_VALUE;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setD_ID(int d_ID) {
		D_ID = d_ID;
	}

	public void setD_NAME(String d_NAME) {
		D_NAME = d_NAME;
	}

	public void setD_VALUE(String d_VALUE) {
		D_VALUE = d_VALUE;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
}

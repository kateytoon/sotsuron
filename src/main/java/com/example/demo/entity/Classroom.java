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
@Table(name="CLASSROOM")
public class Classroom {
	@Id
	@Column(name="R_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "i_seq")
	@SequenceGenerator(name = "i_seq" , sequenceName = "i_seq", allocationSize=1)
	@Size(max = 8)
    private int R_ID;

	@Column(name="R_NAME")
	@Size(max = 50)
    private String R_NAME;

	@OneToMany(mappedBy="classroom", cascade=CascadeType.ALL)
	private List<Student> student;

	public int getR_ID() {
		return R_ID;
	}

	public String getR_NAME() {
		return R_NAME;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}

	public void setR_NAME(String r_NAME) {
		R_NAME = r_NAME;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}




}

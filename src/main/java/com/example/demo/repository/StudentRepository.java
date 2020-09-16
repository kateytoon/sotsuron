package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Application;
import com.example.demo.entity.Student;

	@Repository
	public interface StudentRepository extends JpaRepository<Student, String>{


		@Query("from Application")
		  public List<Application> serchAll();


		@Query("from Application where S_NAME = :S_NAME")
		  public List<Application> serchName(@Param("S_NAME") String name);

		
	}


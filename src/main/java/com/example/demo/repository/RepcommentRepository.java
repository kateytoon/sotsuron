package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Repcomment;

@Repository
public interface RepcommentRepository extends JpaRepository<Repcomment, String>{


	@Query("from Apicomment where RE_ID = :id")
	  public Repcomment findByRE_ID(@Param("id") int id);


}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Apicomment;

@Repository
public interface ApicommentRepository extends JpaRepository<Apicomment, String>{


	@Query("from Apicomment where API_ID = :id")
	  public Apicomment findByAPI_ID(@Param("id") int id);


}

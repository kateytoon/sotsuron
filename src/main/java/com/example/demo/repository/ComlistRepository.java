package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CompanyList;

@Repository
public interface ComlistRepository extends JpaRepository<CompanyList, Integer>{


	@Query("from CompanyList where API_ID = :id")
	  public List<CompanyList> findByAPI_ID(@Param("id") int id);


}

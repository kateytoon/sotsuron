package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;

@Repository
public interface ComRepository extends JpaRepository<Company, Integer>{

	@Query(value="select i_seq.nextval from dual", nativeQuery= true)
    int selectNextVal();


}

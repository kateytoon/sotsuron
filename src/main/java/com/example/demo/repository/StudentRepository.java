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

		//Student側

		@Query("FROM Application a INNER JOIN a.student s WHERE s.account.username = :U_ID")
		public List<Application> findByMyName(@Param("U_ID") String name);

		@Query("from Application")
		  public List<Application> serchAll();


		@Query("from Application where student.S_NAME = :S_NAME")
		  public List<Application> serchName(@Param("S_NAME") String name);

		@Query("FROM Application a INNER JOIN a.student WHERE a.student.S_NAME = :S_NAME ORDER BY a.API_ID")
		public List<Application> findByNAME(@Param("S_NAME") String name);

		@Query("from Student where U_ID = :U_ID")
		  public Student serchSName(@Param("U_ID") String name);

		@Query("FROM Application a INNER JOIN a.student s WHERE s.account.username = :U_ID AND REP_FLG = 0")
		  public List<Application> serchRepFlg(@Param("U_ID") String name);

		@Query("FROM Application a INNER JOIN a.student s WHERE s.account.username = :U_ID AND REP_FLG = 1")
		  public List<Application> findByMyRep(@Param("U_ID") String name);

		/*自分の名前のレポートを探すやーつ
		@Query("FROM Report r INNER JOIN r.application a INNER JOIN a.student s WHERE s.account.username = :U_ID")
		  public List<Report> findByMyRep(@Param("U_ID") String name);
		*/
		@Query(value="select i_seq.nextval from dual", nativeQuery= true)
	    int selectNextVal();
	}


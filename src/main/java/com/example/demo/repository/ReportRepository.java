package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Report;
@Repository
public interface ReportRepository extends JpaRepository<Report, String>{
	@Query("from Report where Submitted = 1")
	  public List<Report> findBySubmittedReport();

	@Query("from Report where Unapproved = 1")
	  public List<Report> findByUnapprovedReport();
	@Query("from Report where Unsubmit = 1")
	  public List<Report> findByUnsubmitReport();
	@Query("from Report where Unapproved = 1")
	  public List<Report> findByResubmitReport();

	@Query("from Report where RE_ID = :id AND Unsubmit = 1")
	  public List<Report> findByReIdAndUnSubmit(@Param("id") int id);

	@Query("from Report where RE_ID = :id")
	  public Report findByReId(@Param("id") int id);

	@Query("from Report where RE_ID = :id")
	  public Report findByApiId(@Param("id") int id);


}

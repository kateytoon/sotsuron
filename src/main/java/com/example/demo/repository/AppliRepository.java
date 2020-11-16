package com.example.demo.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Application;
@Repository
public interface AppliRepository extends JpaRepository<Application, String>{

	@Query("from Application where Approved = 1 AND :date >= TRUNC(API_DATE) AND :date <= TRUNC(API_DATE_END)")
	  public List<Application> findByTodayApplication(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date);

	@Query("from Application where DENIED = 1")
	  public List<Application> findByDeniedApplication();

	@Query("from Application where Approved = 1")
	  public List<Application> findByApprovedApplication();
	@Query("from Application where Unapproved = 1")
	  public List<Application> findByUnapprovedApplication();

	@Query("from Application where :date >= TRUNC(API_DATE) AND :date <= TRUNC(API_DATE_END)")
	public List<Application> findDateApplication(
	  @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date);

	@Query("from Application where API_ID = :id")
	  public Application findByAPI_ID(@Param("id") int id);




	//検索用
	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByStrict(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
    List<Application> findByOutName(@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutCompany(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutDepart(@Param("S_NAME") String name ,@Param("S_YEAR") int year,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR  AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutRoom(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutYear(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("R_NAME") String room,@Param("C_NAME") String campany);



	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR ORDER BY a.API_ID")
    List<Application> findByOutRoomCompany(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("S_YEAR") int year);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutYearCompany(@Param("S_NAME") String name ,@Param("D_VALUE") String department,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutYearRoom(@Param("S_NAME") String name ,@Param("D_VALUE") String department ,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d WHERE s.S_NAME = :S_NAME AND d.D_VALUE = :D_VALUE ORDER BY a.API_ID")
	List<Application> findByOutYearRoomCompany(@Param("S_NAME") String name ,@Param("D_VALUE") String department);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r WHERE s.S_NAME = :S_NAME AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutDepartCompany(@Param("S_NAME") String name ,@Param("S_YEAR") int year,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND s.S_YEAR = :S_YEAR AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutDepartRoom(@Param("S_NAME") String name ,@Param("S_YEAR") int year,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s WHERE s.S_NAME = :S_NAME AND s.S_YEAR = :S_YEAR ORDER BY a.API_ID")
   	List<Application> findByOutDepartRoomCompany(@Param("S_NAME") String name ,@Param("S_YEAR") int year);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutDepartYear(@Param("S_NAME") String name ,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r WHERE s.S_NAME = :S_NAME AND r.R_NAME = :R_NAME  ORDER BY a.API_ID")
   	List<Application> findByOutDepartYearCompany(@Param("S_NAME") String name ,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_NAME = :S_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutDepartYearRoom(@Param("S_NAME") String name ,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s WHERE s.S_NAME = :S_NAME ORDER BY a.API_ID")
   	List<Application> findByOutDepartYearRoomCompany(@Param("S_NAME") String name);




	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r WHERE d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutNameCompany(@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR  AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutNameRoom(@Param("D_VALUE") String department ,@Param("S_YEAR") int year,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d WHERE d.D_VALUE = :D_VALUE AND s.S_YEAR = :S_YEAR ORDER BY a.API_ID")
    List<Application> findByOutNameRoomCompany(@Param("D_VALUE") String department ,@Param("S_YEAR") int year);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE d.D_VALUE = :D_VALUE AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutNameYear(@Param("D_VALUE") String department ,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d INNER JOIN s.classroom r WHERE d.D_VALUE = :D_VALUE AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutNameYearCompany(@Param("D_VALUE") String department,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE d.D_VALUE = :D_VALUE AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
	List<Application> findByOutNameYearRoom(@Param("D_VALUE") String department ,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.department d WHERE d.D_VALUE = :D_VALUE ORDER BY a.API_ID")
	List<Application> findByOutNameYearRoomCompany(@Param("D_VALUE") String department);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutNameDepart(@Param("S_YEAR") int year,@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r WHERE s.S_YEAR = :S_YEAR AND r.R_NAME = :R_NAME ORDER BY a.API_ID")
    List<Application> findByOutNameDepartCompany(@Param("S_YEAR") int year,@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE s.S_YEAR = :S_YEAR AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutNameDepartRoom(@Param("S_YEAR") int year,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s WHERE s.S_YEAR = :S_YEAR ORDER BY a.API_ID")
   	List<Application> findByOutNameDepartRoomCompany(@Param("S_YEAR") int year);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE r.R_NAME = :R_NAME AND c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutNameDepartYear(@Param("R_NAME") String room,@Param("C_NAME") String campany);

	@Query("FROM Application a INNER JOIN a.student s INNER JOIN s.classroom r WHERE r.R_NAME = :R_NAME  ORDER BY a.API_ID")
   	List<Application> findByOutNameDepartYearCompany(@Param("R_NAME") String room);

	@Query("FROM Application a INNER JOIN a.student s LEFT JOIN a.companyList cl INNER JOIN cl.company c WHERE c.C_NAME = :C_NAME ORDER BY a.API_ID")
   	List<Application> findByOutNameDepartYearRoom(@Param("C_NAME") String campany);







}

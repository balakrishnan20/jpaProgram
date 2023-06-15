package com.jpaexample.springdatajpaexample.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpaexample.springdatajpaexample.entity.Student;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Long>{
	
	public List<Student> findByFirstName(String firstName);
	
	//JPQL
	@Query("select s from student s where s.emailId=?1")
	Student getStuentByEmailAddress(String emailId);
	
	@Query("select s.firstName from student s where s.emailId=?1")
	String getFirstNameByEmailAddress(String emailId);

	//NativesqlQuery
	@Query(value = "select s from tbl_student s where s.emailId=?1",
			nativeQuery = true)
	Student getStuentByEmailAddressNative(String emailId);
	
	//NativesqlQuery
		@Query(value = "select s from tbl_student s where s.emailId=:emailId",
				nativeQuery = true)
		Student getStuentByEmailAddressNativeNameParam(@Param("emailId") String emailId);
		
		//if we want update or delete we use @modifiying 
		@Modifying
		@Transactional
		@Query(value = "update tble_Student set first_name=?1 where email_address=?2", nativeQuery = true)
		int udpateStudentNameByEmailId(String FIrstName, String emailId);
}

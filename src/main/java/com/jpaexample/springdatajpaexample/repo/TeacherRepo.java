package com.jpaexample.springdatajpaexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.springdatajpaexample.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{

}

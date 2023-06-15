package com.jpaexample.springdatajpaexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.springdatajpaexample.entity.Course;

@Repository
public interface CourserRepo extends JpaRepository<Course, Long>{

}

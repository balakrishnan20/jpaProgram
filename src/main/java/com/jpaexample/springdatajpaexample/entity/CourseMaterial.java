package com.jpaexample.springdatajpaexample.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
	@Id
	@SequenceGenerator(name ="course_material_seq",
			sequenceName = "course_material_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_seq")
	private Long courseMaterialId;
	private String url;
	
	// uni directional check in sites
	//lazy will be given if no need of course eager will fetch the course details
	//optional is false so course cannot be saved with out giving value for course material default it will be false
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false)
	@JoinColumn(
			name="course_id",
			referencedColumnName = "courseId"
			)
	private Course course;
	

}

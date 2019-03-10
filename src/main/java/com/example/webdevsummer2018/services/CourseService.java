package com.example.webdevsummer2018.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer2018.models.Course;
import com.example.webdevsummer2018.repositories.CourseRepository;

@RestController
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses(){
		return courseRepository.findAll();
	}
	
}

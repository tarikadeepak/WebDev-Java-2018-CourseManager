package com.example.webdevsummer2018.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer2018.models.Course;
import com.example.webdevsummer2018.models.Module;
import com.example.webdevsummer2018.repositories.CourseRepository;
import com.example.webdevsummer2018.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class ModuleService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	
	@GetMapping("api/course/{courseId}/module")
	public Iterable<Module> findAllCourses(@PathVariable("courseId") int courseId){
		System.out.println("Hello : " + courseId);
		return moduleRepository.findByCourse_Id(courseId);
	}
	@PostMapping("api/course/{courseId}/module")
	public Module createModule(
			@PathVariable("courseId") int courseId,
			@RequestBody Module newModule) {
		Optional<Course> data = courseRepository.findById(courseId);
		System.out.println("Inside Create");
		if(data.isPresent()) {
			Course course = data.get();
			newModule.setCourse(course);
			return moduleRepository.save(newModule);
		}
		return null;
	}
	@DeleteMapping("api/course/{courseId}/module/{moduleId}")
	public void deleteModule(		
			@PathVariable("moduleId") int moduleId, @PathVariable("courseId") int courseId) {
		System.out.println("Inside DeleteModule : " + courseId + " " + moduleId);	
		 moduleRepository.deleteById(moduleId);
			
	}
}

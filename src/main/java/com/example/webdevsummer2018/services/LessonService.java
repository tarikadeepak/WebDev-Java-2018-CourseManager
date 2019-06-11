package com.example.webdevsummer2018.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer2018.models.Course;
import com.example.webdevsummer2018.models.Lesson;
import com.example.webdevsummer2018.models.Module;
import com.example.webdevsummer2018.repositories.LessonRepository;
import com.example.webdevsummer2018.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class LessonService {
	
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("api/course/{courseId}/module/{moduleId}/lesson")
	public Iterable<Lesson> findAllLessons(@PathVariable("moduleId") int moduleId){
		System.out.println("Hello : " + moduleId);
		return lessonRepository.findByModule_Id(moduleId);
	}
/*	@PostMapping("api/course/{courseId}/module/{moduleId}/lesson")
	public Module createLesson(
			@PathVariable("moduleId") int moduleId,
			@RequestBody Lesson newLesson) {
		Optional<Module> data = ModuleRepository.findById(moduleId);
		if(data.isPresent()) {
			Course course = data.get();
			newModule.setCourse(course);
			return moduleRepository.save(newModule);
		}
		return null;
	}*/
}

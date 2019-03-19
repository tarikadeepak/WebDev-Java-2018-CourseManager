package com.example.webdevsummer2018.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevsummer2018.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson,Integer>{
	List<Lesson> findByModule_Id(int moduleId);
}

package com.example.webdevsummer2018.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevsummer2018.models.Module;

public interface ModuleRepository extends CrudRepository<Module,Integer>{
	List<Module> findByCourse_Id(int courseId);
}

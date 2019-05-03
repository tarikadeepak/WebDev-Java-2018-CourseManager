package com.example.webdevsummer2018.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer2018.models.Widget;
import com.example.webdevsummer2018.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets(){
		return (List<Widget>)widgetRepository.findAll();
	}
	
	@GetMapping("/api/widget/{moduleId}")
	public Optional<Widget> findWidgetsById(		
			@PathVariable("moduleId") int moduleId){
		return widgetRepository.findById(moduleId);
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody 
								List<Widget> widgets) {
		widgetRepository.deleteAll();
		for(Widget widget: widgets) {
			widgetRepository.save(widget);
		}
	}
	
}

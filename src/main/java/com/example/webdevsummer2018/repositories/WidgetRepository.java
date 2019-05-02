package com.example.webdevsummer2018.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevsummer2018.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

}

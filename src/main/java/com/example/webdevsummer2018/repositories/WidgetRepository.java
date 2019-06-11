package com.example.webdevsummer2018.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.webdevsummer2018.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
	@Query("SELECT u FROM Widget u WHERE u.moduleId=:moduleId")
	public Iterable<Widget> findWidgetByModuleId(
			@Param("moduleId") Integer moduleId);
}

package com.example.webdevsummer2018.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.webdevsummer2018.models.UserDetail;

public interface UserDetailRepository extends CrudRepository<UserDetail, String> {
	
	@Query("SELECT u FROM UserDetail u WHERE u.email=:email AND u.password=:password")
	public Iterable<UserDetail> findUserByCredentials(
			@Param("email") String username, 
			@Param("password") String password);

}

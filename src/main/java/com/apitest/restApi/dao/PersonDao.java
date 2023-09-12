package com.apitest.restApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apitest.restApi.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{

	
	List<Person> findByName(String name);

}

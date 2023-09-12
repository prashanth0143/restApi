package com.apitest.restApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apitest.restApi.dao.PersonDao;
import com.apitest.restApi.model.Person;

@Service
public class PersonService {
	
	//For Repo
	@Autowired
	PersonDao dao;
	
	
	//Save the server in repo
	public ResponseEntity<String> addServer(Person person) {
		
		Person p = dao.findById(person.getId()).orElse(null);
		if(p == null) {
			dao.save(person);
			return new ResponseEntity<String>("successful", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Same ID Already present", HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	
	//fetching the ListOf server from repo
	public ResponseEntity<List<Person>> getServer() {
		try {
			return new ResponseEntity<List<Person>>(dao.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Person>>(new ArrayList<Person>(), HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	//Fetching single server By id from repo
	public ResponseEntity<Person> getSingleServer(Integer id) {
		
		Person person = dao.findById(id).orElse(null);
		
		
		if(person ==  null) {
			return new ResponseEntity<Person>(new Person(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Person>(person,HttpStatus.OK);
		
	}



	//Deleting the server By id  from repo 
	public ResponseEntity<Person> deleteByID(Integer id) {
		
		Person person = dao.findById(id).orElse(null);

		if(person ==  null) {
			return new ResponseEntity<Person>(new Person(), HttpStatus.NOT_FOUND);
		}
		else {
			dao.deleteById(id);
			return new ResponseEntity<Person>(person, HttpStatus.OK);
		}
		
	}


	//Fetching ListOf server By name from repo
	public ResponseEntity<List<Person>> fingByName(String name) {
		Boolean person = dao.findByName(name).isEmpty();
		
		if(person) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<>(dao.findByName(name), HttpStatus.OK);
		
	}

}

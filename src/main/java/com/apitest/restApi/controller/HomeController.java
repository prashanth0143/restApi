package com.apitest.restApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apitest.restApi.model.Person;
import com.apitest.restApi.service.PersonService;

@RestController
@RequestMapping("api")
public class HomeController {
	
	//Service Referrence
	@Autowired
	PersonService service;
	
	
	//For getting all the list of server
	@GetMapping("servers")
	public ResponseEntity<List<Person>> servers() {
		return  service.getServer();
		
	}
	
	
	//For Adding the single server
	@PostMapping("addserver")
	public ResponseEntity<String> addServer(@RequestBody Person person) {
		
		return service.addServer(person);
		
	}
	
	//Get the server by id
	@GetMapping("getserver/{id}")
	public ResponseEntity<Person> getServer(@PathVariable Integer id) {
		
		return service.getSingleServer(id);
		
	}
	
	
	//For deleting the server by id
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Person> deleteServer(@PathVariable Integer id){
		
		return service.deleteByID(id);
		
	}
	
	
	//get the server By name
	@GetMapping("server/{name}")
	public ResponseEntity<List<Person>> findByName(@PathVariable String name){
		
		return service.fingByName(name);
	}

}

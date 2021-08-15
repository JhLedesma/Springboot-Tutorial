package com.example.demo.controller;

import com.example.demo.controller.dto.PersonInput;
import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping(path = "/people")
	public ResponseEntity<Person> createPerson(@RequestBody PersonInput personInput) {
		Person person = personService.createPerson(personInput);
		return ResponseEntity.ok(person);
	}
}

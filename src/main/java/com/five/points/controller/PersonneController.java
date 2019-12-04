package com.five.points.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.points.dao.PersonneRepository;
import com.five.points.entities.Personne;

@RestController
@RequestMapping("/api/v1")
public class PersonneController {

	@Autowired
	PersonneRepository personneRepository;

	@GetMapping("/personnes")
	public List<Personne> personnes() {
		return personneRepository.findAll();
	}

	@GetMapping("/personne/{id}")
	public ResponseEntity<Personne> getPersonById(@PathVariable(value = "id") Long idRechrcher) {
		Personne personne;
		try {
			personne = personneRepository.findById(idRechrcher).get();
			return ResponseEntity.ok().body(personne);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().body(null);
	}

	@PostMapping("/persone")
	public Personne savePersone(@RequestBody Personne personne) {
		return personneRepository.save(personne);
	}

	@PutMapping("/persone")
	public Personne updatePersone(@Valid @RequestBody Personne personneMAJ) {
		return personneRepository.save(personneMAJ);
	}

	@DeleteMapping("/personne/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long idPerson) {
		Personne personne = personneRepository.findById(idPerson).get();
		personneRepository.delete(personne);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

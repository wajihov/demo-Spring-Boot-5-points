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

import com.five.points.dao.EmployeRepository;
import com.five.points.entities.Employe;

@RestController
@RequestMapping("/FivePoints")
public class EmployeController {

	@Autowired
	private EmployeRepository employeRepository;

	@GetMapping("/employes")
	public List<Employe> getAllEmployes() {
		return employeRepository.findAll();
	}

	@PostMapping("/employe")
	public Employe updateEmploye(@RequestBody Employe employe) {
		return employeRepository.save(employe);
	}

	@GetMapping("/employe/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable(value = "id") Long idEmp) {
		Employe employe = employeRepository.findById(idEmp).get();
		return ResponseEntity.ok().body(employe);
	}

	@PutMapping("/employe/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") Long idEMpl,
			@Valid @RequestBody Employe emp) {
		Employe employe = new Employe();
		try {
			employe = employeRepository.findById(idEMpl).get();
			employe.setName(emp.getName());
			employe.setEmail(emp.getEmail());
			employe.setPassword(emp.getPassword());
			employeRepository.save(employe);

		} catch (Exception e) {
		}
		return ResponseEntity.ok().body(employe);
	}

	@DeleteMapping("/employe/{id}")
	public Map<String, Boolean> deleteEmploye(@PathVariable(value = "id") Long idEmploye) {
		Employe employe = employeRepository.findById(idEmploye).get();
		employeRepository.delete(employe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

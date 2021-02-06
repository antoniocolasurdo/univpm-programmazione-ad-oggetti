package it.univpm.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.service.Service;

@RestController
public class Controller {
	
	@Autowired
	private Service service;

	@GetMapping("/")
	public String getData() {
		return service.getData();
	}

	@PostMapping("/readData")
	public void readData() {
		service.readData();
	}
}
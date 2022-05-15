package com.generation.lojademusica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojademusica.model.Musica;
import com.generation.lojademusica.repository.MusicaRepository;

@RestController
@RequestMapping("/musicas")
@CrossOrigin(origins="*")
public class MusicaController {

	@Autowired
	private MusicaRepository repository;
	@GetMapping 
	ResponseEntity<List<Musica>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")	
	ResponseEntity<Musica> getById (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}

	@PostMapping
	public ResponseEntity<Musica> post (@RequestBody Musica musica){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(musica));
		
	}
	@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}

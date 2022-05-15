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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.generation.lojademusica.model.Usuario;
import com.generation.lojademusica.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	@GetMapping 
	ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
		@GetMapping("/usuario/{usuario}")
		public ResponseEntity<List<Usuario>> getByUsuario (@PathVariable String usuario) {
			return ResponseEntity.ok(repository.findAllByUsuarioContainingIgnoreCase(usuario));
		}
		@PostMapping
		public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
			
		}
		
		@DeleteMapping("/{id}")
			public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
		


	}



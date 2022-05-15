package com.generation.lojademusica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.lojademusica.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

	public List<Musica> findAllByNomeMusicaContainingIgnoreCase(String nomeMusica);
	public List<Musica> findAllByNomeCantorContainingIgnoreCase(String nomeCantor);
	public List<Musica> findAllByEstiloContainingIgnoreCase(String estilo);
}

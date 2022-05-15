package com.generation.lojademusica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_musica")
public class Musica {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nomeMusica;
	@NotNull
	private String nomeCantor;
	@NotNull
	private String estilo;
	@NotNull
	private String duracao;
	
	private String fotoVideo;
	@NotNull
	private int nota;
	@OneToMany(mappedBy = "musica" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("musica")
	private List<Postagem> postagem;
	
	//
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeMusica() {
		return nomeMusica;
	}
	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	public String getNomeCantor() {
		return nomeCantor;
	}
	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getFotoVideo() {
		return fotoVideo;
	}
	public void setFotoVideo(String fotoVideo) {
		this.fotoVideo = fotoVideo;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	
	
	
}

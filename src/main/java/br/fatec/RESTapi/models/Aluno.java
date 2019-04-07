package br.fatec.RESTapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.fatec.RESTapi.view.View;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.AlunoResumoAlternativo.class)
	private long id;
	
	@JsonView(View.AlunoResumo.class)	
	private String nome;
	
	@JsonView(View.AlunoCompleto.class)
	private int periodo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
}

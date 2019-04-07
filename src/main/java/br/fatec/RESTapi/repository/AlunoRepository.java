package br.fatec.RESTapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.RESTapi.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

		Aluno findById(long id);
		
		Aluno findByNome(String nome);
		
		List<Aluno> findByPeriodo(int periodo);
}

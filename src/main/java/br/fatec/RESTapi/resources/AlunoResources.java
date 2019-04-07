package br.fatec.RESTapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.fatec.RESTapi.models.Aluno;
import br.fatec.RESTapi.repository.AlunoRepository;
import br.fatec.RESTapi.view.View;


@RestController
@RequestMapping(value="/api")
public class AlunoResources {

	@Autowired
	AlunoRepository alunoRepository;
	
	@CrossOrigin
	@JsonView(View.AlunoCompleto.class)
	@GetMapping("/alunos")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@JsonView(View.AlunoResumoAlternativo.class)
	@RequestMapping("/alunos/{id}")
	public ResponseEntity listaAlunoUnico(@PathVariable(value="id") long id){
		Aluno a = alunoRepository.findById(id);
		if(a == null) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Error Message");
			}
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(a);
	}
	@JsonView(View.AlunoResumo.class)
	@RequestMapping("/alunos/nome/{nome}")
	public ResponseEntity listaAlunoUnico(@PathVariable(value="nome") String nome){
		Aluno a = alunoRepository.findByNome(nome);
		if(a == null) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Error Message");
			}
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(a);
	}
	@JsonView(View.AlunoCompleto.class)
	@RequestMapping("/alunos/per/{periodo}")
	public ResponseEntity listaAlunoPeriodo(@PathVariable(value="periodo") int periodo){
		List<Aluno> alunos = alunoRepository.findByPeriodo(periodo);
		if(alunos.isEmpty()) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Error Não encontrado");
			}
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(alunos);
	}
	
	@CrossOrigin
	@PostMapping("/alunos")
	@JsonView(View.AlunoCompleto.class)
	public ResponseEntity salvaALuno(@RequestBody Aluno aluno) {
		try {
		alunoRepository.save(aluno);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(aluno);
		}catch (Exception e) {
			return ResponseEntity
		            .status(HttpStatus.METHOD_NOT_ALLOWED)
		            .body("Error Message");
			}
	}
}

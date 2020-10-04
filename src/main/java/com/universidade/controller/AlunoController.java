package com.universidade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidade.dto.AlunoDTO;
import com.universidade.entidade.Aluno;
import com.universidade.response.Response;
import com.universidade.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> allAlunos(){
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Response<AlunoDTO>> create(@Valid @RequestBody AlunoDTO dto, BindingResult result){
		
		Response<AlunoDTO> response = new Response<AlunoDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		Aluno aluno = service.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(aluno));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	private Aluno convertDtoToEntity(AlunoDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setCodAluno(dto.getCodAluno());
		aluno.setNomeAluno(dto.getNomeAluno());
		aluno.setCpf(dto.getCpf());
		aluno.setCelular(dto.getCelular());
		aluno.setCurso(dto.getCurso());
		aluno.setStatus(dto.getStatus());
		aluno.setDataMatricula(dto.getDataMatricula());
		
		return aluno;
	}
	
	private AlunoDTO convertEntityToDto(Aluno aluno) {
		AlunoDTO dto = new AlunoDTO();
		dto.setCodAluno(aluno.getCodAluno());
		dto.setNomeAluno(aluno.getNomeAluno());
		dto.setCpf(aluno.getCpf());
		dto.setCelular(aluno.getCelular());
		dto.setCurso(aluno.getCurso());
		dto.setStatus(aluno.getStatus());
		dto.setDataMatricula(aluno.getDataMatricula());
		
		return dto;
		
	}

}

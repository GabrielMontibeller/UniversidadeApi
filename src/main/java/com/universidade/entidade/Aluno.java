package com.universidade.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

//@Entity
@Data
public class Aluno {
	
	@Id
	private Long codAluno;
	
	@NotNull
	private String nomeAluno;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String celular;
	
	@NotNull
	private String status;

	
	private List<Curso> listCurso;
	
	@NotNull
	private String dataMatricula;

}

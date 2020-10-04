package com.universidade.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
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
	
//	@JoinColumn(name = "curso", referencedColumnName = "id")
//	@ManyToOne(fetch = FetchType.LAZY)
	private int curso;
	
	@NotNull
	private String dataMatricula;

}

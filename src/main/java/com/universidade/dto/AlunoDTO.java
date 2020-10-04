package com.universidade.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AlunoDTO {
	
    private Long codAluno;
	
	@NotNull
	private String nomeAluno;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String celular;
	
	@NotNull
	private String status;
	
    @NotNull
	private int curso;
	
	@NotNull
	private String dataMatricula;


}

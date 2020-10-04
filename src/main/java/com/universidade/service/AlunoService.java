package com.universidade.service;

import java.util.List;

import com.universidade.entidade.Aluno;

public interface AlunoService {
	
	List<Aluno> findAll();
	
	Aluno save(Aluno aluno);

}

package com.universidade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidade.entidade.Aluno;
import com.universidade.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService{
	
	@Autowired
	AlunoRepository repository;

	@Override
	public List<Aluno> findAll() {
		List<Aluno> aluno = new ArrayList<Aluno>();
		repository.findAll().forEach(alunos -> aluno.add(alunos));
		return aluno;
	}

	@Override
	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}

}

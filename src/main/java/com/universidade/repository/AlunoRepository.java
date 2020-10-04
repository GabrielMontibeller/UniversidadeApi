package com.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidade.entidade.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

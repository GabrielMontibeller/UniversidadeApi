package com.universidade.service;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.universidade.entidade.Aluno;
import com.universidade.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlunoServiceTest {
	
	@MockBean
	AlunoRepository repository;
	
	@Autowired
	AlunoService service;
	
	private static final Long CODALUNO = 1L;
	private static final String NOMEALUNO = "Aluno";
	private static final String CPF = "123.465.789.10";
	private static final String CELULAR = "11 99999999";
	private static final String STATUS = "ok";
	private static final int CURSO = 2;
	private static final String DATAMATRICULA = "05/10/2020";
	
	
	@Test
	public void testSave() {
		BDDMockito.given(repository.save(Mockito.any(Aluno.class))).willReturn(getMockAluno());
		
		Aluno response = service.save(new Aluno());
		
		assertNotNull(response);
	}
	
	
	
	private Aluno getMockAluno() {
		Aluno aluno = new Aluno();
		aluno.setCodAluno(CODALUNO);
        aluno.setNomeAluno(NOMEALUNO);
        aluno.setCpf(CPF);
        aluno.setCelular(CELULAR);
        aluno.setStatus(STATUS);
        aluno.setCurso(CURSO);
        aluno.setDataMatricula(DATAMATRICULA);
        
        return aluno;
}
	

}


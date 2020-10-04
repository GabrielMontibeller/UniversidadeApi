package com.universidade.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.universidade.entidade.Aluno;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlunoRepositoyTest {
	
	@Autowired
	AlunoRepository repository;
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	
	@Test
	public void testSave() {
		Aluno aluno = new Aluno();
		aluno.setNomeAluno("Gabriel");
		aluno.setCodAluno(1L);
		aluno.setCelular("11 99999999");
		aluno.setCpf("123.456.789-10");
		aluno.setCurso(2);
		aluno.setDataMatricula("05/10/2020");
		aluno.setStatus("OK");
		
		Aluno response = repository.save(aluno);
		
		assertNotNull(response);
	}

}

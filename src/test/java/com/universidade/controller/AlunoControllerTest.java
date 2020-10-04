package com.universidade.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.universidade.dto.AlunoDTO;
import com.universidade.entidade.Aluno;
import com.universidade.service.AlunoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AlunoControllerTest {
	
	private static final Long CODALUNO = 1L;
	private static final String NOMEALUNO = "Aluno";
	private static final String CPF = "123.465.789.10";
	private static final String CELULAR = "11 99999999";
	private static final String STATUS = "ok";
	private static final int CURSO = 2;
	private static final String DATAMATRICULA = "05/10/2020";
	private static final String URL = "/alunos";
	
	@MockBean
	AlunoService service;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testSave() throws Exception{
		
		BDDMockito.given(service.save(Mockito.any(Aluno.class))).willReturn(getMockAluno());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(CODALUNO, NOMEALUNO, CPF,
				CELULAR, CURSO, STATUS, DATAMATRICULA ))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.data.codAluno").value(CODALUNO))
		.andExpect(jsonPath("$.data.nomeAluno").value(NOMEALUNO))
		.andExpect(jsonPath("$.data.cpf").value(CPF))
		.andExpect(jsonPath("$.data.celular").value(CELULAR))
		.andExpect(jsonPath("$.data.status").value(STATUS))
		.andExpect(jsonPath("$.data.curso").value(CURSO))
		.andExpect(jsonPath("$.data.dataMatricula").value(DATAMATRICULA));
		
	}
	
	public Aluno getMockAluno() {
		Aluno aluno = new Aluno();
		aluno.setCodAluno(CODALUNO);
		aluno.setNomeAluno(NOMEALUNO);
		aluno.setCpf(CPF);
		aluno.setCelular(CELULAR);
		aluno.setCurso(CURSO);
		aluno.setStatus(STATUS);
		aluno.setDataMatricula(DATAMATRICULA);
		
		return aluno;
	}
	
	public String getJsonPayload(Long codAluno, String nomeAluno, String cpf, String celular, int curso,
			String status, String dataMatricula) throws JsonProcessingException{
		
		AlunoDTO dto = new AlunoDTO();
		dto.setCodAluno(codAluno);
		dto.setNomeAluno(nomeAluno);
		dto.setCpf(cpf);
		dto.setCelular(celular);
		dto.setCurso(curso);
		dto.setStatus(status);
		dto.setDataMatricula(dataMatricula);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
	}

}

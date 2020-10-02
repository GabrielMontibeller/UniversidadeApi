package com.universidade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.universidade.entidade.Curso;

@Service
public class CursoService {
	
	@Autowired
	RestTemplate template = new RestTemplate();
	
	public Curso[] getCursos() {
		return template.getForObject("https://gatewayext.cruzeirodosul.edu.br/entrevista/teste/cursos", Curso[].class);
	}

}

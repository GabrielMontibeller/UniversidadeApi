package com.universidade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidade.entidade.Curso;
import com.universidade.service.CursoService;



@RestController
@RequestMapping("/retorna-cursos")
public class CursosController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public Curso[] getCursos() {
		return service.getCursos();
	}

}

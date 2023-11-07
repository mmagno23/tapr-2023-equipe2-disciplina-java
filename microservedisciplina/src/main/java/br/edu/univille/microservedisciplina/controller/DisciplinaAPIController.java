package br.edu.univille.microservedisciplina.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservedisciplina.entity.Disciplina;
import br.edu.univille.microservedisciplina.service.DisciplinaService;



@RestController
@RequestMapping ("/api/v1/disciplina")
public class DisciplinaAPIController {
    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listadisciplina(){
        //var listadisciplina=new ArrayList<Disciplina>();
        var listaDisciplina =service.getAll();

        return
        new ResponseEntity<List<Disciplina>>(listaDisciplina, HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<Disciplina> incluirDisciplina(@RequestBody Disciplina disciplina){
        disciplina = service.save(disciplina);
        return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
    }



}

package br.edu.univille.microservedisciplina.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservedisciplina.entity.Disciplina;


@RestController
@RequestMapping ("/api/v1/disciplina")
public class DisciplinaAPIController {
    @GetMapping
    public ResponseEntity<List<Disciplina>> listadisciplina(){
        var listadisciplina=new ArrayList<Disciplina>();

        return
        new ResponseEntity<List<Disciplina>>(listadisciplina, HttpStatus.OK);


    }
}

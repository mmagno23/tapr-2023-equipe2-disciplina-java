package br.edu.univille.microservedisciplina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.univille.microservedisciplina.entity.Disciplina;
import br.edu.univille.microservedisciplina.service.DisciplinaService;


import io.dapr.Topic;
import io.dapr.curso.domain.CloudEvent;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoAPIController {
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<curso>> listaCurso(){
        var listaCurso = service.getAll();
        return 
            new ResponseEntity<List<curso>>
            (listaCurso, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable("id")  String id){
        var curso = service.getById(id);
        if(curso == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Curso>
            (curso, HttpStatus.OK);
    } 
    @PostMapping
    public ResponseEntity<Curso> inserirCurso(@RequestBody Curso curso){
        if(curso == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        curso = service.saveNew(curso);
        return 
            new ResponseEntity<Curso>
            (curso, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable("id")  String id, @RequestBodyCurso curso){
        if(curso == null || id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        curso = service.update(id, curso);
        if(curso == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Curso>
            (curso, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> removerCurso(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var curso = service.delete(id);
        if(curso == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Curso>
            (curso, HttpStatus.OK);
    }
    @Topic(name = "${app.component.topic.curso}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Curso> atualizarCliente(@RequestBody(required = false) CloudEvent<Curso> cloudEvent){
        var curso = service.update(cloudEvent.getData());
        System.out.println("EVENT" + curso.getNome());
        return 
            new ResponseEntity<Curso>
            (curso, HttpStatus.OK);
    }
    
}
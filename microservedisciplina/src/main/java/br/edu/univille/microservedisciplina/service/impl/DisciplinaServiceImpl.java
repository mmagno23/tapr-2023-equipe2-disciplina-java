package br.edu.univille.microservedisciplina.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservedisciplina.entity.Disciplina;
import br.edu.univille.microservedisciplina.repository.DisciplinaRepository;
import br.edu.univille.microservedisciplina.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
    @Autowired
    private DisciplinaRepository repository;

    @Override
    public List<Disciplina> getAll() {
        var iterador =repository.findAll();
        List<Disciplina> listaDisciplinas =new ArrayList<>();
        iterador.forEach(listaDisciplinas::add);
        return listaDisciplinas;
        
    }
    
}

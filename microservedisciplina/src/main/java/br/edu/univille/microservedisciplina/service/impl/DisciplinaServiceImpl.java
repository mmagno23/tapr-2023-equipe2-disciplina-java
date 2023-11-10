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
    @Override
    public Disciplina getById(String id) {
        var disciplina = repository.findById(id);
        if(disciplina.isPresent())
            return disciplina.get();
        return null;
    }

    @Override
    public Disciplina save(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    @Override
    public Disciplina update(String id, Disciplina disciplina) {
        var buscaDisciplinaAntiga = repository.findById(id);
        if (buscaDisciplinaAntiga.isPresent()){
            var disciplinaAntiga = buscaDisciplinaAntiga.get();

            //Atualizar cada atributo do objeto antigo 
            disciplinaAntiga.setNomeDisciplina(disciplina.getNomeDisciplina());
            disciplinaAntiga.setCargaHoraria(disciplina.getCargaHoraria());            
            disciplinaAntiga.setSemestre(disciplina.getSemestre());                        
            return repository.save(disciplinaAntiga);
        }
        return null;
    }
    
    @Override
    public Disciplina delete(String id) {
        var buscaDisciplina = repository.findById(id);
        if (buscaDisciplina.isPresent()){
            var disciplina = buscaDisciplina.get();

            repository.delete(disciplina);

            return disciplina;
        }
        return null;
    }
    
}


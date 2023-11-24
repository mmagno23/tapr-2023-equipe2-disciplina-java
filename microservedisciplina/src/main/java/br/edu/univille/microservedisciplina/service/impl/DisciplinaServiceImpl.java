package br.edu.univille.microservedisciplina.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.univille.microservedisciplina.entity.Disciplina;
import br.edu.univille.microservedisciplina.repository.DisciplinaRepository;
import br.edu.univille.microservedisciplina.service.DisciplinaService;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
    @Autowired
    private DisciplinaRepository repository;
    private DaprClient client = new DaprClientBuilder().build();
    @Value("${app.component.topic.disciplina}")
    private String TOPIC_NAME;
    @Value("${app.component.service}")
	private String PUBSUB_NAME;

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
        disciplina.setIdDisciplina(null);
        disciplina = repository.save(disciplina);
        publicarAtualizacao(disciplina);
        return disciplina;
    }
    
    @Override
    public Disciplina update(String id, Disciplina disciplina) {
        var buscaDisciplinaAntiga = repository.findById(id);
        if (buscaDisciplinaAntiga.isPresent()){
            var disciplinaAntiga = buscaDisciplinaAntiga.get();

            disciplinaAntiga.setNomeDisciplina(disciplina.getNomeDisciplina());
            disciplinaAntiga.setCargaHoraria(disciplina.getCargaHoraria());            
            disciplinaAntiga.setSemestre(disciplina.getSemestre());   
            publicarAtualizacao(disciplinaAntiga);
            return disciplinaAntiga;
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
    private void publicarAtualizacao(Disciplina disciplina){
        client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					disciplina).block();
    }

    
}


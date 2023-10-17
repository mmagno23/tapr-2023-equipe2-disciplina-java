package br.edu.univille.microservedisciplina.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservedisciplina.entity.Disciplina;



@Repository
public interface DisciplinaRepository 
    extends CrudRepository<Disciplina,String>{

    }
    


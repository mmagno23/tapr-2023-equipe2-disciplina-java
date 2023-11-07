package br.edu.univille.microservedisciplina.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container (containerName="disciplina")
public class Disciplina {
    @Id
    @GeneratedValue
    private  String idDisciplina ;
    @PartitionKey
    private String nomeDisciplina ;
    private int cargaHoraria ;
    private int semestre ;

    public String getIdDisciplina() {
        return idDisciplina;
    }
    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}
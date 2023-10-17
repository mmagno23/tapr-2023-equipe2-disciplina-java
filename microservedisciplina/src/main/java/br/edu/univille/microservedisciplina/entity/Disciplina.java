package br.edu.univille.microservedisciplina.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container (containerName="disciplina")
public class Disciplina {
    @Id
    @GeneratedValue
    public  String idDisciplina ;
    @PartitionKey
    public int numeroDisciplina ;
    public int cargaHoraria ;
    public int semestre ;

    public Disciplina(String idDisciplina, int cargaHoraria, int semestre) {
        this.idDisciplina = idDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
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

    @Override
    public String toString() {
        return "Disciplina{" +
                "idDisciplina='" + idDisciplina + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", semestre=" + semestre +
                '}';
    }
}
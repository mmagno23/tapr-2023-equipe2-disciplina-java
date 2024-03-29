package br.edu.univille.microservedisciplina.service;
import java.util.List;
import br.edu.univille.microservedisciplina.entity.Disciplina;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

public interface DisciplinaService {
    public List<Disciplina> getAll();
    public Disciplina save(Disciplina disciplina);
    public Disciplina getById(String id);
    public Disciplina update(String id, Disciplina disciplina);
    public Disciplina delete(String id);
}

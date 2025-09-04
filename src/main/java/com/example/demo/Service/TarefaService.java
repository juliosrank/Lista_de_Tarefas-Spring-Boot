package com.example.demo.Service;

import com.example.demo.Model.Tarefa;
import com.example.demo.Repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repo;

    public List<Tarefa> listarTodas(){
        return repo.listaDeTarefas;
    }

    public void adicionar(Tarefa novaTarefa){
        repo.listaDeTarefas.add(novaTarefa);
    }

    public void remover (Tarefa tarefaRemovida){
        repo.listaDeTarefas.removeIf(t -> t.id().equals(tarefaRemovida.id()));
    }

    public Tarefa buscarPorID(Integer id){
        return repo.listaDeTarefas.stream()
                .filter(t -> t.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Tarefa concluirTarefa(Integer id) {
        Tarefa tarefaAtual = buscarPorID(id);
        if (tarefaAtual != null) {
            Tarefa tarefaAtualizada = new Tarefa(tarefaAtual.id(), tarefaAtual.nome(), true);
            remover(tarefaAtual);
            adicionar(tarefaAtualizada);
        }
        return null;
    }
}
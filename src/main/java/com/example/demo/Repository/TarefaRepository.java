package com.example.demo.Repository;

import com.example.demo.Model.Tarefa;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TarefaRepository {

    public final List<Tarefa> listaDeTarefas = new ArrayList<>(
            List.of(
                    new Tarefa(1, "Estudar Java", false),
                    new Tarefa(2, "Fazer exercícios", true)
            )
    );
}
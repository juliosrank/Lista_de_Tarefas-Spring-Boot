package com.example.demo.Controller;

import com.example.demo.Model.Tarefa;
import com.example.demo.Service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TarefaController {

    private final TarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa buscar(@PathVariable Integer id) {
        return service.buscarPorID(id);
    }

    @PostMapping
    public void adicionar(@RequestBody Tarefa t) {
        service.adicionar(t);
    }

    @PutMapping("/{id}/concluir")
    public Tarefa concluir(@PathVariable Integer id) {
        return service.concluirTarefa(id);
    }

    @DeleteMapping("/{id}/remover")
    public void remover(@PathVariable Integer id) {
        Tarefa t = service.buscarPorID(id);
        service.remover(t);
    }
}
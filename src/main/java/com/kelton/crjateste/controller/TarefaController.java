package com.kelton.crjateste.controller;

import com.kelton.crjateste.model.Pessoa;
import com.kelton.crjateste.model.Tarefa;
import com.kelton.crjateste.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("get/tarefas/pendentes")
    public ResponseEntity<List<Tarefa>> listarTarefasPendentes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.tarefaService.listarTarefasPendentes());
    }

    @PutMapping("put/tarefas/alocar/{id}")
    public ResponseEntity<Tarefa> alocarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(this.tarefaService.alocarPessoa(id, pessoa));
    }

    @PostMapping("post/tarefas")
    public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tarefaService.cadastrarTarefa(tarefa));
    }

    @PutMapping("put/tarefas/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.tarefaService.finalizarTarefa(id));
    }
}

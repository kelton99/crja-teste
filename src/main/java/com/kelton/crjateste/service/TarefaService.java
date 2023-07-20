package com.kelton.crjateste.service;

import com.kelton.crjateste.model.Pessoa;
import com.kelton.crjateste.model.Tarefa;
import com.kelton.crjateste.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public Tarefa cadastrarTarefa(Tarefa tarefa) {
        return this.tarefaRepository.save(tarefa);
    }

    public Tarefa finalizarTarefa(Long id) {
        final var tarefa = this.tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setFinalizado(true);
        return this.tarefaRepository.save(tarefa);
    }

    public Tarefa alocarPessoa(Long id, Pessoa pessoa) {
        final var tarefa = this.tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if(tarefa.getDepartamento().equals(pessoa.getDepartamento())) {
            tarefa.setPessoa(pessoa);
            return this.tarefaRepository.save(tarefa);
        }

        throw new RuntimeException("Tarefa não pertence ao mesmo departamento que a pessoa");
    }

    public List<Tarefa> listarTarefasPendentes() {
        return this.tarefaRepository.listarTarefasPendentes();
    }
}

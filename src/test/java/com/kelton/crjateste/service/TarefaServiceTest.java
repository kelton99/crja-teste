package com.kelton.crjateste.service;

import com.kelton.crjateste.model.Tarefa;
import com.kelton.crjateste.repository.TarefaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDateTime;


@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        tarefaService = new TarefaService(tarefaRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void cadastrarTarefa() {
        final var now = LocalDateTime.now();
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Teste");
        tarefa.setDescricao("Tarefa para testes");
        tarefa.setPrazo(now);
        tarefa.setDuracao(15);
        tarefa.setFinalizado(false);

        final var tarefaSalva = this.tarefaRepository.save(tarefa);


    }

    @Test
    void finalizarTarefa() {
    }

    @Test
    void alocarPessoa() {
    }

    @Test
    void listarTarefasPendentes() {
    }
}
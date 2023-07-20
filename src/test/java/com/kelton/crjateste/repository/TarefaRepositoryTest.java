package com.kelton.crjateste.repository;

import com.kelton.crjateste.model.Tarefa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository tarefaRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deveListarTarefasPendentes() {
        final var now = Instant.now();
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Teste");
        tarefa1.setDescricao("Tarefa para testes");
        tarefa1.setPrazo(now);
        tarefa1.setDuracao(15);
        tarefa1.setFinalizado(false);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setTitulo("Teste2");
        tarefa2.setDescricao("Tarefa2 para testes");
        tarefa2.setPrazo(Instant.MIN);
        tarefa2.setDuracao(15);
        tarefa2.setFinalizado(false);

        Tarefa tarefa3 = new Tarefa();
        tarefa3.setTitulo("Teste3");
        tarefa3.setDescricao("Tarefa3 para testes");
        tarefa3.setPrazo(Instant.MIN);
        tarefa3.setDuracao(15);
        tarefa3.setFinalizado(false);


        Tarefa tarefa4 = new Tarefa();
        tarefa4.setTitulo("Teste4");
        tarefa4.setDescricao("Tarefa4 para testes");
        tarefa4.setPrazo(Instant.MIN);
        tarefa4.setDuracao(15);
        tarefa4.setFinalizado(false);

        this.tarefaRepository.save(tarefa1);
        this.tarefaRepository.save(tarefa2);
        this.tarefaRepository.save(tarefa3);
        this.tarefaRepository.save(tarefa4);

        final var tarefas = this.tarefaRepository.listarTarefasPendentes();

        assertThat(tarefas).isNotEmpty();
        assertThat(tarefas.size()).isEqualTo(3);

        boolean saoMenores = true;

        for (Tarefa tarefa: tarefas) {
            if (!tarefa.getPrazo().isBefore(now)) {
                saoMenores = false;
                break;
            }
        }

        assertThat(saoMenores).isEqualTo(true);
    }
}
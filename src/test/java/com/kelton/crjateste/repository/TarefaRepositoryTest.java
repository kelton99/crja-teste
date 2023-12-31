package com.kelton.crjateste.repository;

import com.kelton.crjateste.model.Tarefa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.time.LocalDateTime;

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

        final var tarefas = this.tarefaRepository.listarTarefasPendentes();

        assertThat(tarefas).isNotEmpty();
        assertThat(tarefas.size()).isEqualTo(3);

        boolean naoPossuiPessoa = true;

        for(Tarefa tarefa : tarefas) {
            if(tarefa.getPessoa() != null) {
                naoPossuiPessoa = false;
                break;
            }
        }

        assertThat(naoPossuiPessoa).isEqualTo(true);

    }
}
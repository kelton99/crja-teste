package com.kelton.crjateste.service;

import com.kelton.crjateste.model.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TarefaServiceTest {

    @Autowired
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void deveListarTarefasPendentes() {

        final var tarefas = this.tarefaService.listarTarefasPendentes();

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

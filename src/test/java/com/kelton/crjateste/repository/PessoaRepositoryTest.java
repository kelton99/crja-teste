package com.kelton.crjateste.repository;

import com.kelton.crjateste.dto.BuscarPessoaDTO;
import com.kelton.crjateste.model.Departamento;
import com.kelton.crjateste.model.Pessoa;
import com.kelton.crjateste.model.Tarefa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() { }

    @Test
    void deveListarPessoas() {

        final var pessoas = this.pessoaRepository.listarPessoas();

        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(6);
    }

    @Test
    void deveListarPessoasGastos() {

        final var buscaInput = new BuscarPessoaDTO("Camila", LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 12, 30, 0, 0, 0));

        final var pessoas = this.pessoaRepository.listarPessoasGastos(buscaInput);
        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(1);
        assertThat(pessoas.get(0).getMediaHorasTarefas()).isEqualTo(10);

    }
}
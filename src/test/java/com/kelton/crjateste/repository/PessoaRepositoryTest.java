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

import java.time.Instant;
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
    void tearDown() {
    }

    @Test
    void listarPessoas() {
        var departamento = new Departamento();
        departamento.setTitulo("Desenvolvimento");
        departamento = departamentoRepository.save(departamento);

        var pessoa1 = new Pessoa();

        pessoa1.setNome("João");
        pessoa1.setDepartamento(departamento);

        var pessoa2 = new Pessoa();

        pessoa1.setNome("Maria");
        pessoa1.setDepartamento(departamento);

        this.pessoaRepository.save(pessoa1);
        this.pessoaRepository.save(pessoa2);

        final var pessoas = this.pessoaRepository.listarPessoas();

        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(2);
    }

    @Test
    void listarPessoasGastos() {

        var departamento = new Departamento();
        departamento.setTitulo("Desenvolvimento");
        departamento = departamentoRepository.save(departamento);

        var pessoa1 = new Pessoa();

        pessoa1.setNome("João");
        pessoa1.setDepartamento(departamento);

        var pessoa2 = new Pessoa();

        pessoa1.setNome("Maria");
        pessoa1.setDepartamento(departamento);

        pessoa1 = this.pessoaRepository.save(pessoa1);
        pessoa2 = this.pessoaRepository.save(pessoa2);

        var tarefa1 = new Tarefa();
        tarefa1.setTitulo("Nova Feature");
        tarefa1.setDescricao("Desenvolver nova feature para teste");
        tarefa1.setDuracao(15);
        tarefa1.setFinalizado(false);
        tarefa1.setPrazo(LocalDateTime.of(2023, 7, 21, 0, 0, 0));
        tarefa1.setPessoa(pessoa1);
        tarefa1.setDepartamento(departamento);


        var tarefa2 = new Tarefa();
        tarefa2.setTitulo("Bug Fix");
        tarefa2.setDescricao("Bug Fix na API de agendamentos");
        tarefa2.setDuracao(10);
        tarefa2.setFinalizado(false);
        tarefa2.setPrazo(LocalDateTime.of(2023, 7, 23, 0, 0, 0));
        tarefa2.setPessoa(pessoa2);
        tarefa2.setDepartamento(departamento);


        var tarefa3 = new Tarefa();
        tarefa3.setTitulo("Refatorar");
        tarefa3.setDescricao("Refatorar serviço de cadastro de pessoas e tarefas");
        tarefa3.setDuracao(5);
        tarefa3.setFinalizado(false);
        tarefa2.setPrazo(LocalDateTime.of(2023, 7, 26, 0, 0, 0));
        tarefa3.setPessoa(pessoa1);
        tarefa3.setDepartamento(departamento);

        tarefaRepository.save(tarefa1);
        tarefaRepository.save(tarefa2);
        tarefaRepository.save(tarefa3);

        final var tarefas = this.tarefaRepository.findAll();
        System.out.println(tarefas);
        assertThat(tarefas).isNotEmpty();

        final var buscaInput = new BuscarPessoaDTO("João", LocalDateTime.of(2023, 7, 20, 0, 0, 0), LocalDateTime.of(2023, 7, 27, 0, 0, 0));
        final var pessoas = this.pessoaRepository.listarPessoasGastos(buscaInput);

        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(1);
        assertThat(pessoas.get(0).getTotalHorasTarefas()).isEqualTo(10);

    }
}
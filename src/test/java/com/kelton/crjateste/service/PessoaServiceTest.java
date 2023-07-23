package com.kelton.crjateste.service;


import com.kelton.crjateste.dto.BuscarPessoaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;


    @Test
    void deveListarPessoas() {

        final var pessoas = this.pessoaService.listarPessoas();

        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(6);
    }

    @Test
    void deveListarGastosPessoa() {

        final var buscaInput = new BuscarPessoaDTO("Camila", LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 12, 30, 0, 0, 0));

        final var pessoas = this.pessoaService.listarGastosPessoa(buscaInput);
        assertThat(pessoas).isNotEmpty();
        assertThat(pessoas.size()).isEqualTo(1);
        assertThat(pessoas.get(0).getMediaHorasTarefas()).isEqualTo(10);

    }


}

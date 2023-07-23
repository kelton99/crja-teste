package com.kelton.crjateste.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DepartamentoServiceTest {

    @Autowired
    private DepartamentoService departamentoService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void deveListarDepartamentos() {

        final var departamentos = this.departamentoService.listarDepartamentos();

        assertThat(departamentos).isNotEmpty();
        assertThat(departamentos.size()).isEqualTo(3);
    }

}

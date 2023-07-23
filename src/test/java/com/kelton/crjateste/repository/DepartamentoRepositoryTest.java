package com.kelton.crjateste.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class DepartamentoRepositoryTest {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    public void deveListarDepartamentos() {
        final var departamentos = this.departamentoRepository.listarDepartamentos();

        assertThat(departamentos).isNotEmpty();
        assertThat(departamentos.size()).isEqualTo(3);
    }

}

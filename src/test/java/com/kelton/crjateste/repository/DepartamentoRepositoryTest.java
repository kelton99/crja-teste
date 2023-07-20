package com.kelton.crjateste.repository;

import com.kelton.crjateste.model.Departamento;
import com.kelton.crjateste.service.DepartamentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DepartamentoRepositoryTest {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    public void deveListarDepartamentos() {
        Departamento departamento = new Departamento(1L, "Juridico");

        this.departamentoRepository.save(departamento);
        final var departamentos = this.departamentoRepository.listarDepartamentos();

        assertThat(departamentos).isNotEmpty();
    }

}

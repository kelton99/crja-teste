package com.kelton.crjateste.service;

import com.kelton.crjateste.repository.DepartamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartamentoServiceTest {

    @Mock
    private DepartamentoRepository departamentoRepository;
    private DepartamentoService departamentoService;

    @BeforeEach
    void setUp() {
        departamentoService = new DepartamentoService(departamentoRepository);
    }

    @Test
    public void deveListarDepartamentos() {
        this.departamentoService.listarDepartamentos();
    }

}

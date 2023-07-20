package com.kelton.crjateste.service;

import com.kelton.crjateste.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private DepartamentoRepository departamentoRepository;
    private DepartamentoService departamentoService;

    @BeforeEach
    void setUp() {
        departamentoService = new DepartamentoService(departamentoRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void cadastrarTarefa() {
    }

    @Test
    void finalizarTarefa() {
    }

    @Test
    void alocarPessoa() {
    }

    @Test
    void listarTarefasPendentes() {
    }
}
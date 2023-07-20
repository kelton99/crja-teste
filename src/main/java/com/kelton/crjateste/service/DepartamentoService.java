package com.kelton.crjateste.service;

import com.kelton.crjateste.dto.DepartamentoDTO;
import com.kelton.crjateste.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<DepartamentoDTO> listarDepartamentos() {
        return this.departamentoRepository.listarDepartamentos();
    }
}

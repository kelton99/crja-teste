package com.kelton.crjateste.controller;

import com.kelton.crjateste.dto.DepartamentoDTO;
import com.kelton.crjateste.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("get/departamentos")
    public ResponseEntity<List<DepartamentoDTO>> listarDepartamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.departamentoService.listarDepartamentos());
    }
}

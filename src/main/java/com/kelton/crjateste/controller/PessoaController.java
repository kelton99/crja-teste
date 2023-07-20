package com.kelton.crjateste.controller;


import com.kelton.crjateste.dto.BuscarPessoaDTO;
import com.kelton.crjateste.dto.PessoaDTO;
import com.kelton.crjateste.model.Pessoa;
import com.kelton.crjateste.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("get/pessoas")
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.listarPessoas());
    }

    @GetMapping("get/pessoas/gastos")
    public ResponseEntity<List<PessoaDTO>> listarGastosPessoas(@RequestBody BuscarPessoaDTO buscarPessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.listarGastosPessoa(buscarPessoaDTO));
    }

    @PostMapping("post/pessoas")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.cadastrarPessoa(pessoa));
    }

    @PutMapping("put/pessoas/{id}")
    public ResponseEntity<Pessoa> alterarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.alterarPessoa(id, pessoa));
    }

    @DeleteMapping("delete/pessoas/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        this.pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }


}

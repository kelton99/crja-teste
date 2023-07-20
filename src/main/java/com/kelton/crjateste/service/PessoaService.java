package com.kelton.crjateste.service;


import com.kelton.crjateste.dto.BuscarPessoaDTO;
import com.kelton.crjateste.dto.PessoaDTO;
import com.kelton.crjateste.model.Pessoa;
import com.kelton.crjateste.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public List<PessoaDTO> listarPessoas() {
        return this.pessoaRepository.listarPessoas();
    }

    public List<PessoaDTO> listarGastosPessoa(BuscarPessoaDTO buscarPessoaDTO) {
        return this.pessoaRepository.listarPessoasGastos(buscarPessoaDTO);
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa alterarPessoa(Long id, Pessoa novaPessoa) {
        final var pessoa = this.pessoaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoa.getNome());
        pessoa.setDepartamento(pessoa.getDepartamento());
        return this.pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        this.pessoaRepository.findById(id)
                .ifPresentOrElse(this.pessoaRepository::delete,
                        () -> {
                            throw new RuntimeException("Pessoa não encontrada");
                        });

    }


}

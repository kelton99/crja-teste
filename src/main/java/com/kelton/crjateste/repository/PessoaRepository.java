package com.kelton.crjateste.repository;

import com.kelton.crjateste.dto.BuscarPessoaDTO;
import com.kelton.crjateste.dto.PessoaDTO;
import com.kelton.crjateste.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query(value = """
            SELECT p.id as id, d.nome as departamento, SUM(t.duracao) as totalHorasTarefas
            FROM pessoas p
            LEFT JOIN departamentos d
            ON p.id_departamento = d.id
            LEFT JOIN tarefas t
            ON t.id_pessoa = p.id
            GROUP BY p.id, d.nome
            ORDER BY p.id
            """, nativeQuery = true)
    List<PessoaDTO> listarPessoas();

    @Query(value = """
            SELECT p.id as id, d.nome as departamento, AVG(t.duracao) as totalHorasTarefas
            FROM pessoas p
            LEFT JOIN departamentos d
            ON p.id_departamento = d.id
            LEFT JOIN tarefas t
            ON t.id_pessoa = p.id
            WHERE d.nome LIKE '%teste%'
            AND t.prazo BETWEEN '2007-02-07' AND '2007-02-15'
            GROUP BY p.id, d.nome
            ORDER BY p.id
            """, nativeQuery = true)
    List<PessoaDTO> listarPessoasGastos(BuscarPessoaDTO buscarPessoaDTO);
}

package com.kelton.crjateste.repository;

import com.kelton.crjateste.dto.BuscarPessoaDTO;
import com.kelton.crjateste.dto.PessoaDTO;
import com.kelton.crjateste.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Query(value = """
            SELECT p.id as id, d.titulo as departamento, SUM(t.duracao) as totalHorasTarefas
            FROM pessoas p
            LEFT JOIN departamentos d
            ON p.id_departamento = d.id
            LEFT JOIN tarefas t
            ON t.id_pessoa = p.id
            GROUP BY p.id, d.titulo
            ORDER BY p.id
            """, nativeQuery = true)
    List<PessoaDTO> listarPessoas();

    @Query(value = """
            SELECT p.id as id, d.titulo as departamento, AVG(t.duracao) as totalHorasTarefas
            FROM pessoas p
            LEFT JOIN departamentos d
            ON p.id_departamento = d.id
            LEFT JOIN tarefas t
            ON t.id_pessoa = p.id
            WHERE p.nome LIKE %:#{#buscarPessoaDTO.nome}%
            AND t.prazo BETWEEN :#{#buscarPessoaDTO.dataInicial} AND :#{#buscarPessoaDTO.dataFinal}
            GROUP BY p.id, d.titulo
            ORDER BY p.id
            """, nativeQuery = true)
    List<PessoaDTO> listarPessoasGastos(@Param("buscarPessoaDTO") BuscarPessoaDTO buscarPessoaDTO);
}

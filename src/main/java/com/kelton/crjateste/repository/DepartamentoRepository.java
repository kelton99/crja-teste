package com.kelton.crjateste.repository;

import com.kelton.crjateste.dto.DepartamentoDTO;
import com.kelton.crjateste.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    @Query(value = """
            SELECT d.id, d.titulo, COALESCE(count(p.id), 0)  as qtdPessoas,
            COALESCE(count(t.id), 0)  as qtdTarefas
            FROM departamentos d
            LEFT JOIN pessoas p
            ON p.id_departamento = d.id
            LEFT JOIN tarefas t
            ON t.id_departamento = d.id
            GROUP BY d.id
            """, nativeQuery = true)
    List<DepartamentoDTO> listarDepartamentos();
}

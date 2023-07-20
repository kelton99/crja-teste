package com.kelton.crjateste.repository;

import com.kelton.crjateste.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(value = "SELECT t FROM Tarefa t WHERE t.pessoa IS NULL ORDER BY t.prazo ASC LIMIT 3")
    List<Tarefa> listarTarefasPendentes();
}

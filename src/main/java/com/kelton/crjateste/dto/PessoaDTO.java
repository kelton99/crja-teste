package com.kelton.crjateste.dto;

public class PessoaDTO {

    private final Long id;
    private final String departamento;
    private final Integer totalHorasTarefas;

    public PessoaDTO(Long id, String departamento, Integer totalHorasTarefas) {
        this.id = id;
        this.departamento = departamento;
        this.totalHorasTarefas = totalHorasTarefas;
    }

    public Long getId() {
        return id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public Integer getTotalHorasTarefas() {
        return totalHorasTarefas;
    }
}

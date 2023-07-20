package com.kelton.crjateste.dto;

import java.time.Instant;

public record BuscarPessoaDTO(String nome, Instant dataInicial, Instant dataFinal) {

}

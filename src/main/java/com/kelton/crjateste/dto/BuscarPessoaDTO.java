package com.kelton.crjateste.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public record BuscarPessoaDTO(String nome, LocalDateTime dataInicial, LocalDateTime dataFinal) {

}

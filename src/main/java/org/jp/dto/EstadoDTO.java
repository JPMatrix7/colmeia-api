package org.jp.dto;

import org.jp.model.Estado;
import jakarta.validation.constraints.NotBlank;

public record EstadoDTO(

    @NotBlank(message="O campo não pode ser branco")
    String nome,

    @NotBlank(message="O campo não pode ser branco")
    String sigla
) {
    public static EstadoDTO valueOf(Estado estado){
        return new EstadoDTO(estado.getNome(), estado.getSigla());
    }
}

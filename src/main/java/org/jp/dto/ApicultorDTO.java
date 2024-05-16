package org.jp.dto;

import org.jp.model.Apicultor;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record ApicultorDTO(

    @NotBlank(message="Preencha o campo abaixo")
    String nomeFazenda,

    @NotBlank(message = "Preencha o campo abaixo")
    String endereco
) {
    public ApicultorDTO valueOf(Apicultor Apicultor){
        return new ApicultorDTO(Apicultor.getNomeFazenda(), Apicultor.getEndereco());
    }
}

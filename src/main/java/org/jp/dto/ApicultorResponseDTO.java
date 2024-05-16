package org.jp.dto;

import org.jp.model.Apicultor;

public record ApicultorResponseDTO(

    Long id,
    String nomeFazenda,
    String endereco
    ) {
    public static ApicultorResponseDTO valueOf(Apicultor apicultor){
        return new ApicultorResponseDTO(apicultor.getId(), apicultor.getNomeFazenda(), apicultor.getEndereco());
    }
}

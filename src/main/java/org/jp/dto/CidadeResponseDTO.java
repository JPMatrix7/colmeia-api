package org.jp.dto;

import org.jp.model.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado
) {
    public static CidadeResponseDTO valueOf(Cidade cidade){
        return new CidadeResponseDTO(cidade.getId(), cidade.getNome(), EstadoResponseDTO.valueOf(cidade.getEstado()));
    }
}

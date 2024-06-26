package org.jp.dto;

import org.jp.model.Cidade;
import org.jp.model.Estado;

import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(
    //Parametro
    @NotBlank(message="O campo não pode ser branco")
    String nome,

    @NotBlank(message="O campo não pode ser branco")
    Estado estado
) {
    //Metodo
    public static CidadeDTO valueOf(Cidade cidade){
        return new CidadeDTO(cidade.getNome(),cidade.getEstado());
    }
    
}

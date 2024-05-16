package org.jp.service;

import java.util.List;

import org.jp.dto.CidadeDTO;
import org.jp.dto.CidadeResponseDTO;

public interface CidadeService {
    
    public CidadeResponseDTO insert(CidadeDTO cidadeDTO);
    public CidadeResponseDTO update (CidadeDTO cidadeDTO, Long id);
    public void delete(Long id);
    public CidadeResponseDTO findByID(Long id);
    public List <CidadeResponseDTO> findByNome(String nome);
    public List <CidadeResponseDTO> findByAll();
}

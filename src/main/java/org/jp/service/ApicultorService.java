package org.jp.service;

import java.util.List;

import org.jp.dto.ApicultorDTO;
import org.jp.dto.ApicultorResponseDTO;

public interface ApicultorService {
    
    public ApicultorResponseDTO insert(ApicultorDTO apicultorDTO);
    public ApicultorResponseDTO update(ApicultorDTO apicultorDTO, Long id);
    public void delete(Long id);
    public ApicultorResponseDTO findByID(Long id);
    public List <ApicultorResponseDTO> findByNome(String nome);
    public List <ApicultorResponseDTO> findByAll();
}

package org.jp.service;

import java.util.List;

import org.jp.dto.EstadoDTO;
import org.jp.dto.EstadoResponseDTO;

public interface EstadoService {

  public EstadoResponseDTO insert(EstadoDTO estadoDTO);
  public EstadoResponseDTO update(EstadoDTO estadoDTO, Long id);
  public void delete(Long id);
  public EstadoResponseDTO findByID(Long id);
  public List <EstadoResponseDTO> findByNome(String nome);
  public List <EstadoResponseDTO> findByAll();
  
} 



package org.jp.service;

import java.util.List;
import org.jp.dto.EstadoDTO;
import org.jp.dto.EstadoResponseDTO;
import org.jp.model.Estado;
import org.jp.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository estadoRepository;

    @Override
    public EstadoResponseDTO insert(EstadoDTO estadoDTO) {
        Estado estado = new Estado();
        estado.setNome(estadoDTO.nome());
        estado.setSigla(estadoDTO.sigla());

        estadoRepository.persist(estado);
        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public EstadoResponseDTO update(EstadoDTO estadoDTO, Long id) {
        Estado estado = estadoRepository.findById(id);
        estado.setNome(estadoDTO.nome());
        estado.setSigla(estadoDTO.sigla());

        estadoRepository.persist(estado);
        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public void delete(Long id) {
        
        if(!estadoRepository.deleteById(id)){ //!--> lógica se contém número (PANACHE)
            throw new NotFoundException("ID não encontrado");
        }
    }

    @Override
    public EstadoResponseDTO findByID(Long id) {
        Estado estado = estadoRepository.findById(id);

        if(estado == null){
            throw new NotFoundException("Não encontrado");
        }
        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return estadoRepository.findByNome(nome).stream()
        .map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findByAll() {
        return estadoRepository.listAll().stream().map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }
    
}

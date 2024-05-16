package org.jp.service;

import java.util.List;

import org.jp.dto.ApicultorDTO;
import org.jp.dto.ApicultorResponseDTO;
import org.jp.dto.EstadoResponseDTO;
import org.jp.model.Apicultor;
import org.jp.repository.ApicultorRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApicultorServiceImpl implements ApicultorService{

    ApicultorRepository apiRepository;

    @Override
    public ApicultorResponseDTO insert(ApicultorDTO apicultorDTO) {
        Apicultor api = new Apicultor();
        api.setNomeFazenda(apicultorDTO.nomeFazenda());
        api.setEndereco(apicultorDTO.endereco());

        apiRepository.persist(api);
        return ApicultorResponseDTO.valueOf(api);
    }

    @Override
    public ApicultorResponseDTO update(ApicultorDTO apicultorDTO, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ApicultorResponseDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ApicultorResponseDTO> findByNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ApicultorResponseDTO> findByAll() {
            return apiRepository.listAll().stream().map(e -> ApicultorResponseDTO.valueOf(e)).toList();
    }
}


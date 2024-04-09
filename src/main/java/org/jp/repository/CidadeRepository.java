package org.jp.repository;

import java.util.List;

import org.jp.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    
    public List<Cidade> findByNome(String nome){
        return find("UPPER (nome) LIKE (?1)", "%"+nome+"%").list();
    }
}

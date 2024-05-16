package org.jp.repository;

import java.util.List;

import org.jp.model.Apicultor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApicultorRepository implements PanacheRepository<Apicultor> {

    public List<Apicultor> findByNome(String nomeFazenda){
        return find("UPPER (nomeFazenda) LIKE (?1)", "%"+nomeFazenda+"%").list();
    }

}

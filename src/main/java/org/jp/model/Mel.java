package org.jp.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Mel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false, length = 255)
    private String nome;

    @Column(name="nome", nullable = false, length = 255)
    private String descricao;

    @Column(name="nome", nullable = false, length = 70)
    private String especieAbelha;

    @Column(name="nome", nullable = false, length = 50)
    private Double preco;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEspecieAbelha() {
        return especieAbelha;
    }
    public void setEspecieAbelha(String especieAbelha) {
        this.especieAbelha = especieAbelha;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    

}

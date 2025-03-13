package br.senai.coisa.model;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 11)
    private Long fone;

    @Column(nullable = false, length = 255)
    private String endereco;

    // Construtores, getters e setters

    public Cliente() {
    }

    public Cliente(String nome, Long fone, String endereco) {
        this.nome = nome;
        this.fone = fone;
        this.endereco = endereco;
    }

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

    public Long getFone() {
        return fone;
    }

    public void setFone(Long fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

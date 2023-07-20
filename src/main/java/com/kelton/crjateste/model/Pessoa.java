package com.kelton.crjateste.model;


import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    private Departamento departamento;

    public Pessoa() { }

    public Pessoa(Long id, String nome, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

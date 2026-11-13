package com.joao.biblioteca.Model;

import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<Livro> Livros;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return Livros;
    }

    public void setLivros(List<Livro> livros) {
        Livros = livros;
    }
}

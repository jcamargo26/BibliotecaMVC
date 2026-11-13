package com.joao.biblioteca.Model;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private Livro livro;
    private String nomeLeitor;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    // Novo atributo
    private String status;

    public Emprestimo() {
        this.dataRetirada = LocalDate.now();
        this.status = "EMPRESTADO";
    }


    public void registrarDevolucao() {
        this.status = "DEVOLVIDO";
        this.dataDevolucao = LocalDate.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }

    public String getNomeLeitor() { return nomeLeitor; }
    public void setNomeLeitor(String nomeLeitor) { this.nomeLeitor = nomeLeitor; }

    public LocalDate getDataRetirada() { return dataRetirada; }
    public void setDataRetirada(LocalDate dataRetirada) { this.dataRetirada = dataRetirada; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

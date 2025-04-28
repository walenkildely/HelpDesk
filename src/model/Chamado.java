package model;

import java.time.LocalDate;

public class Chamado {
    private String titulo;
    private String descricao;
    private Funcionario solicitante;
    private LocalDate dataAbertura;
    private String status;
    private Tecnico tecnicoResponsavel;

    public Chamado(String titulo, String descricao, Funcionario solicitante) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.dataAbertura = LocalDate.now();
        this.status = "Aberto";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tecnico getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Tecnico tecnico) {
        this.tecnicoResponsavel = tecnico;
    }

    public String toString() {
        return "Chamado: " + titulo + "\nDescrição: " + descricao + "\nStatus: " + status +
               "\nData: " + dataAbertura + "\nSolicitante: " + solicitante.getNome() +
               (tecnicoResponsavel != null ? "\nTécnico: " + tecnicoResponsavel.getNome() : "");
    }
}

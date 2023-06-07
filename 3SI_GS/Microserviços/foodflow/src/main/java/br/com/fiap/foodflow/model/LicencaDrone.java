package br.com.fiap.foodflow.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LicencaDrone {

    @Id
    @Column(length = 8)
    private Integer numLicenca;

    @Column(nullable = false)
    private LocalDate dataEmissao;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @Column(nullable = false, length = 100)
    private String titular;

    public Integer getNumLicenca() {
        return numLicenca;
    }

    public void setNumLicenca(Integer numLicenca) {
        this.numLicenca = numLicenca;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}

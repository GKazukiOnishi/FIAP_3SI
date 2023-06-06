package br.com.fiap.foodflow.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LicencaDroneDTO implements Validavel {

    @NotNull(message = "Número de licença obrigatório")
    @Digits(integer = 8, message = "O número de licença deve ter até 8 dígitos", fraction = 0)
    private Integer numLicenca;
    @NotNull(message = "Data de emissão obrigatória")
    private LocalDate dataEmissao;
    @NotNull(message = "Data de validade obrigatória")
    private LocalDate dataValidade;
    @NotBlank(message = "Titular obrigatório")
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

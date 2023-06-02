package br.com.fiap.foodflow.dto;

import java.util.Map;

public class ErroDTO {

    private String mensagem;
    private Map<String, String> errosPorCampo;

    public ErroDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ErroDTO(String mensagem, Map<String, String> errosPorCampo) {
        this.mensagem = mensagem;
        this.errosPorCampo = errosPorCampo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Map<String, String> getErrosPorCampo() {
        return errosPorCampo;
    }

    public void setErrosPorCampo(Map<String, String> errosPorCampo) {
        this.errosPorCampo = errosPorCampo;
    }

}

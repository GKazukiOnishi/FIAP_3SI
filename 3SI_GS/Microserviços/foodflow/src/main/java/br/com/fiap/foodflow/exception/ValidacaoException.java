package br.com.fiap.foodflow.exception;

import java.util.Map;

public class ValidacaoException extends RuntimeException {

    private Map<String, String> erroPorCampos;

    public ValidacaoException(String mensagem, Map<String, String> erroPorCampos) {
        super(mensagem);
        this.erroPorCampos = erroPorCampos;
    }

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

    public Map<String, String> getErroPorCampos() {
        return erroPorCampos;
    }

    public void setErroPorCampos(Map<String, String> erroPorCampos) {
        this.erroPorCampos = erroPorCampos;
    }

}

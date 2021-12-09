/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.model;

import java.sql.Date;

/**
 *
 * @author Amanda
 */
public class Conta {
 private String dataAbertura;
    private String horaAbertura;
    private Double valorTotal;
    private int codConta;
    private String login;

    /**
     * @return the dataAbertura
     */
    public String getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @return the horaAbertura
     */
    public String getHoraAbertura() {
        return horaAbertura;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }
    
    public Conta (String dataAbertura, String horaAbertura, Double valorTotal ,int codConta, String login){
        this.dataAbertura=dataAbertura;
        this.horaAbertura=horaAbertura;
        this.valorTotal=valorTotal;
        this.codConta=codConta;
        this.login=login;
    }

    /**
     * @return the codConta
     */
    public int getCodConta() {
        return codConta;
    }

    /**
     * @param codConta the codConta to set
     */
    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @param horaAbertura the horaAbertura to set
     */
    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
}
  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.model;

/**
 *
 * @author Amanda
 */
public class Produto {
    private String nome;
    private String porcao;
    private Double valor;
    private String categoria;
    private int quantEstoque;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the porcao
     */
    public String getPorcao() {
        return porcao;
    }

    /**
     * @param porcao the porcao to set
     */
    public void setPorcao(String porcao) {
        this.porcao = porcao;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the quantEstoque
     */
    public int getQuantEstoque() {
        return quantEstoque;
    }

    /**
     * @param quantEstoque the quantEstoque to set
     */
    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
    public Produto (String nome, String porcao, Double valor, String categoria, int quantEstoque){
        this.nome=nome;
        this.porcao=porcao;
        this.valor=valor;
        this.categoria=categoria;
        this.quantEstoque=quantEstoque;
        
       
    }
    
    
}

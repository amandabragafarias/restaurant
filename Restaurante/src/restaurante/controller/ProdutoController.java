/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controller;

import restaurante.dao.ProdutoDAO;
import restaurante.model.Produto;
import restaurante.util.NegocioException;

/**
 *
 * @author Amanda
 */
public class ProdutoController {
     ProdutoDAO produtoDao = new ProdutoDAO();
   
    
    public void adicionarProduto(Produto produto) throws NegocioException{
        try{
            this.buscarProduto(produto.getNome());
            throw new NegocioException("Produto já cadastrado.");
        }catch(NegocioException e){
            produtoDao.adicionarProduto(produto);
        }
        
    } public Produto buscarProduto(String nome) throws NegocioException{
        if(produtoDao.buscarProduto(nome)!=null){
            return produtoDao.buscarProduto(nome);
        }else{
            throw new NegocioException("Produto não encontrado.");
        }
    }
    
      public void deletarProduto(String nome) throws NegocioException{
        
        produtoDao.deletarProduto(nome);
    }
      
     public void atualizarProduto(String nome, Produto produto) throws NegocioException{
       if ( this.buscarProduto(nome) != null){
        produtoDao.atualizarProduto(nome, produto);}else{
           throw new NegocioException("Produto não encontrado");
       }
    }
    
}

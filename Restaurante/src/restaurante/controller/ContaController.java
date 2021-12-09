/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controller;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import restaurante.dao.ContaDAO;
import restaurante.model.Comissao;
import restaurante.model.Conta;
import restaurante.model.Produto;
import restaurante.util.NegocioException;

/**
 *
 * @author Amanda
 */
public class ContaController {
    ContaDAO contaDao = new ContaDAO();
     public void abrirConta(Conta conta) throws NegocioException{
        try{
            this.buscarConta(conta.getCodConta());
            throw new NegocioException("Conta já cadastrada.");
        }catch(NegocioException e){
            contaDao.abrirConta(conta);
        }
     }
     
      public ArrayList<Produto> buscarProdutosPorConta(int codConta) throws NegocioException{
        if(contaDao.buscarProdutosPorConta(codConta)!=null){
            return contaDao.buscarProdutosPorConta(codConta);
        }else{
            throw new NegocioException("Nenhum produto encontrado");
        }
    }
     
     public ArrayList<Produto> array() throws NegocioException{
        
            return contaDao.array();
      
    }
    
    public void associarContaProduto(Conta conta, Produto produto) throws NegocioException{
      
            contaDao.AssociarContaProduto(conta, produto);
        
        
    }
     public int gerarCod() throws NegocioException{
      return contaDao.gerarCod();
    }
    public Conta buscarConta(int codConta) throws NegocioException{
        if(contaDao.buscarConta(codConta)!=null){
            return contaDao.buscarConta(codConta);
        }else{
            throw new NegocioException("Conta não encontrada.");
        }
    }
     public Produto buscarProdutoPorConta(int codConta) throws NegocioException{
        if(contaDao.buscarProdutoPorConta(codConta)!=null){
            return contaDao.buscarProdutoPorConta(codConta);
        }else{
            throw new NegocioException("Produto não encontrado.");
        }
    }
    
    
      public void cancelarConta(int codConta) throws NegocioException{
        
        contaDao.cancelarConta(codConta);
    }
       public void deletarContaProduto(int codConta) throws NegocioException{
        
        contaDao.deletarContaProduto(codConta);
    }
      
        public void deletarPedido(String nome) throws NegocioException{
        
        contaDao.deletarPedido(nome);
    }
       
     public void atualizarConta(int codConta, Conta conta) throws NegocioException{
       if ( this.buscarConta(codConta) != null){
        contaDao.atualizarConta(codConta, conta);}else{
           throw new NegocioException("Conta não encontrada");
       }
    }
}

    


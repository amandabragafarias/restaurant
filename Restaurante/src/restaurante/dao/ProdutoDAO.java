/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurante.model.Produto;
import restaurante.util.ConnectionFactory;

/**
 *
 * @author Amanda
 */
public class ProdutoDAO {
     public void adicionarProduto(Produto produto) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert "
                + "into Produto(nome_produto, porcao, valor, categoria, quantEstoque)"
                + " values(?, ?, ?, ?, ?)";
    try { 
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,produto.getNome());
            pstm.setString(2, produto.getPorcao());
             pstm.setDouble(3, produto.getValor());
              pstm.setString(4, produto.getCategoria());
               pstm.setInt(5, produto.getQuantEstoque());
           
             
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
           try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     
     
      public Produto buscarProduto(String nome) {
        
        String sql = "select * from Produto"
                + " where nome_produto=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setString(1, nome);
            
            rset = pstm.executeQuery();

            Produto produto = new Produto(null, null, 0.0, null, 0);
            
            while (rset.next()) {
               
         
               produto.setNome(rset.getString("nome_produto"));
               produto.setPorcao(rset.getString("porcao"));
                produto.setValor(rset.getDouble("valor"));
                 produto.setCategoria(rset.getString("categoria"));
                  produto.setQuantEstoque(rset.getInt("quantEstoque"));
                 
                
                return produto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
     
      
      public void deletarProduto(String nome) {
        String sql = "delete from Produto where nome_produto=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
      
      
      public void atualizarProduto(String nome, Produto produto) {
        String sql = "update Produto "
                + "set nome_produto=?, porcao=?, valor=?, categoria=?, quantEstoque=? "
                + "where nome_produto=?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getPorcao());
            pstm.setDouble(3, produto.getValor());
            pstm.setString(4, produto.getCategoria());
            pstm.setInt(5, produto.getQuantEstoque());
          
           pstm.setString(6, nome);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
      
}

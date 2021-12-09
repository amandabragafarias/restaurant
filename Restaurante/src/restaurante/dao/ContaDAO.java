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
import java.util.ArrayList;
import restaurante.controller.ContaController;
import restaurante.model.Comissao;
import restaurante.model.Conta;
import restaurante.model.Produto;
import restaurante.util.ConnectionFactory;

/**
 *
 * @author Amanda
 */
public class ContaDAO {
 //   ContaController controle = new ContaController();
    ArrayList<Produto> itens = new ArrayList<>();
    ArrayList<Produto> p = new ArrayList<>();
      ArrayList<Comissao> c = new ArrayList<>();
    int cod;
    
      public int gerarCod () {
          cod++;
          return cod;
          
        
    }
     
    public ArrayList<Produto> array() {
        
String sql = "select * from Produto" ;
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;
itens.clear();
        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
           // pstm.setString(1, titulo);
            
            rset = pstm.executeQuery();

           
            
            while (rset.next()) {
               
                Produto produto = new Produto(null, null, 0.0, null, 0);
                produto.setNome(rset.getString("nome_produto"));
                produto.setPorcao(rset.getString("porcao"));
                produto.setValor(rset.getDouble("valor"));
                produto.setCategoria(rset.getString("categoria"));
                produto.setQuantEstoque(rset.getInt("quantEstoque"));
                itens.add(produto);
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
         return itens;
      }
    
    
     public void abrirConta(Conta conta) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert "
                + "into Conta(codConta, dataAbertura, horaAbertura, valorTotal, login)"
                + " values(?, ?, ?, ?,?)";
    try { 
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
             pstm.setInt(1,conta.getCodConta());
            pstm.setString(2,conta.getDataAbertura());
            pstm.setString(3, conta.getHoraAbertura());
             pstm.setDouble(4, conta.getValorTotal());
              pstm.setString(5, conta.getLogin());
           
           
             
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
     public Conta buscarConta(int codConta) {
        
        String sql = "select * from Conta"
                + " where  codconta=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, codConta);
            
            rset = pstm.executeQuery();

            Conta conta = new Conta(null, null, null, 0, null);
            
            while (rset.next()) {
               
         
               conta.setDataAbertura(rset.getString("DataAbertura"));
               conta.setHoraAbertura(rset.getString("HoraAbertura"));
               conta.setValorTotal(rset.getDouble("ValorTotal"));
               conta.setCodConta(rset.getInt("CodConta"));
               conta.setLogin(rset.getString("login"));
                 
                
                return conta;
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
     
    
     
     
      public ArrayList<Produto> buscarProdutosPorConta(int codConta) {
      
       String sql = "select * from ContaProduto"
                + " where codConta=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        p.clear();
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, codConta);
            
            rset = pstm.executeQuery();

            
            
            while (rset.next()) {
              Produto produto = new Produto(null, null, 0.0, null, 0);
                //Playlist playlist = new Playlist(null);
                produto.setNome(rset.getString("nome_produto"));
                produto.setPorcao(buscarProduto(produto.getNome()).getPorcao());
                produto.setCategoria(buscarProduto(produto.getNome()).getCategoria());
                produto.setValor(buscarProduto(produto.getNome()).getValor());
                produto.setQuantEstoque(buscarProduto(produto.getNome()).getQuantEstoque());
                p.add(produto);
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
        return p;
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
     
     public Produto buscarProdutoPorConta(int codConta) {
        
        String sql = "select * from ContaProduto"
                + " where codConta=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, codConta);
            
            rset = pstm.executeQuery();

           Produto produto = new Produto(null, null, 0.0, null, 0);
            
            while (rset.next()) {
               
                 produto.setNome(rset.getString("nome_produto"));
              
                 
                
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
    
      public void AssociarContaProduto(Conta conta, Produto produto){
         Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert "
                + "into ContaProduto(nome_produto, codConta)"
                + " values(?, ?)";

        try {
            
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
           
           
            pstm.setString(1, produto.getNome()); 
            pstm.setInt(2, conta.getCodConta());
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
      public void cancelarConta(int codConta) {
        String sql = "delete from Conta where codConta=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codConta);
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
      
      public void deletarContaProduto(int codConta) {
        String sql = "delete from ContaProduto where codConta=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codConta);
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
       public void deletarPedido(String nome) {
        String sql = "delete from ContaProduto where nome_produto=?";
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
      
       public void atualizarConta(int codConta, Conta conta) {
        String sql = "update Conta "
                + "set codConta=?, dataAbertura=?, horaAbertura=?, valorTotal=?, login=?  "
                + "where codConta=?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, conta.getCodConta());
            pstm.setString(2, conta.getDataAbertura());
            pstm.setString(3, conta.getHoraAbertura());
            pstm.setDouble(4, conta.getValorTotal());
            pstm.setString(5, conta.getLogin());
          
           pstm.setInt(6, codConta);
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

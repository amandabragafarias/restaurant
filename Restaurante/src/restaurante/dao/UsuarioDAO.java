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
import restaurante.model.Usuario;
import restaurante.util.ConnectionFactory;

/**
 *
 * @author Amanda
 */
public class UsuarioDAO {
     public void adicionarUsuario(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "insert "
                + "into Usuario(nome, login, senha, dataNasc, endereco, telefone, cpf, tipo)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
    try { 
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,usuario.getNome());
             pstm.setString(2,usuario.getLogin());
              pstm.setString(3,usuario.getSenha());
            pstm.setString(4, usuario.getDataNascimento());
             pstm.setString(5, usuario.getEndereco());
              pstm.setString(6,usuario.getTelefone());
               pstm.setString(7, usuario.getCpf());
               pstm.setString(8,usuario.getTipo());
              
           
             
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

    public Usuario buscarUsuario(String cpf) {
        
        String sql = "select * from Usuario"
                + " where cpf=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setString(1, cpf);
            
            rset = pstm.executeQuery();

            Usuario usuario = new Usuario (null, null, null, null, null, null, null, null, 0.0);
            
            while (rset.next()) {
               
         
               usuario.setNome(rset.getString("nome"));
               usuario.setLogin(rset.getString("login"));
               usuario.setSenha(rset.getString("senha"));
               usuario.setDataNascimento(rset.getString("dataNasc"));
                usuario.setTelefone(rset.getString("telefone"));
                 usuario.setEndereco(rset.getString("endereco"));
                 usuario.setTipo(rset.getString("tipo"));
                  usuario.setCpf(rset.getString("cpf"));
                 
                
                return usuario;
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
   
    public Usuario buscarUsuarioPorLogin(String login) {
        
        String sql = "select * from Usuario"
                + " where login=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            
            conn = ConnectionFactory.getConexao();
            
            pstm = conn.prepareStatement(sql);
           
            pstm.setString(1, login);
            
            rset = pstm.executeQuery();

            Usuario usuario = new Usuario (null, null, null, null, null, null, null, null, 0.0);
            
            while (rset.next()) {
               
         
               usuario.setNome(rset.getString("nome"));
               usuario.setLogin(rset.getString("login"));
               usuario.setSenha(rset.getString("senha"));
               usuario.setDataNascimento(rset.getString("dataNasc"));
                usuario.setTelefone(rset.getString("telefone"));
                 usuario.setEndereco(rset.getString("endereco"));
                 usuario.setTipo(rset.getString("tipo"));
                  usuario.setCpf(rset.getString("cpf"));
                  usuario.setComissao(rset.getDouble("comissao"));
                 
                
                return usuario;
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
    
    public void deletarUsuario(String cpf) {
        String sql = "delete from Usuario where cpf=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
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
    public void atualizarUsuario(String cpf, Usuario usuario) {
        String sql = "update Usuario "
                + "set nome=?, login=?, senha=?, dataNasc=?, telefone=?, endereco=?, cpf=?, tipo=?, comissao =? "
                + "where cpf=?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4,usuario.getDataNascimento());
            pstm.setString(5, usuario.getTelefone());
            pstm.setString(6, usuario.getEndereco());
            pstm.setString(7, usuario.getCpf());
            pstm.setString(8, usuario.getTipo());
            pstm.setDouble(9, usuario.getComissao());
            pstm.setString(10, cpf);
         
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


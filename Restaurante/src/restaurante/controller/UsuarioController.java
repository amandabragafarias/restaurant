/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controller;

import restaurante.dao.UsuarioDAO;
import restaurante.model.Usuario;
import restaurante.util.NegocioException;

/**
 *
 * @author Amanda
 */
public class UsuarioController {
    UsuarioDAO usuarioDao = new UsuarioDAO();
   
    
    public void adicionarUsuario(Usuario usuario) throws NegocioException{
        try{
            this.buscarUsuario(usuario.getCpf());
            throw new NegocioException("Usuario já cadastrado.");
        }catch(NegocioException e){
            usuarioDao.adicionarUsuario(usuario);
        }
        
    } 
    public Usuario buscarUsuario(String cpf) throws NegocioException{
        if(usuarioDao.buscarUsuario(cpf)!=null){
            return usuarioDao.buscarUsuario(cpf);
        }else{
            throw new NegocioException("Usuario não encontrado.");
        }
    }
       public Usuario buscarUsuarioPorLogin(String login) throws NegocioException{
        if(usuarioDao.buscarUsuarioPorLogin(login)!=null){
            return usuarioDao.buscarUsuarioPorLogin(login);
        }else{
            throw new NegocioException("Usuario não encontrado.");
        }
    }
    
    
      public void deletarUsuario(String cpf) throws NegocioException{
        
        usuarioDao.deletarUsuario(cpf);
    }
      
     public void atualizarUsuario(String cpf, Usuario usuario) throws NegocioException{
       if ( this.buscarUsuario(cpf) != null){
        usuarioDao.atualizarUsuario(cpf, usuario);
       }
       else{
           throw new NegocioException("Usuario não encontrado");
       }
    }
     
    }
    
    


    


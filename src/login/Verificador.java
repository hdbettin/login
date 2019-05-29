/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public abstract class Verificador {
    
    protected HashMap<String, Usuario> usuarios;
    protected final String peticion;
    protected HashMap<String, String> mapadesafios;

    public Verificador(String peticion) {
        this.peticion = peticion;
        this.usuarios = new HashMap<String, Usuario>();
        this.mapadesafios =  new HashMap<String, String>();
    }
    
    
    
    
    public  ArrayList<Usuario>consulta_usuarios(){
        ArrayList<Usuario> retorno = new ArrayList<Usuario>();
        for(Map.Entry<String, Usuario> usu : this.usuarios.entrySet()){
            retorno.add(usu.getValue());
        }
        return retorno;
    }
    
    public void anadirUsuarios(Usuario ... usuarios){
        for(Usuario usuario : usuarios){
            this.usuarios.put(usuario.getLogin(), usuario);
        }
    }
    
    public boolean borrarUsuario(Usuario usuario){
        if(this.usuarios.remove(usuario.getLogin()) != null){
            return true;
        }else{
            return false;
        }
    }
    
    
    protected abstract String loginPaso1(String login, String password);
    
    public boolean loginPaso2(String token, String respuesta){
        boolean retorno = false;
        if(this.mapadesafios.containsKey(token)){
            if(respuesta.equals(this.mapadesafios.get(token))){
                this.mapadesafios.remove(token);
                retorno = true;
            }
        }
        return retorno;
    }
    
    public String toString(){
        return "Usuarios: " + this.usuarios + "peticion: " + this.peticion + "desafios: " + this.mapadesafios; 
    }
}



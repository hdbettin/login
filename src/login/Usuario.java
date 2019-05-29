/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    private String login;
    private LocalDate ultimo_acceso;
    private String password;
    private ArrayList<String> historial;

    public Usuario(String cadena, String password) {
        this.login = cadena;
        this.password = password;
        this.ultimo_acceso = LocalDate.now();
        this.historial = new ArrayList<String>();
        this.historial.add(password);
    }
    
    public boolean modificarPassword(String viejo, String nuevo){
        boolean retorno = true;
        if(viejo.equals(this.password)){
            for(String contras : this.historial){
                if(nuevo.equals(contras)){
                    retorno = false;
                }
            }
        }else{
            retorno = false;
        }
        
        if(retorno){
            this.setPassword(nuevo);
            this.historial.add(nuevo);
            return retorno;
        }else{
            return retorno;
        }
    }
    
    public boolean validar(String pass){
        if(pass.equals(this.password)){
            return true;
        }else{
            return false;
        }
    }
    
    public void establecerFecha(){
        this.ultimo_acceso = LocalDate.now();
    }
    
    public String toString(){
        return "login: " + this.login + "password: " + this.password + "ultimo acceso: " + this.ultimo_acceso + "historial: " + this.historial;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getLogin() {
        return login;
    }

    public LocalDate getUltimo_acceso() {
        return ultimo_acceso;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }
    
    
    
    
    
}

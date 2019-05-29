/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class BlackList extends Verificador {
    
    private ArrayList<String> bloqueados;

    public BlackList(String peticion) {
        super(peticion);
        this.bloqueados = new ArrayList<String>();
    }
    
    
    protected String loginPaso1(String login, String password){
        String token = null;
        if(this.usuarios.containsKey(login)){
            if(password.equals(this.usuarios.get(login).getPassword())){
                Scanner scanner = new Scanner(System.in);
                System.out.println(this.peticion);
                String acceso = scanner.nextLine();
                token = UUID.randomUUID().toString();
                String respuesta_correcta = String.valueOf(this.usuarios.get(login).getUltimo_acceso().getDayOfMonth());
                this.mapadesafios.put(token, respuesta_correcta);
                scanner.close();
                
            }
        }
        return token;
    }
    
    
    
    public void darAlta(String login){
        this.bloqueados.remove(login);
    }
    public void bloquear(String login){
        this.bloqueados.add(login);
    }
    
}

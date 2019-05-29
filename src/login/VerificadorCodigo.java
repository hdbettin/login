/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class VerificadorCodigo extends Verificador {
    private final int limite_intentos;

    public VerificadorCodigo(int limite_intentos, String peticion) {
        super(peticion);
        this.limite_intentos = limite_intentos;
    }
    
    
    protected String loginPaso1(String login, String password){
        String token = null;
        if(this.usuarios.containsKey(login)){
            if(password.equals(this.usuarios.get(login).getPassword())){
                Scanner scanner = new Scanner(System.in);
                System.out.println(this.peticion);
                String acceso = scanner.nextLine();
                token = UUID.randomUUID().toString();
                double randomDouble = Math.random();
		randomDouble = randomDouble * 999 + 1;
		int randomInt = (int) randomDouble;
                String respuesta_correcta = String.valueOf(randomInt);
                System.err.println(respuesta_correcta);
                this.mapadesafios.put(token, respuesta_correcta);
                scanner.close();
                
            }
        }
        return token;
    }

    public int getLimite_intentos() {
        return limite_intentos;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Usuario
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuario fperez = new Usuario("fperez", "lechemerengada");
        fperez.modificarPassword("lechemerengada", "cr7comeback");
        
        Usuario mlama = new Usuario("mlama", "tururu");
        
        BlackList black = new BlackList("Introduzca el numero del dia de su ultimo dia de acceso de acceso: ");
        VerificadorCodigo codigo = new VerificadorCodigo(5, "Introduzca el número que ha recibido por SMS: ");
        
        black.anadirUsuarios(fperez, mlama);
        codigo.anadirUsuarios(fperez, mlama);
    }
    
}

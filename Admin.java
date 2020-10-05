/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Admin: Clase que representará a un Administrador con contraseña (Esta clase hereadará de Usuario)</h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 2.0
 * @since 2020
 * 
 */

public class Admin extends Usuario{

    // --> Atributos exclusivos para Admin
    private String contrasena;
    private boolean adminAdentro;

    // --> Constructor
    public Admin(){
        super("Admin"); // Vamos a pedir el roll que fue solicitado en la clase Usuario
        // Estas inicializaciones serán personalizadas para la clase Admin
        contrasena = "Covidianos2020";
        adminAdentro = false;
    }

    // --> Getters
    // Este Getter será especial ya que la contraseña no debe de ingresar cualquier persona
    public String getContrasena(String verificar){
        // Si la contraseña es correcta entonces retornará la contraseña
        if(verificar.equals(contrasena)){
            adminAdentro = true;
            return contrasena;
        }
        // Si no lo es entonces se mandará un mensaje
        else{
            return "-> Contraseña Inválida";
        }
    }

    public boolean getAdminAdentro(){
        return adminAdentro;
    }

    // --> Métodos
    // Creo que voy a asignar un método para
    public String salir(){
        // Si el Admin salio su estado de adentro será falso
        if(adminAdentro == true){
            CambiarAdminEstado();
            return "Admin cerro su sesión";
        }
        // Si el admin no ha salido se mandará un aviso que sigue adentro
        else{
            return "Admin sigue adentro";
        }
    }

    private void CambiarAdminEstado(){
        adminAdentro = false;
    }
}
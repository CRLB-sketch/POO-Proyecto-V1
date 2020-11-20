/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Usuario: Clase que representará a un usuario comun y corriente </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version Final
 * @since 2020
 * 
 */

public abstract class Usuario {

    // --> Atributos
    protected String roll;

    // --> Constructor
    public Usuario(String roll){
        this.roll = roll;
    }

    // --> Métodos    
    abstract public String getRoll();
    
    abstract public String toString();
}

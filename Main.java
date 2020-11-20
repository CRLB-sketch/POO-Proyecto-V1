/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Main (Este es el menu con el cual el usuario puede interactuar) </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version Final
 * @since 2020
 * 
 */

class Main {

  public static void main(String[] args) {

    // Instanciaremos el controlador donde se encuentra toda la lógica
    Controlador controller = new Controlador();
    controller.menu(); // Para llevar a cabo todas las intrucciones
  }
}
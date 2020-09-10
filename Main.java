/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Main (Pequeña descripción de que clase es) </h2>
 * 
 * 
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 1.0
 * @since 2020
 * 
 */

// De esto se encargará Diego Sanchez

import java.util.Scanner;

class Main {

  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // Vamos a instanciar el registro en donde se almacenarán todos los registros
    Registro registro = new Registro();

    boolean salir = false;
    do{

      // Esto sera una simulacion en sí y pasaran los días      
      System.out.println("1. Guardar info");
      System.out.println("2. Mostrar info");
      System.out.println("3. Salir");
      String opcion = scanner.nextLine();

      // No se que más opciones irian, aquí solo dejo esto para probar la clase Registro
      switch(opcion){
        case "1":
          System.out.println("\n----- Guardar info -----");
          System.out.println("Porfavor ingrese la información que desee guardar: ");
          String info = scanner.nextLine(); //   

          registro.AgregarInformación(info); // Aquí se mandará la información al registro

          break;

        case"2":
          System.out.println("\n----- Mostrar info -----");
  
          System.out.println(registro.MostrarInformacion()); // Se mostrará la información registrada
          
          break;

        case "3":
          System.out.println("\nSaliendo....");
          salir = true; // Se terminará con el ciclo do-while del menu
          break;

        default:
          System.out.println("\n-> No ingreso un valor valido");
          break;        
      }

    }while(salir != true);
  }
}
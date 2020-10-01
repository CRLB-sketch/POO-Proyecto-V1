/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Main (Este es el menu con el cual el usuario puede interactuar) </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 2.0
 * @since 2020
 * 
 */

import java.util.Scanner;

class Main {

  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {

    System.out.println("Bienvenidos a la simulacion de aglomeraciones en la ciudad de Guatemala");

    // Vamos a instanciar el registro en donde se almacenarán todos los registros
    Registro registro = new Registro(); // Para tener el registro
    Persona persona; // Para tener a la persona
    Zonas zonas = new Zonas(); // Para las zonas

    // Para los usuarios
    Usuario user = new Usuario("Usuario Normal"); // Para identificar a un usuario normal
    Admin administrador = new Admin(); // Para identificar y crear al Administrador del programa

    boolean salir = false;
    do{

      // Esto sera una simulacion en sí y pasaran los días     
      System.out.println("---------------------------------------------");      
      System.out.println("Ingrese el numero de la opcion que desea: ");
      System.out.println("1. Registrar persona");
      System.out.println("2. Mostrar info");
      System.out.println("3. Salir");
      String opcion = scanner.nextLine();

      switch(opcion){
        //Opcion donde se ingresan los datos de la persona
        case "1":
          try{ // Esto es para evitar que el programa truene si se ingresan los datos incorrectos

            System.out.println("\n----- Registrar persona -----");
            System.out.println("Ingrese su numero de CUI: ");
            String ucui = scanner.nextLine();   
            System.out.println("Ingrese la zona en la que se encuentra: ");
            int uzona = scanner.nextInt();
            //En zonas no se si es mejor ingresar la clase zonas o no--Diego
            System.out.println("Ingrese la hora actual (Formato de 24 horas): ");
            double uhora = scanner.nextDouble();
            String salto = scanner.nextLine();

            System.out.println("Ingrese El lugar especifico: "); 
            String uespecifico = scanner.nextLine();

            // Aquí se creará una nueva persona con las caracteristicas ingresadas anteriormente
            persona = new Persona(ucui, uzona, uhora, uespecifico);

            registro.AgregarPersona(persona); // Aquí se mandará la persona al historial de personas y de una vez se creará el registro

            System.out.println("\n--> Información almacenada exitosamente :D\n");

          }catch(Exception e){
            System.out.println("--> Hey! No debes de ingresar letras en la sección que acabas de ingresar los datos");
          }
          break;

        //Opcion que muestra la informacion
        case"2":
          System.out.println("\n----- Mostrar info -----");
  
          if(registro.PersonasRegistradas() == 0){
            System.out.println("NO hay datos ingresados todavía");
          }else{

            System.out.println("______________________________________");
            System.out.println(registro.MostrarInformacion()); // Se mostrará la información registrada
            System.out.println("Cantidad personas registradas: " + registro.PersonasRegistradas());
            System.out.println("______________________________________");
            System.out.println("---> Presiona enter para ver la cantidad de personas por zona <---");
            String enter1 = scanner.nextLine();
            // Se mostrará la cantidad de personas por zona del momento
            System.out.println("La cantidad de personas por zona son:");
            int r;
            r= zonas.dpzonas();
            System.out.println(r);
          }
  
          //Tambien se debe mostrar la poblacion de la zona--Diego          
          break;

        //Opcion para salir
        case "3":
          System.out.println("\nSaliendo....");
          salir = true; // Se terminará con el ciclo do-while del menu
          break;

        // Si no ingresa una opcion valida no se llevará a cabo una de las operaciones
        default:
          System.out.println("\n-> No ingreso un valor valido");
          break;        
      }

    }while(salir != true); // Condicional para que continue o termine el ciclo
  }
}
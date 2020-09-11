/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Main (Este es el menu con el cual el usuario puede interactuar) </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 1.0
 * @since 2020
 * 
 */

import java.util.Scanner;

//Tengo guardado  el main original de Christian por si quieren regresar a ese--Diego
// Buenisima onda Diego! :D --Cristian
class Main {

  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {

    System.out.println("Bienvenidos a la simulacion de aglomeraciones en la ciudad de Guatemala");

    // Vamos a instanciar el registro en donde se almacenarán todos los registros
    Registro registro = new Registro();
    Persona persona;
    Zonas zonas = new Zonas();

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
            double uhora = scanner.nextDouble();// Aqui creo que quedaria mejor un string o un date pero no se como se  hace--Diego
            String salto = scanner.nextLine();
            System.out.println("Ingrese El lugar especifico: "); //Para este prototipo sugiero todavia no ingresar esto -- Diego
            String uespecifico = scanner.nextLine();
            // Aquí se creará una nueva persona con las caracteristicas ingresadas anteriormente
            persona = new Persona(ucui, uzona, uhora, uespecifico);
            Zonas zn=new Zonas();
            //Si se puede el registro tendria ahora que agregar personas y no un string --Diego
            // A va! Voy a crear un ArrayList exclusivo para las personas, muchas gracias por avisar :D --Cristian

            // registro.AgregarInformación(info); // Aquí se mandará la información al registro
            registro.AgregarPersona(persona); // Aquí se mandará la persona al historial de personas

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
            System.out.println("La cantidad de personas por zona son:");
            int r;
            r= zonas.dpzonas();
            System.out.println(r);
          }
  

          // System.out.println("Población de la zona: "+zonas.dpzonas());
          //Tambien se debe mostrar la poblacion de la zona--Diego
          
          break;

        //Opcion para salir
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
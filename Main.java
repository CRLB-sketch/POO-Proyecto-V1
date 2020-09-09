// De esto se encargará Diego Sanchez
// Pero no se extrañen si ponemos más de algo aquí (será más que todo para hacer pruebas)

import java.util.Scanner;

class Main {

  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Registro registro = new Registro();

    boolean salir = false;
    do{

      // Esto sera una simulacion en sí y pasaran los días
      System.out.println("1. Guardar info");
      System.out.println("2. Mostrar info");
      System.out.println("3. Salir");
      System.out.println("4. Pasar al siguiente día"); // Todavía no esta listo
      String opcion = scanner.nextLine();

      // No se que más opciones irian, aquí solo dejo esto para probar la clase Registro
      switch(opcion){
        case "1":
          System.out.println("\n----- Guardar info -----");
          System.out.println("Porfavor ingrese la información que desee guardar: ");
          String info = scanner.nextLine();

          registro.AgregarInformación(info); // Yo se que este metodo que esta siendo desarrollado debe de pulirse mucho mejor, solo quise hacerlo funcional para ver si todo esta en orden :)

          break;

        case"2":
          System.out.println("\n----- Mostrar info -----");
  
          System.out.println(registro.MostrarInformacion());
          
          break;

        case "3":
          System.out.println("\nSaliendo....");
          salir = true;
          break;

        default:
          System.out.println("\n-> No ingreso un valor valido");
          break;        
      }

    }while(salir != true);
  }
}
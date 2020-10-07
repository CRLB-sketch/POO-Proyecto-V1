/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Vista (tipo "Vista/Interfaz"): Clase que lleva tiene almacenado todos los mensajes y entrada de usuario </h2>
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

public class Vista{

  // --> Atributo
  private Scanner scanner;
  

  // --> Constructor
  public Vista(){
    scanner = new Scanner(System.in);
  

  }

  // --> Métodos
  public void Bienvenida(){
    System.out.println("Bienvenidos a la simulacion de aglomeraciones en la ciudad de Guatemala");
  }
  
  // Métodos para el menu principal ****************************
  public String menuPrincipal(){
    System.out.println("---------------------------------------------");      
    System.out.println("Ingrese el numero de la opcion que desea: ");
    System.out.println("1. Registrar persona");
    System.out.println("2. Mostrar info");
    System.out.println("3. Admin");
    System.out.println("4. Salir");
    String opcion = scanner.nextLine();

    return opcion;
  }

  // Métodos para la opción 1 de "Registrar Persona"
  public String numeroCUI(){
    System.out.println("\n----- Registrar persona -----");
    System.out.println("Ingrese su numero de CUI: ");
    String ucui = scanner.nextLine();

    return ucui;
  }

  public int zonaEncuentra(){
    System.out.println("Ingrese la zona en la que se encuentra: ");
    int uzona = scanner.nextInt();
    System.out.println("-->Se ingreso correctamente la zona");
    return uzona;      
  }
  
  public double horaActual(){
    System.out.println("Ingrese la hora actual (Formato de 24 horas): ");
    double uhora = scanner.nextDouble();

    return uhora;
  }

  public String lugarEspecifico(){
    System.out.println("Ingrese El lugar especifico: "); 
    String uespecifico = scanner.nextLine();

    return uespecifico;
  }

  public void infoExitosa(){
    System.out.println("\n--> Información almacenada exitosamente :D\n");
  }

  public void error(){
    System.out.println("--> Hey! No debes de ingresar letras en la sección que acabas de ingresar los datos");
  }

  // Métodos para la opción 2 de "Mostrar Info"
  public void datosVacios(){
    System.out.println("--> NO hay datos ingresados todavía");
  }

  public void mostrarInformación(Registro registro){
    System.out.println("______________________________________");
    System.out.println(registro.MostrarInformacion()); // Se mostrará la información registrada
    System.out.println("Cantidad personas registradas: " + registro.PersonasRegistradas());
    System.out.println("______________________________________");
    System.out.println("---> Presiona enter para ver la cantidad de personas por zona <---");
    String enter1 = scanner.nextLine();
    // Se mostrará la cantidad de personas por zona del momento
    System.out.println("La cantidad de personas por zona son:");
  }

  // Métodos para la opción 3 de "Registrar Admin"
  public String aviso(){

    System.out.println("ALERTA! esta sección es solamente para el administrador");
    System.out.println("¿Desea continuar? (s/n)");
    String decision = scanner.nextLine();

    return decision;
  }

  public String pedirContrasena(){
    System.out.println("Administrador porfavor ingrese la contraseña: ");
    String contrasena = scanner.nextLine();

    return contrasena;
  }

  public void rechazado(){
    System.out.println("\n-> Contraseña Incorrecta!");
  }

  public void aceptado(){
    System.out.println("\n-> ADMIN identificado");
  }

  // Método para la opción 4 de "Salir"
  public void salir(){
    System.out.println("\nSaliendo....");
  }

  // Método por sí el usuario no ingresa un valor válido
  public void invalido(){
    System.out.println("\n--> No ingreso un valor valido");
  }
  
  public void darInformacionPorMetodo(int info){
    System.out.println(info);
  }

  public void darInformacionPorMetodo(String info){
    System.out.println(info);
  }

  public void salto(){
    String salto = scanner.nextLine();
  }

  // Estos siguientes métodos será para el menu exclusivo del administrador ***************
  public String menuAdmin(){
    System.out.println("--- Menu Exclusivo Admin ---");
    System.out.println("1. Mostrar datos de registros de personas personas generales");
    System.out.println("2. Mostrar datos de registros de personas personas diarias");
    System.out.println("3. Salir de este menu exclusivo");
    String opcion = scanner.nextLine();

    return opcion;
  }

  // Opción #1 del admin "Mostrar datos de registros de personas generales"
  public void MostrarRegistrosPersonas(Registro registro){
    System.out.println("--- Mostrar datos de registros de personas generales ---");
    
    registro.LecturaGeneral("RegistroGeneral.txt");

  }

  // Opción #2 del admin "Mostrar datos de registros de personas diarias"
  public void MostrarRegistrosPersonas2(Registro registro){
    System.out.println("--- Mostrar datos de registros de personas diarias ---");
    
    registro.LecturaDiario("RegistroDiario.txt");

  }

  // Opción #4 del admin "Para salir de este menu exclusivo"
  public void salirMenuAdmin(){
    System.out.println("\n-> Regresando al menú principal");
  }
}
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

 public class Controlador{
   
   // --> Atributos   
   private Vista v;
   private Registro registro;
   private Zonas zonas;
   private Admin admin;

   // --> Constructor
   public Controlador(){
     v = new Vista(); // Para inicializar vista
     registro = new Registro(); // Para inicializar registro
     zonas = new Zonas(); // Para inicializar las zonas
     admin = new Admin(); // Para tener al admin incluido
   }

   // --> Métodos
   public void menu(){ // Menu prinpal ******************************************************

     Persona persona; // Para tener a la persona/personas que se vayan a crear

     v.Bienvenida(); // Mostar mensaje de bienvenida

     String opcion = "";
     boolean salir = false;
     do{

       opcion = v.menuPrincipal(); // Tendremos la entrada de usuario

       switch(opcion){

         // Opcion 1: "Registrar Persona"
         case "1":         
          // Pondremos un try-catch para evitar errores de entrada de usuario
          try{

            String ucui = v.numeroCUI(); // Para solicitar numero CUI
            int uzona = v.zonaEncuentra();
            double uhora = v.horaActual();
            v.salto();

            String uespecifico = v.lugarEspecifico();

            // Aquí se creará una nueva persona con las caracteristicas ingresadas anteriormente
            persona = new Persona(ucui, uzona, uhora, uespecifico);

            registro.AgregarPersona(persona); // Aquí se mandará la persona al historial de personas y de una vez se creará el registro

            v.infoExitosa(); // Para mostrar el mensaje que la información se agrego exitosamente
          }
          // Por si el usuario ingresa letras en ves de números depende del caso
          catch(Exception e){ 
            v.error();
          }
          break;

        // Opcion 2: "Mostrar Info"
        case "2":
          if(registro.PersonasRegistradas() == 0){
            v.datosVacios(); // Avisaremos que los datos estan vacios
          }else{
            v.mostrarInformación(registro); // Para mostrar todos los datos
            int r;
            r= zonas.dpzonas();
            v.darInformacionPorMetodo(r);
          }
          break;

        // Opcion 3: "Para que el Admin verifique los datos totales"
        case "3":
          String desicion = v.aviso();
          if(desicion.equals("s") || desicion.equals("S")){

            // Se pedira la contraseña al usuario para ver si es el administrador o no
            String contrasena = v.pedirContrasena();
            String verificar = admin.getContrasena(contrasena);
            // Si la contraseña es incorrecta entonces lanzará un mensaje de rechazo
            if(verificar.equals("-> Contraseña Inválida")){
              v.rechazado(); // Mostar mensaje de contraseña incorecta
            }
            // Si la contraseña no es inválida, entonces el Admin ya esta identificado
            else{
              v.aceptado(); // Mostrar mensaje de contraseña correcta

              // Aquí abrirá el menu exclusivo del administrador
              menuAdmin();

              // Por el momento aquí cerrare la "sesion" del Admin
              admin.salir();
            }
          }

          break;

        // Opcion 4: "Salir"
        case "4":
          v.salir();
          salir = true;
          break;

        // Mensaje por sí el usuario selecciona una opción inválida
        default:
          v.invalido();
          break;
       }

     }while(salir != true); // Condicional para que continue o termine el ciclo
   }

  // Para mostrar el método del administrador
  private void menuAdmin(){
    boolean salirMenuAdmin = false;
    do{
      String opcion = v.menuAdmin(); // Para solicitar entrada de usuario

      switch(opcion){
        case "1":
          v.MostrarRegistrosPersonas();
          break;

        case "2":
          v.GuardarApuntes();
          break;

        case "3":
          v.salirMenuAdmin();
          salirMenuAdmin = true;
          break;

        default:
          v.invalido();
          break;
      }
    }while(salirMenuAdmin != true);
  }

  
 }
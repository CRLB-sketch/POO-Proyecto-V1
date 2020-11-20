/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Controlador: Clase que se encarga de la logica principal del programa </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version Final
 * @since 2020
 * 
 */
 
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

 public class Controlador{
   
   // --> Atributos   
   private Vista v;
   private Registro registro;
   private Zonas zonas;
   private Admin admin;
   private Timer timer;

   // --> Constructor
   public Controlador(){
     v = new Vista(); // Para inicializar vista
     registro = new Registro(); // Para inicializar registro
     zonas = new Zonas(); // Para inicializar las zonas
     admin = new Admin(); // Para tener al admin incluido
     timer = new Timer(); //Para el reloj interno
   }

   // --> Métodos
   public void menu(){ // Menu prinpal ******************************************************

     // Aquí se almacenará la cantidad de personas que estan cuando empiece la simulacion
     String mostrarPersonasPorZona = zonas.dpzonas();

     Persona persona; // Para tener a la persona/personas que se vayan a crear

     v.Bienvenida(); // Mostar mensaje de bienvenida

     elTimer(registro);//Para que ejecute el timer

     String opcion = "";
     boolean salir = false;
     do{

       opcion = v.menuPrincipal(); // Tendremos la entrada de usuario

       switch(opcion){

         // Opcion 1: "Registrar Persona"
         case "1":         
          // Pondremos un try-catch para evitar errores de entrada de usuario
          try{

            String ucio_str = "";
            boolean cui_valido = false;
            do {
              // Para solicitar numero CUI
              int ucui = v.numeroCUI(); 
              v.salto();
  
              // Convertir de int a string
              String ucui_cambio = Integer.toString(ucui);
              ucio_str = ucui_cambio;
              cui_valido = true;
              
            } while (cui_valido != true);
            
            // Para solicitar zona y se verificará si la zona es válida o no
            int uzona = 0;
            boolean zonaValida = false;
            while(zonaValida != true){
              int la_zona = v.zonaEncuentra();
              if(la_zona < 22 && la_zona > 0){
                zonaValida = true;
                v.zonavalido();
                uzona = la_zona;
              }
              else{
                v.zonainvalido();
              }
            }

            //Método para solcitar horas con programación defensiva             
            double hora_final = 0;
            boolean correcto = false;
            do {
              
              double entrada = v.horaActual();
              // Para verificar formato de horas
              if(entrada < 24 && entrada > 0){
                double d = entrada;
                short[] digitos = new short[2];
                double temp = d - ((int) d) + 0.5 * 1e-10;
                for (int i = 0; i < digitos.length && temp != 0; i++)
                {
                  temp *= 10;
                  digitos[i] = (short) temp;
                  temp -= (int) temp;
                }
                
                // Para verificar los digitos
                String cadena = "";
                for (short s : digitos) {            
                  cadena += s;
                }
                
                int minutos = Integer.parseInt(cadena);
                // Para verificar formato de minutos
                if(minutos >= 60){
                  v.horainvalido();                
                }
                else{                    
                  v.horavalido();
                  correcto = true;              
                  hora_final = entrada;
                }
              }
              else{
                v.horainvalido();                
              }
              
            } while (correcto != true);
               
            v.salto();

            String uespecifico = v.lugarEspecifico();

            // Aquí se creará una nueva persona con las caracteristicas ingresadas anteriormente
            persona = new Persona(ucio_str, uzona, hora_final, uespecifico);

            registro.AgregarPersona(persona); // Aquí se mandará la persona al historial de personas y de una vez se creará el registro
            
            registro.CrearRegistroG(persona);//crea el registro general
            registro.CrearRegistroD(persona);//crea el registro diario

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
          }
          break;
       
        // Opcion 3: "Para que el usuario pueda ver las persnas por zona y las alertas que hay depende de la gente que hay"
        case "3":
          v.mostrarGeneral();
          // Vamos a mostrar la información de las persoans que estan en el método
          v.darInformacionPorMetodo(mostrarPersonasPorZona);
          break;  

        // Opcion 4: "Para que el Admin verifique los datos totales"
        case "4":
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

        // Opcion 5: "Salir"
        case "5":
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
          v.MostrarRegistrosPersonas(registro);
          break;

        case "2":
          v.MostrarRegistrosPersonas2(registro);
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

  // Esto nos ayudará a borrar los datos despues e un cierto tiempo
  public void elTimer(Registro registro){

    TimerTask task = new TimerTask() {
    
    @Override
    public void run()
    {          
      registro.limpiarRegistro();
    }
    };            
    timer.schedule(task, 43200000, 43200000);

  }
  
 }
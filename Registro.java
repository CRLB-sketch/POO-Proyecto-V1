/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Registro </h2>
 * 
 * Estaa clase se encargará de mantener el registro de todos los datos
 * solicitados y también se encargará de manejar las probabilidades.
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 1.0
 * @since 2020
 * 
 */

// Vamos a importar el paquete para usar ArrayList
import java.util.ArrayList;

// Aquí estará el encabezado

public class Registro{
  // --> Atributos  
  private ArrayList<Persona> personas; 
  private ArrayList<String> registro;  

  // --> Constructores
  public Registro(){
    personas = new ArrayList<Persona>();
    registro = new ArrayList<String>();
  }

  // --> Getters
  public ArrayList<String> getRegistro(){
    return registro;
  }

  // --> Metodos
  // Este método es para agregar a la persona en el historial de personas
  public void AgregarPersona(Persona p){
    personas.add(p); // Se agregará a la persona al listado de personas

    String informacion = "Persona CUI: " + p.getCui() + "\n" +
                         "Zona: " + p.getZona() + "\n" +
                         "Hora: " + p.getHora() + "\n" +
                         "Lugar Específico: " + p.getLugarEspecifico() + "\n" +
                         "______________________________________";

    // Se agregará la información en el registro de información
    AgregarInformacion(informacion);
  }

  // Este metodo es para agregar la información al registro
  private void AgregarInformacion(String info){ 

    registro.add(info); // Se almacenará la información solicitada
  }

  // Este metodo es para mostrar la información almacenada
  public String MostrarInformacion(){
    String info = "";

    // Se mostrará el listado de todos los registros
    for(String i: registro){
      info += "-> " + i + "\n";
    }

    return info;
  }

  // Este método es para mantener el control de las personas que han sido registradas
  public int PersonasRegistradas(){
    int cantidad = personas.size();
    return cantidad;
  }

}
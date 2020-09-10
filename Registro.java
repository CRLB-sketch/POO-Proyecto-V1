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
  // private ArrayList<Persona> personas;
  private ArrayList<String> registro;  

  // --> Constructores
  public Registro(){
    // personas = new ArrayList<Persona>();
    registro = new ArrayList<String>();
  }

  // --> Getters
  public ArrayList<String> getRegistro(){
    return registro;
  }

  // --> Metodos
  // Este metodo es para agregar la información al registro
  public void AgregarInformación(String info){ 
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

  public void AgregarProbabilidad(){

    // Agregar probibilidad de un lugar que no existe


  }

  public String ObtenerProbabilidad(String zona, String horario, String lugar_especifico){
    String info = "";

    // Vamos a poner las operaciones correspondientes

    // Evaluar lo que la persona ya metio.
    // Tenemos control del lugar en donde el usuario quiere ir.
    // Este metodo se encargará de avisar la probabilidad de contagio por covid o decir que el contagio.
    // Si no existe el lugar el programa lo tomará en cuenta.

    return info;
  }

  public void LimpiarRegistros(){
    
  }

}
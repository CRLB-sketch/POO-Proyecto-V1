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

  // --> Setters

  // --> Metodos
  public void AgregarInformación(String info){
    registro.add(info);
  }

  public String MostrarInformacion(){
    String info = "";

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
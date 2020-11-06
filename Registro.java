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
 * @version 2.0
 * @since 2020
 *
 */

// Vamos a importar el paquete para usar ArrayList
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;//Librerias varias que ayudaran a los registros y mantener la informacion

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

  public void CrearRegistroG(Persona p){
    File f;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr;
    String nombre="RegistroGeneral.txt";
    int zn=p.getZona();
    double hr=p.getHora();
    String zona= String.valueOf(zn);
    String hora= String.valueOf(hr);

    try {
      f=new File(nombre);
      w=new FileWriter(f);
      bw=new BufferedWriter(w);
      wr=new PrintWriter(bw);

      wr.write(p.getCui());
      wr.append(" ");
      wr.append(zona);
      wr.append(" ");
      wr.append(hora);
      wr.append(" ");
      wr.append(p.getLugarEspecifico());
      wr.println();

      wr.close();
      bw.close();
    } catch(Exception e) {

    }
  }  //Será el método que mantendrá los registros registrados como archivos de texto

  public void CrearRegistroD(Persona p){
    File f;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr;
    String nombre="RegistroDiario.txt";
    int zn=p.getZona();
    double hr=p.getHora();
    String zona= String.valueOf(zn);
    String hora= String.valueOf(hr);

    try {
      f=new File(nombre);
      w=new FileWriter(f);
      bw=new BufferedWriter(w);
      wr=new PrintWriter(bw);

      wr.write(p.getCui());
      wr.append(" ");
      wr.append(zona);
      wr.append(" ");
      wr.append(hora);
      wr.append(" ");
      wr.append(p.getLugarEspecifico());
      wr.println();

      wr.close();
      bw.close();
    } catch(Exception e) {

    }
  } //registro diario

  //Método para leer el archivo txt de los registros generales
  public void LecturaGeneral (String Archivo){
    File arch;
    FileReader leer;
    BufferedReader br;

    try {
      arch = new File(Archivo);
      leer = new FileReader(arch);
      br = new BufferedReader(leer);

      String linea;
      while ((linea= br.readLine()) != null){

      
        System.out.print(linea);
      }

      br.close();
      leer.close();

    } catch(Exception e){

      JOptionPane.showMessageDialog(null, "Hubo un error para leer el archivo" + e);

    }

  }
//Método para leer el archivo txt de los registros diarios
  public void LecturaDiario (String Archivo){
    File arch;
    FileReader leer;
    BufferedReader br;

    try {
      arch = new File(Archivo);
      leer = new FileReader(arch);
      br = new BufferedReader(leer);

      String linea;
      while ((linea= br.readLine()) != null){
        System.out.print(linea);
      }

      br.close();
      leer.close();



    } catch(Exception e){

      JOptionPane.showMessageDialog(null, "Hubo un error para leer el archivo" + e);

    }

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

  // Este método es para limpiar datos "Específicamente para el registro diario"
  public void limpiarRegistro(){
    try{
      BufferedWriter bw = new BufferedWriter(new FileWriter("RegistroDiario.txt"));

      bw.write("");
      bw.close();
      
    }catch(Exception e){
      return;
    }
  }
}
/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Zonas: Clase que lleva el registro de simulación de personas en cada zona y le suma a la zona cada nuevo registro </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 3.0
 * @since 2020
 * 
 */

import java.util.*;
import java.util.Random;

public class Zonas{
  
  // --> Atributos
  private int zonas; //variable para la zona de ingreso
  private Random rand; //objeto random; 

  // --> Constructor
  public Zonas(){
    zonas = 1;
    rand = new Random();//objeto random;
  }

  // --> Getter
  public int getZonas(){
    return zonas;
  }

  // --> Métodos   
  public String dpzonas(){
    String info = "";
    
    int[] zonas = new int [21]; 
    for(int i=0;i<zonas.length ; i++){ 
      int rand_int = rand.nextInt(1000); // Personas Max
      zonas[i]= rand_int;
      String color = this.obtenerAvisoPorColor(zonas[i]);
      info += "\n--------------------------------";
      info += "\nZona " + (i+1) + ": " + color;
      info += "\n-> Cantidad Personas: " + zonas[i];      
      float porcentaje = probabilidadContagio(zonas[i]);
      info += "\n-> Probabilidad Contagio: " + porcentaje + "%";
    }

    return info;
  }

  // Metodos para mandar los avisos de colores
  private String obtenerAvisoPorColor(int personas){ // personas refleja la personas de personas
    String info = "";

    if(personas <= 100){
      info += ("\u001B[32m" + "Verde" + "\u001B[0m");
    }
    else if(personas >= 101 && personas <= 600){
      info += ("\u001B[33m" + "Amarillo" + "\u001B[0m");
    }
    else{
      info += ("\u001B[31m" + "Rojo" + "\u001B[0m");
    }
    
    return info;
  }

  //Metodo que muestra la probabilidad de contagio en la zona
  private float probabilidadContagio(int personas){

    float porcentajeFinal = (float)((personas*100)/1000);

    return porcentajeFinal;
  }
  
}
/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Zonas: Clase que lleva el registro de simulación de personas en cada zona y le suma a la zona cada nuevo registro </h2>
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 2.0
 * @since 2020
 * 
 */

import java.util.*;
import java.util.Random;
//import java.util.ArrayList;

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

  // --> Método
  public int dpzonas(){
    int n=0;
    int[] zonas = new int [21]; 
    for(int i=0;i<zonas.length ; i++){ 
      int rand_int = rand.nextInt(1000);
      zonas[i]= rand_int;
      System.out.println("Zona " + (i+1) + ":");
      System.out.println(zonas[i]);
      }
    return n;
  }
  
}
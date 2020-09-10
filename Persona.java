/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> NombreClase (Pequeña descripción de que clase es) </h2>
 * 
 * Escribir aquí una breve explicación de lo que realizará esta clase en específico
 * Escribir aquí una breve explicación de lo que realizará esta clase en específico
 * Escribir aquí una breve explicación de lo que realizará esta clase en específico
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version 1.0
 * @since 2020
 * 
 */

class Persona{
  // --> Atributos
	private String cui;       
	private int zona;
	private double hora;
	private String lugar_especifico;
	
	
	// --> Constructor
  public Persona(){
    this.cui = "";
    this.zona = "";
    this.hora = 0;
    this.lugar_especifico = "";
  }

  // Sobrecarga del constructor
	public Persona(String cui, int zona, double hora, String lugar_especifico){ 
		this.cui = cui;
    this.zona = zona;
    this.hora = hora;
    this.lugar_especifico = lugar_especifico;
	}
	
	// --> Getters
	public String getCui(){
		return cui;
		
	}
	public int getZona(){
		return zona;
	}

	public double getHora(){
		return hora;		
	}
	
	public String getLugarEspecífico(){
		return lugar_especifico;
	}
	
	// --> Setters
	public void setCui(String cui){
    this.cui = cui;
	}
	
	public void setZona(int zona){
    this.zona = zona;
	}
	
	public void setHora(double hora){
    this.hora = hora;
  }
	
	public void setLugarEspecífico(String lugar_especifico){
    this.lugar_especifico = lugar_especifico;
	}
	
  // --> Metodos
	public String PersonaAlRegistro(){ // talvez no

    
		return "";
	}		
 }
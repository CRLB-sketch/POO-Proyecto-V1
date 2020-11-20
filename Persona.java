/**
 * <h1> Proyecto POO - Entrega #2 | Programa que maneja las aglomeraciones por COVID-19 </h1>
 * <h2> Persona </h2>
 * 
 * Esta clase representará a una persona y tendrá sus datos correspondientes
 * 
 * <p>Programación orientada a Objetos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author ["Cristian Laynez", "Elean Rivas", "Lucía Samayoa", "Magdalena Esquina", "Dieter Loesener", "Diego Sanchez"]
 * @version Final
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
    this.zona = 0;
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
	
	// --> Getters de información
	public String getCui(){
		return cui;
		
	}
	public int getZona(){
		return zona;
	}

	public double getHora(){
		return hora;		
	}
	
	public String getLugarEspecifico(){
		return lugar_especifico;
	}
	
	// --> Setters de información
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

  @Override
  public String toString(){
    String string_nuevo = "";

    string_nuevo += "\nCui: " + cui;
    string_nuevo += "\nZona: " + zona;
    string_nuevo += "\nHora: " + hora;
    string_nuevo += "\nLugar específico: " + lugar_especifico;
    
    return string_nuevo;
  }
}
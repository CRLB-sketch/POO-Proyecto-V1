class Persona{
  // --> Atributos
	private String cui;       
	private String zona;
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
	public Persona(String cui, String zona, double hora, String lugar_especifico){ 
		this.cui = cui;
    this.zona = zona;
    this.hora = hora;
    this.lugar_especifico = lugar_especifico;
	}
	
	// --> Getters
	public String getCui(){
		return cui;
		
	}
	public String getZona(){
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
	
	public void setZona(String zona){
    this.zona = zona;
	}
	
	public void setHora(double hora){
    this.hora = hora;
  }
	
	public void setLugarEspecífico(String lugar_especifico){
    this.lugar_especifico = lugar_especifico;
	}
	
  // --> Metodos
	public int PersonaAlRegistro(){
		return 0;
	}		
 }
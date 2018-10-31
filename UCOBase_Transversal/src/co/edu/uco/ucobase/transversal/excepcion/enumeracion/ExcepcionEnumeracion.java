package co.edu.uco.ucobase.transversal.excepcion.enumeracion;

public  enum ExcepcionEnumeracion {
	
	DATOS ("DATOS","Excepcion presentada en la capa de datos"),
	NEGOCIO("NEGOCIO","Excepcion presentada en la capa de negocio"), 
	FACHADA("FACHADA","Excepcion presentada en la capa de fachada"), 
	API("API","Excepcion presentada en el api"), 
	DTO("DTO","Excepcion presentada en la capa de Dto"), 
	DOMINIO("DOMINIO","Excepcion presentada en la capa de dominio"), 
	GENERAL("GENERAL","Excepcion presentada en la capa general");
	
	private String codigo;
	private String nombre;
	
	private ExcepcionEnumeracion(final String codigo,final  String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}

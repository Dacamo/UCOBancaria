package co.edu.ucobancaria.dto;
import static co.edu.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;

/*
 * Objeto de transferencia de datos que representa 
 * a un tipo de cuenta 
 * */

public final class TipoCuentaDTO {

	private int codigo;
	private String nombre;
	
	public TipoCuentaDTO () {
		super();
	}
	
	public  TipoCuentaDTO(int codigo, String nombre) {
		super();
		setCodigo(codigo); 
		setNombre(nombre);
	}


	public final int getCodigo() {
		return codigo;
	}


	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public final String getNombre() {
		return nombre;
	}


	public final void setNombre(String nombre) {
		this.nombre = obtenerUtilTexto().aplicarTrim(nombre);
	}
	
	
	
	
	
}

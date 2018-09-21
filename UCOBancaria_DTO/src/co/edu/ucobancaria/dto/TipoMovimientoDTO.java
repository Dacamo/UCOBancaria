package co.edu.ucobancaria.dto;

import co.edu.ucobase.transversal.objeto.UtilObjeto;

/**
 * objeto de transferencia de datos que representa a un movimiento o de transaccion 
 * realizada sobre una cuenta
 * @author usuario.edc
 *
 */

public final class TipoMovimientoDTO {
	
	private int codigo;
	private String nombre;
	private String signo;
	
	public TipoMovimientoDTO () {
		super();
	}
	
	public TipoMovimientoDTO(int codigo, String nombre, String signo) {
		super();
		setCodigo(codigo); 
		setNombre(nombre); 
		setSigno(nombre); 
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(nombre, "");
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	
	
}

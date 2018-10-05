package co.edu.uco.ucobase_transversal.excepcion.excepcion;

import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;

public final class AplicacionExcepcion extends RuntimeException {

	/**
	 * Serial version por defecto de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Exception excepcionRaiz;
	private boolean existeExcepcionRaiz;
	private ExcepcionEnumeracion lugarExpcecion;
	
	
	
	private AplicacionExcepcion(final String mensajeTecnico, final String mensajeUsuario, final Exception excepcionRaiz,
			 final boolean existeExcepcionRaiz, final ExcepcionEnumeracion lugarExpcecion) {
		super();
		setMensajeTecnico(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setExcepcionRaiz(excepcionRaiz);
		setExcepcionRaiz(excepcionRaiz);
		setExisteExcepcionRaiz(existeExcepcionRaiz);
		
		
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	private final void setExcepcionRaiz(final Exception excepcionRaiz) {
		this.excepcionRaiz = excepcionRaiz;
	}
	private final void setExisteExcepcionRaiz(final boolean existeExcepcionRaiz) {
		this.existeExcepcionRaiz = existeExcepcionRaiz;
	}
	private final void setLugarExpcecion(final ExcepcionEnumeracion lugarExpcecion) {
		this.lugarExpcecion = lugarExpcecion;
	}
	
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}
	public final boolean isExisteExcepcionRaiz() {
		return existeExcepcionRaiz;
	}
	public final ExcepcionEnumeracion getLugarExpcecion() {
		return lugarExpcecion;
	}
	
	
	
	

}

package co.edu.uco.ucobase_transversal.excepcion.excepcion;

import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
//import co.edu.ucobase.transversal.cadenas.UtilTexto;
import co.edu.ucobase.transversal.objeto.UtilObjeto;

import static co.edu.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;
import static co.edu.ucobase.transversal.objeto.UtilObjeto.obtenerUtilObjeto;

import java.nio.charset.MalformedInputException;


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
			  final ExcepcionEnumeracion lugarExpcecion) {
		super();
		setMensajeTecnico(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setExcepcionRaiz(excepcionRaiz);
		setExcepcionRaiz(excepcionRaiz);
		
		
			}
	
	
	public static AplicacionExcepcion CREAR(final String mensajeTecnico, final String mensajeUsuario, final Exception excepcionRaiz,
			  final ExcepcionEnumeracion lugarExpcecion) {
		return new AplicacionExcepcion(mensajeTecnico, mensajeUsuario, excepcionRaiz,  lugarExpcecion);
		
	}
	
	public static AplicacionExcepcion CREAR(final  String mensajeUsuario) {
		return new AplicacionExcepcion(null, mensajeUsuario, null,  null);
		
	}
	
	
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = obtenerUtilTexto().aplicarTrim(mensajeTecnico);
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = obtenerUtilTexto().aplicarTrim(mensajeUsuario);
	}
	
	//si llega nula es porque no se la mandaron (no existe)
	private final void setExcepcionRaiz(final Exception excepcionRaiz) {
		setExisteExcepcionRaiz(obtenerUtilObjeto().objetoEsNulo(excepcionRaiz));
		this.excepcionRaiz= UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(excepcionRaiz, new Exception());
		
		
	}
	private final void setExisteExcepcionRaiz(final boolean existeExcepcionRaiz) {
		this.existeExcepcionRaiz = existeExcepcionRaiz;
	}
	private final void setLugarExpcecion(final ExcepcionEnumeracion lugarExpcecion) {
		this.lugarExpcecion = obtenerUtilObjeto().obtenerValorDefecto(lugarExpcecion, ExcepcionEnumeracion.GENERAL);
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
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AplicacionExcepcion.CREAR("Mensaje de error de usuario");
		} catch (AplicacionExcepcion excepcion) {
			System.out.println(excepcion.getMensajeTecnico());
		}
	}
	*/
	
	
	
	

}

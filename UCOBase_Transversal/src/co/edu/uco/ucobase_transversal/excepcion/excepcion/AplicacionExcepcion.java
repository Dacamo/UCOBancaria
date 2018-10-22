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
	private ExcepcionEnumeracion lugarExcepcion;
	
	
	
	private AplicacionExcepcion(final String mensajeTecnico, final String mensajeUsuario, final Exception excepcionRaiz,
			  final ExcepcionEnumeracion lugarExpcecion) {
		super();
		setMensajeTecnico(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setExcepcionRaiz(excepcionRaiz);
		setLugarExpcecion(lugarExpcecion);
		
		
			}
	
	public static AplicacionExcepcion CREAR(final String mensajeTecnico, final String mensajeUsuario, final Exception excepcionRaiz, final ExcepcionEnumeracion lugarExcepcion) {
		return new AplicacionExcepcion(mensajeTecnico, mensajeUsuario, excepcionRaiz, lugarExcepcion);
	}

	public static AplicacionExcepcion CREAR(final String mensajeUsuario, final Exception excepcionRaiz, final ExcepcionEnumeracion lugarExcepcion) {
		return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, excepcionRaiz, lugarExcepcion);
	}

	public static AplicacionExcepcion CREAR(final String mensajeTecnico, final String mensajeUsuario, final ExcepcionEnumeracion lugarExcepcion) {
		return new AplicacionExcepcion(mensajeTecnico, mensajeUsuario, null, lugarExcepcion);
	}

	public static AplicacionExcepcion CREAR(final String mensajeUsuario, final ExcepcionEnumeracion lugarExcepcion) {
		return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, null, lugarExcepcion);
	}

	public static AplicacionExcepcion CREAR(final String mensajeUsuario) {
		return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, null, null);
	}
	
	
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = obtenerUtilTexto().aplicarTrim(mensajeTecnico);
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = obtenerUtilTexto().aplicarTrim(mensajeUsuario);
	}
	
	//si llega nula es porque no se la mandaron (no existe)
	private final void setExcepcionRaiz(final Exception excepcionRaiz) {
		setExisteExcepcionRaiz(!obtenerUtilObjeto().objetoEsNulo(excepcionRaiz));
		this.excepcionRaiz= UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(excepcionRaiz, new Exception());
		
		
	}
	private final void setExisteExcepcionRaiz(final boolean existeExcepcionRaiz) {
		this.existeExcepcionRaiz = existeExcepcionRaiz;
	}
	private final void setLugarExpcecion(final ExcepcionEnumeracion lugarExpcecion) {
		this.lugarExcepcion = obtenerUtilObjeto().obtenerValorDefecto(lugarExpcecion, ExcepcionEnumeracion.GENERAL);
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
		return lugarExcepcion;
	}
	
	/*public static void main(String[] args) {
		try {
			throw AplicacionExcepcion.CREAR("mensaje de error tecnico","mensaje de error de usuario",
					new Exception("Hubo error"),
					ExcepcionEnumeracion.API);
		} catch (AplicacionExcepcion excepcion) {
			System.out.println(excepcion.mensajeTecnico);
			System.out.println(excepcion.mensajeUsuario);
			System.out.println(excepcion.getExcepcionRaiz());
			System.out.println(excepcion.isExisteExcepcionRaiz());
			System.out.println(excepcion.lugarExcepcion.getNombre());
		}
	}*/
	
	
	
	
	

}

package co.edu.ucobancaria.dominio;

import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase_transversal.excepcion.excepcion.AplicacionExcepcion;

public final class ClienteDominio {
	private int codigo;
	private String numeroIdentificacion;
	private String nombre;
	private String correo;
	private String clave;
	
	
	public ClienteDominio(final int codigo, final String numeroIdentificacion, final String nombre, final String correo, 
			final String clave) {
		super();
		setCodigo(codigo);
		setNumeroIdentificacion(numeroIdentificacion);
		setClave(clave);
		setCorreo(correo);
		setNombre(nombre);
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public String getClave() {
		return clave;
	}
	
	
	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	private final  void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	private final void setCorreo(final String correo) {
		this.correo = correo;
	}
	private final void setClave(final String clave) {
		this.clave = clave;
	}
	
	//validaciones para integridad de los datos.
	
	private void asegurarIntegridadCodigo() {
		if(getCodigo()<=0) {
			String mensaje= "El codigo de un cliente debe ser mayor a 0";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadnumeroIdentificacion() {
		if(getNumeroIdentificacion()==null) {
			String mensaje= "El numero Identificacion de un cliente No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNumeroIdentificacion().trim().intern()=="") {
			String mensaje= "El numero Identificacion de un Cliente no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNumeroIdentificacion().trim().length()>50) {
			String mensaje= "El numero Identificacion de un cliente no puede tener m·s de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNumeroIdentificacion().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
			String mensaje= "El numero Identificacion de un cliente solo puede tener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadNombre() {
		if(getNombre()==null) {
			String mensaje= "El nombre de un cliente No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNombre().trim().intern()=="") {
			String mensaje= "El nombre de un Cliente no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNombre().trim().length()>250) {
			String mensaje= "El nombre de un cliente no puede tener m·s de 250 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNombre().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
			String mensaje= "El nombre de un cliente solo puede tener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	
	

}

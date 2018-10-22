package co.edu.ucobancaria.dominio;
import static co.edu.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;

import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase_transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobase.transversal.dominio.enumeracion.OperacionEnum;

public final class ClienteDominio {
	private int codigo;
	private String numeroIdentificacion;
	private String nombre;
	private String correo;
	private String clave;
	private OperacionEnum operacion;
	
	private ClienteDominio(final int codigo, final String numeroIdentificacion, final String nombre, final String correo, 
			final String clave, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setNumeroIdentificacion(numeroIdentificacion);
		setClave(clave);
		setCorreo(correo);
		setNombre(nombre);
		setOperacion(operacion);
	}
	
	public final static ClienteDominio CREAR(final int codigo,final String numeroIdentificacion,
			final String nombre, final String correo, final String clave, final OperacionEnum operacion) {

		final ClienteDominio retorno = new ClienteDominio(codigo, numeroIdentificacion,nombre,correo, clave, operacion);
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadnumeroIdentificacion();
			retorno.asegurarIntegridadClave();
			retorno.asegurarIntegridadCorreo();
			
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadnumeroIdentificacion();
			retorno.asegurarIntegridadClave();
			retorno.asegurarIntegridadCorreo();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			
			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNumeroIdentificacion())) {
				retorno.asegurarIntegridadnumeroIdentificacion();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNombre())) {
				retorno.asegurarIntegridadNombre();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getCorreo())) {
				retorno.asegurarIntegridadCorreo();
			}
			break;
		default:
			String mensaje = "El objeto Tipo Cliente no se puede crear, debido a que la operaciÛn para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}

		return retorno;
	}

	
	public final int getCodigo() {
		return codigo;
	}
	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public final String getNombre() {
		return nombre;
	}
	public final String getCorreo() {
		return correo;
	}
	public final String getClave() {
		return clave;
	}
	
	public final OperacionEnum getOperacion() {
		return operacion;
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
	private void setOperacion(OperacionEnum operacion) {
		this.operacion = operacion;
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
	
	private void asegurarIntegridadCorreo() {
		if(getCorreo()==null) {
			String mensaje= "El correo de un cliente No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getCorreo().trim().intern()=="") {
			String mensaje= "El correo de un Cliente no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getCorreo().trim().length()>50) {
			String mensaje= "El correo de un cliente no puede tener m·s de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (!getCorreo().trim().matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
      "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")) {
			String mensaje= "El correo de un cliente no es v·lido";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadClave() {
		if(getClave()==null) {
			String mensaje= "La clave de un cliente No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getClave().trim().intern()=="") {
			String mensaje= "La clave de un Cliente no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getClave().trim().length()>50) {
			String mensaje= "La clave de un cliente no puede tener m·s de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getClave().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
			String mensaje= "El nombre de un cliente solo puede tener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	
	

}

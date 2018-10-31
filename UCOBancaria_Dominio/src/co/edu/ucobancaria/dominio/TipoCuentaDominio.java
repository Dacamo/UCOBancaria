package co.edu.ucobancaria.dominio;

import co.edu.uco.ucobase.transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.uco.ucobase.transversal.dominio.enumeracion.OperacionEnum;

public final class TipoCuentaDominio {
	
	private int codigo;
	private String nombre;
	private OperacionEnum operacion;
	
	private TipoCuentaDominio(final int codigo, final String nombre, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setOperacion(operacion);
	}
	
	public static TipoCuentaDominio CREAR(final int codigo, final String nombre, final OperacionEnum operacion ) {
		final TipoCuentaDominio retorno = new TipoCuentaDominio(codigo, nombre, operacion);
		
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			break;
		case ACTUALIZAR:
			
			break;	
		case CONSULTAR:
			if(retorno.getCodigo()>0) {
				retorno.asegurarIntegridadCodigo();
			}
			if(retorno.getNombre() != null && retorno.getNombre().trim().intern() != "") {
				retorno.asegurarIntegridadNombre();
			}
			
			
			break;
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			
			break;
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadNombre();
			
			break;	
			
		case DEPENDENCIA:
			retorno.asegurarIntegridadCodigo();
			break;
		default:
			String mensaje ="el objeto tipo cuenta no se puede crear, debido a que la operacion a validar su integridad no existe ";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			
		}
		return retorno;
	}
	
	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = operacion;
	}
	public final int getCodigo() {
		return codigo;
	}
	public final String getNombre() {
		return nombre;
	}
	public final OperacionEnum getOperacion() {
		return operacion;
	}

	//validaciones de la integridad de los atributos
		private void asegurarIntegridadCodigo() {
			if(getCodigo()<=0) {
				String mensaje= "El codigo de un Tipo de cuenta debe ser mayor a 0";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}
		}
		private void asegurarIntegridadNombre() {
			if(getNombre()==null) {
				String mensaje= "El nombre de un tipo de movimiento No puede ser nulo";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}else if(getNombre().trim().intern()=="") {
				String mensaje= "El nombre de un Tipo de cuenta No puede estar vacio";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}else if(getNombre().trim().length()>250) {
				String mensaje= "El nombre de un tTipo de cuenta No puede tener m·s de 250 caracteres";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}else if (getNombre().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
				String mensaje= "El nombre de un Tipo de cuenta solo puede contener letras y espacios";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}
			
		}
}

	




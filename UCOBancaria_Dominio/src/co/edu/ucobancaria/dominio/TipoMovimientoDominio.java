package co.edu.ucobancaria.dominio;


import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase_transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobase.transversal.dominio.enumeracion.OperacionEnum;

public final class TipoMovimientoDominio {
	private int codigo;
	private String nombre;
	private String signo;
	private OperacionEnum operacion;
	
	private TipoMovimientoDominio(final int codigo, final String nombre, final String signo, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setSigno(signo);
		setOperacion(operacion);
	}
	
	public static TipoMovimientoDominio CREAR(final int codigo, final String nombre, final String signo, final OperacionEnum operacion ) {
		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(codigo, nombre, signo, operacion);
		
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadSigno();
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
			
			if(retorno.getSigno()!= null && retorno.getSigno().trim().intern() != "") {
				retorno.asegurarIntegridadSigno();
			}
			break;
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			
			break;
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadNombre();
			retorno.asegurarIntegridadSigno();
			break;	
			
		case DEPENDENCIA:
			retorno.asegurarIntegridadCodigo();
			break;
		default:
			String mensaje ="el objeto tipo movimiento no se puede crear, debido a que la operacion a validar su integridad no existe ";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			
		}
		
		return retorno;
	}
	
	/*public static TipoMovimientoDominio CREAR_PARA_CREAR(final int codigo, final String nombre, final String signo) {
		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(0, nombre,signo);
		retorno.asegurarIntegridadNombre();
		retorno.asegurarIntegridadSigno();
		return retorno;
	}*/
	
	public static TipoMovimientoDominio CREAR_PARA_ACTUALIZAR(final int codigo, final String nombre, 
			final String signo, final OperacionEnum operacion) {
		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(codigo, nombre,signo, operacion );
		retorno.asegurarIntegridadCodigo();
		retorno.asegurarIntegridadNombre();
		retorno.asegurarIntegridadSigno();
		return retorno;
	}
	
	public static TipoMovimientoDominio CREAR_PARA_CONSULTAR(final int codigo, final String nombre,
			final String signo, final OperacionEnum operacion) {
		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(codigo, nombre,signo, operacion);
		retorno.asegurarIntegridadCodigo();
		retorno.asegurarIntegridadNombre();
		retorno.asegurarIntegridadSigno();
		return retorno;
	}
	
	public static TipoMovimientoDominio CREAR_PARA_ELIMINAR(final int codigo, final OperacionEnum operacion) {
		final TipoMovimientoDominio retorno = new TipoMovimientoDominio(codigo, null, null, operacion);
		retorno.asegurarIntegridadCodigo();
		return retorno;
	}
	

	public OperacionEnum getOperacion() {
		return operacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSigno() {
		return signo;
	}

	private void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	private void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private void setSigno(final String signo) {
		this.signo = signo;
	}
	
	
	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = operacion;
	}

	//validaciones de la integridad de los atributos
	private void asegurarIntegridadCodigo() {
		if(getCodigo()<=0) {
			String mensaje= "El codigo de un tipo de movimiento debe ser mayor a 0";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	private void asegurarIntegridadNombre() {
		if(getNombre()==null) {
			String mensaje= "El nombre de un tipo de movimiento No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNombre().trim().intern()=="") {
			String mensaje= "El nombre de un tipo de movimiento No puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNombre().trim().length()>250) {
			String mensaje= "El nombre de un tipo de movimiento No puede tener m·s de 250 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNombre().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
			String mensaje= "El nombre de un tipo de movimiento solo puede contener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
		
		
	}
	
	private void asegurarIntegridadSigno() {
		if(getSigno()==null) {
			String mensaje= "El signo de un tipo de movimiento No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getSigno().trim().intern()=="") {
			String mensaje= "El signo de un tipo de movimiento No puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNombre().trim().intern() != "+" || getSigno().trim().intern() != "-" ) {
			String mensaje= "El signo de un tipo de movimiento solo puede tener (+) o (-)";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNombre().trim().matches("^[+-]+$")) {
			String mensaje= "El signo de un tipo de movimiento solo puede tener (+) o (-)";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
		
	}
	


}

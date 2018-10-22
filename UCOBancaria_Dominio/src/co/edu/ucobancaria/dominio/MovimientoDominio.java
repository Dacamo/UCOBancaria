package co.edu.ucobancaria.dominio;

import static co.edu.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;

import java.util.Date;

import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase_transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobase.transversal.dominio.enumeracion.OperacionEnum;

public final class MovimientoDominio {
	private int codigo;
	private Date fecha;
	private TipoMovimientoDominio tipoMovimiento;
	private CuentaDominio cuenta;
	private double valor;
	private String Comentario; 
	private OperacionEnum operacion;
	
	private MovimientoDominio(int codigo, Date fecha, TipoMovimientoDominio tipoMovimiento, CuentaDominio cuenta,
			double valor, String comentario, OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setComentario(comentario);
		setCuenta(cuenta);
		setFecha(fecha);
		setOperacion(operacion);
		setTipoMovimiento(tipoMovimiento);
		setValor(valor);
	}
	
	public final static MovimientoDominio CREAR(int codigo, Date fecha, TipoMovimientoDominio tipoMovimiento, CuentaDominio cuenta,
			double valor, String comentario, OperacionEnum operacion) {

		final MovimientoDominio retorno = new MovimientoDominio(codigo, fecha, tipoMovimiento, cuenta, valor, comentario, operacion);
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadCuentaDominio();
			retorno.asegurarIntegridadTipoMovimiento();
			
			
			
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadCuentaDominio();
			retorno.asegurarIntegridadTipoMovimiento();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			
			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getCuenta().toString())) {
				retorno.asegurarIntegridadCuentaDominio();;
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getTipoMovimiento().toString())) {
				retorno.asegurarIntegridadTipoMovimiento();
			}

			
			break;
		default:
			String mensaje = "El objeto Cuenta no se puede crear, debido a que la operación para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}

		return retorno;
	}
	public final int getCodigo() {
		return codigo;
	}
	public final Date getFecha() {
		return fecha;
	}
	public final TipoMovimientoDominio getTipoMovimiento() {
		return tipoMovimiento;
	}
	public final CuentaDominio getCuenta() {
		return cuenta;
	}
	public final double getValor() {
		return valor;
	}
	public final String getComentario() {
		return Comentario;
	}
	public final OperacionEnum getOperacion() {
		return operacion;
	}
	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	private final void setFecha(final Date fecha) {
		this.fecha = fecha;
	}
	private final void setTipoMovimiento(final TipoMovimientoDominio tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	private final void setCuenta(final CuentaDominio cuenta) {
		this.cuenta = cuenta;
	}
	private final void setValor(final double valor) {
		this.valor = valor;
	}
	private final void setComentario(final String comentario) {
		Comentario = comentario;
	}
	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = operacion;
	}
	
	//validaciones de integridad de los atributos
		private void asegurarIntegridadCodigo() {
			if(getCodigo()<=0) {
				String mensaje= "El codigo de un movimiento debe ser mayor a 0";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}
		}
		
		private void asegurarIntegridadCuentaDominio() {
			if(getCuenta()==null) {
				String mensaje= "La cuenta  No puede ser nulo";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}else if(getCuenta().toString().trim().intern() == "") {
				String mensaje= "La cuenta cuenta no puede estar vacio";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}
		}
		
		private void asegurarIntegridadTipoMovimiento() {
			if(getTipoMovimiento()==null) {
				String mensaje= "El Tipo de movimiento No puede ser nulo";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}else if(getTipoMovimiento().toString().trim().intern() == "") {
				String mensaje= "El Tipo de movimiento  no puede estar vacio";
				throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
			}
		}
	
}

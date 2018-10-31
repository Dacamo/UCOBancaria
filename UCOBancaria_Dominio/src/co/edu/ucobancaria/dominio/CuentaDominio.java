package co.edu.ucobancaria.dominio;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;

import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public final class CuentaDominio {
	
	private int codigo;
	private String numero;
	private double saldo;
	private ClienteDominio cliente;
	private TipoCuentaDominio tipoCuenta;
	private OperacionEnum operacion;
	
	private CuentaDominio(final int codigo, final ClienteDominio cliente, final String numero, 
			final TipoCuentaDominio tipoCuenta, final double saldo, final OperacionEnum operacion) {
		super();
		setCodigo(codigo);
		setClienteDominio(cliente);
		setNumero(numero);
		setOperacion(operacion);
		setTipoCuenta(tipoCuenta);
		setSaldo(saldo);
	}
	
	public final static CuentaDominio CREAR(final int codigo, final ClienteDominio cliente, final String numero, 
			final TipoCuentaDominio tipoCuenta, final double saldo, final OperacionEnum operacion) {

		final CuentaDominio retorno = new CuentaDominio(codigo, cliente,numero,tipoCuenta, saldo, operacion);
		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadClienteDominio();
			retorno.asegurarIntegridadnumero();
			retorno.asegurarIntegridadSaldo();
			retorno.asegurarIntegridadTipoCuenta();
			
			
			
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadClienteDominio();
			retorno.asegurarIntegridadnumero();
			retorno.asegurarIntegridadSaldo();
			retorno.asegurarIntegridadTipoCuenta();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}
			
			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNumero())) {
				retorno.asegurarIntegridadnumero();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getClienteDominio().toString())) {
				retorno.asegurarIntegridadClienteDominio();;
			}

			
			break;
		default:
			String mensaje = "El objeto Cuenta no se puede crear, debido a que la operaciÛn para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}

		return retorno;
	}
	
	public final int getCodigo() {
		return codigo;
	}
	public final ClienteDominio getClienteDominio() {
		return cliente;
	}
	public final String getNumero() {
		return numero;
	}
	public final TipoCuentaDominio getTipoCuenta() {
		return tipoCuenta;
	}
	public final double getSaldo() {
		return saldo;
	}
	public final OperacionEnum getOperacion() {
		return operacion;
	}
	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}
	private final void setClienteDominio(final ClienteDominio cliente) {
		this.cliente = cliente;
	}
	private final void setNumero(final String numero) {
		this.numero = numero;
	}
	private final void setTipoCuenta(final TipoCuentaDominio tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	private final void setSaldo(final double saldo) {
		this.saldo = saldo;
	}
	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = operacion;
	}
	
	//validaciones de integridad de los atributos
	private void asegurarIntegridadCodigo() {
		if(getCodigo()<=0) {
			String mensaje= "El codigo de un cliente debe ser mayor a 0";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadnumero() {
		if(getNumero()==null) {
			String mensaje= "El numero de una cuenta No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNumero().trim().intern()=="") {
			String mensaje= "El numero de una cuenta no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getNumero().trim().length()>50) {
			String mensaje= "El numero de una cuenta no puede tener m·s de 50 caracteres";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if (getNumero().trim().matches("^[a-zA-zÒ—·¡È…ÈÕÈ”˙⁄]+$")) {
			String mensaje= "El numero de una cuenta solo puede tener letras y espacios";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadSaldo() {
		if(getSaldo()<0) {
			String mensaje= "El saldo no puede ser negativo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadTipoCuenta() {
		if(getTipoCuenta()==null) {
			String mensaje= "El tipo de cuenta No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getTipoCuenta().toString().trim().intern() == "") {
			String mensaje= "El Tipo cuenta no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	private void asegurarIntegridadClienteDominio() {
		if(getClienteDominio()==null) {
			String mensaje= "El Cliente de una cuenta No puede ser nulo";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}else if(getClienteDominio().toString().trim().intern() == "") {
			String mensaje= "El Cliente de cuenta no puede estar vacio";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
	
	
	
}

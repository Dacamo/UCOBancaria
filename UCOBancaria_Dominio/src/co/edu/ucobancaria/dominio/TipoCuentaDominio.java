package co.edu.ucobancaria.dominio;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;
import co.edu.uco.ucobase.utilitarios.cadenas.enumeracion.ExpresionRegularEnum;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

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

	public final static TipoCuentaDominio CREAR(final int codigo, final String nombre, final OperacionEnum operacion) {

		final TipoCuentaDominio retorno = new TipoCuentaDominio(codigo, nombre, operacion);

		switch (retorno.getOperacion()) {
		case CREAR:
			retorno.asegurarIntegridadNombre();
			break;
		case ACTUALIZAR:
		case POBLAR:
			retorno.asegurarIntegridadCodigo();
			retorno.asegurarIntegridadNombre();
			break;
		case DEPENDENCIA:
		case ELIMINAR:
			retorno.asegurarIntegridadCodigo();
			break;
		case CONSULTAR:
			if (retorno.getCodigo() > 0) {
				retorno.asegurarIntegridadCodigo();
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(retorno.getNombre())) {
				retorno.asegurarIntegridadNombre();
			}

			break;
		default:
			String mensaje = "El objeto Tipo Cuenta no se puede crear, debido a que la operaci�n para validar su integridad no existe.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}

		return retorno;
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

	private final void setCodigo(final int codigo) {
		this.codigo = codigo;
	}

	private final void setNombre(final String nombre) {
		this.nombre = obtenerUtilTexto().aplicarTrim(nombre);
	}

	private final void setOperacion(final OperacionEnum operacion) {
		this.operacion = OperacionEnum.obtenerValorDefecto(operacion);
	}

	private void asegurarIntegridadCodigo() {
		if (getCodigo() <= 0) {
			String mensaje = "El c�digo de un tipo de cuenta debe ser mayor a cero.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}

	private void asegurarIntegridadNombre() {
		if (obtenerUtilTexto().cadenaEsVaciaONula(getNombre())) {
			String mensaje = "El nombre de un tipo de cuenta no puede estar vac�o.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		} else if (getNombre().trim().length() > 250) {
			String mensaje = "El nombre de un tipo de cuenta no tener m�s de 250 caracteres.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		} else if (!ExpresionRegularEnum.SOLO_TEXTO.cumplePatron(getNombre())) {
			String mensaje = "El nombre de un tipo de cuenta s�lo puede contener letras y espacios.";
			throw AplicacionExcepcion.CREAR(mensaje, ExcepcionEnumeracion.DOMINIO);
		}
	}
}
package co.edu.uco.ucobase.transversal.sql;
import static co.edu.uco.ucobase.transversal.objeto.UtilObjeto.obtenerUtilObjeto;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.ucobase.transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.transversal.excepcion.excepcion.AplicacionExcepcion;

public class UtilSQL {
	private static final UtilSQL INSTANCIA = new UtilSQL();

	private UtilSQL() {
		super();
	}

	public static final UtilSQL obtenerUtilSQL() {
		return INSTANCIA;
	}

	public final boolean conexionEstaAbierta(final Connection conexion) {
		try {
			return !obtenerUtilObjeto().objetoEsNulo(conexion) && !conexion.isClosed();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de validar la conexión contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema al intentar validar si la conexión está abierta contra la fuente de información. Por favor revise la traza de la excepción.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de validar la conexión contra la fuente de información.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado al intentar validar si la conexión está abierta contra la fuente de información. Por favor revise la traza de la excepción.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}
}

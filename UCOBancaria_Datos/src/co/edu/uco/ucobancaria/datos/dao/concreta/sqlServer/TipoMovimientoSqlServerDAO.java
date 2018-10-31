package co.edu.uco.ucobancaria.datos.dao.concreta.sqlServer;

import static co.edu.uco.ucobase.utilitarios.sql.UtilSQL.obtenerUtilSQL;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoMovimientoDAO;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobancaria.dominio.TipoMovimientoDominio;

public class TipoMovimientoSqlServerDAO implements ITipoMovimientoDAO{

	private final Connection conexion;

	public TipoMovimientoSqlServerDAO(final Connection conexion) {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener de llevar a cabo la operación deseada un tipo de movimiento";
			final String mensajeTecnico = "No es posible crear un TipoMovimientoSQLServerDAO con una conexión que no está abierta.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		this.conexion = conexion;
	}
	@Override
	public void crear(final TipoMovimientoDominio tipomovimiento) {
		
		
	}

	@Override
	public void actualizar(final TipoMovimientoDominio tipomovimiento) {
		
		
	}

	@Override
	public void eliminar(final TipoMovimientoDominio tipomovimiento) {
		
		
	}

	@Override
	public List<TipoMovimientoDominio> consultar(final TipoMovimientoDominio tipomovimiento) {
		
		return null;
	}

}

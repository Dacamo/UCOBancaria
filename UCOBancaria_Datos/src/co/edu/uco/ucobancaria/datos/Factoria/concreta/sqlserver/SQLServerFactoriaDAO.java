package co.edu.uco.ucobancaria.datos.Factoria.concreta.sqlserver;

import static co.edu.uco.ucobase.utilitarios.sql.UtilSQL.obtenerUtilSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.ucobancaria.datos.Factoria.abstracta.FactoriaDAO;
import co.edu.uco.ucobancaria.datos.dao.concreta.sqlServer.TipoCuentaSqlServerDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IClienteDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ICuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IMovimientoDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoMovimientoDAO;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;

public class SQLServerFactoriaDAO extends FactoriaDAO{

	private Connection conexion;

	public SQLServerFactoriaDAO() {
		super();
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {

		if (obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener una conexion con la fuente de informacion";
			final String mensajeTecnico = "Se requiere saber la factoria que se desea obtener.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		try {
			final String cadenaConexion = "jdbc:sqlserver://prueba-farid.database.windows.net:1433;database=UCOBancaria;user=ucobancaria_dml;password=uc0b4nc4r14.2018;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de abrir una conexion con la fuente de informacion";
			final String mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexion con SQL Server. Por favor revise la traza de errores.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de abrir una conexion con la fuente de informacion";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de obtener la conexion con SQL Server. Por favor revise la traza de errores.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void cerrarConexion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexion contra SQL Server. La conexion ya se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		try {
			conexion.close();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de cerrar la conexion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void iniciarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de iniciar una transaccion contra SQL Server. La conexion se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		try {
			conexion.setAutoCommit(false);
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de iniciar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de iniciar una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de iniciar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void confirmarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de confirmar una transaccion contra SQL Server. La conexion se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		try {
			conexion.commit();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de confirmar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de confirmar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de confirmar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void cancelarTransaccion() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cancelar una transaccion contra SQL Server. La conexion se encuentra cerrada.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		try {
			conexion.rollback();
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema tratando de cancelar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		} catch (final Exception excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de cancelar los cambios de una operacion contra la fuente de informacion.";
			final String mensajeTecnico = "Se ha presentado un problema inesperado tratando de cancelar una transaccion contra SQL Server. Por favor revise la traza del error.";
			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public IClienteDAO obtenerClienteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICuentaDAO obtenerCuentaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMovimientoDAO obtenerMovimientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ITipoCuentaDAO obtenerTipoCuentaDAO() {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operacion desea";
			final String mensajeTecnico = "No es posible crear un TipoCuentaSQLServerDAO con una conexion que no está abierta.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		return new TipoCuentaSqlServerDAO(conexion);
	}

	@Override
	public ITipoMovimientoDAO obtenerTipoMovimientoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}

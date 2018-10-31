package co.edu.uco.ucobancaria.datos.dao.concreta.sqlServer;

import static co.edu.uco.ucobase.transversal.sql.UtilSQL.obtenerUtilSQL;
import static co.edu.uco.ucobase.transversal.objeto.UtilObjeto.obtenerUtilObjeto;
import static co.edu.uco.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobase.transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobancaria.dominio.TipoCuentaDominio;
import co.edu.uco.ucobase.transversal.dominio.enumeracion.OperacionEnum;



public final class TipoCuentaSqlServerDAO implements ITipoCuentaDAO {

	private final Connection conexion;

	public TipoCuentaSqlServerDAO(final Connection conexion) {

		if (!obtenerUtilSQL().conexionEstaAbierta(conexion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener de llevar a cabo la operación deseada un tipo de cuenta";
			final String mensajeTecnico = "No es posible crear un TipoCuentaSQLServerDAO con una conexión que no está abierta.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		this.conexion = conexion;
	}

	@Override
	public final void crear(final TipoCuentaDominio tipoCuenta) {

		if (!OperacionEnum.CREAR.equals(tipoCuenta.getOperacion())) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de registrar del nuevo tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "No es posible crear un objeto tipo cuenta cuya operación no corresponde a CREAR";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		final StringBuilder sentenciaBuilder = new StringBuilder();

		sentenciaBuilder.append("INSERT INTO BAN_TIPO_CUENTA_TBL(NV_NOMBRE) ");
		sentenciaBuilder.append("SELECT ?, ?");

		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuilder.toString())) {

			// Colocar parámetros a la sentencia sql
			sentenciaPreparada.setString(1, tipoCuenta.getNombre());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "Se ha presentado un problema tratando de crear el tipo de cuenta en la base de datos SQL Server.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void actualizar(final TipoCuentaDominio tipoCuenta) {

		if (!OperacionEnum.ACTUALIZAR.equals(tipoCuenta.getOperacion())) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "No es posible actualizar un objeto tipo cuenta cuya operación no corresponde a ACTUALIZAR";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		final StringBuilder sentenciaBuilder = new StringBuilder();

		sentenciaBuilder.append("UPDATE	BAN_TIPO_CUENTA_TBL ");
		sentenciaBuilder.append("SET	NV_NOMBRE = ? ");
		sentenciaBuilder.append("WHERE	IN_CODIGO = ? ");

		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuilder.toString())) {

			// Colocar parámetros a la sentencia sql
			sentenciaPreparada.setString(1, tipoCuenta.getNombre());
			sentenciaPreparada.setInt(2, tipoCuenta.getCodigo());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de modificar la información del tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "Se ha presentado un problema tratando de actualizar el tipo de cuenta en la base de datos SQL Server.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final void eliminar(final TipoCuentaDominio tipoCuenta) {

		if (!OperacionEnum.ELIMINAR.equals(tipoCuenta.getOperacion())) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de dar de baja físicamente la información del tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "No es posible eliminar un objeto tipo cuenta cuya operación no corresponde a ELIMINAR";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
		}

		final StringBuilder sentenciaBuilder = new StringBuilder();

		sentenciaBuilder.append("DELETE ");
		sentenciaBuilder.append("FROM	BAN_TIPO_CUENTA_TBL ");
		sentenciaBuilder.append("WHERE	IN_CODIGO = ? ");

		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuilder.toString())) {

			// Colocar parámetros a la sentencia sql
			sentenciaPreparada.setInt(1, tipoCuenta.getCodigo());

			sentenciaPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de dar de baja físicamente la información del tipo de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "Se ha presentado un problema tratando de eliminar el tipo de cuenta en la base de datos SQL Server.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}
	}

	@Override
	public final List<TipoCuentaDominio> consultar(final TipoCuentaDominio tipoCuenta) {

		boolean colocarWhere = true;
		final List<Object> listaParametros = new ArrayList<>();
		final List<TipoCuentaDominio> listaResultados = new ArrayList<>();
		final StringBuilder sentenciaBuilder = new StringBuilder();

		sentenciaBuilder.append("SELECT		IN_CODIGO, NV_NOMBRE ");
		sentenciaBuilder.append("FROM		BAN_TIPO_MOVIMIENTO_TBL ");

		if (!obtenerUtilObjeto().objetoEsNulo(tipoCuenta)) {

			if (!OperacionEnum.CONSULTAR.equals(tipoCuenta.getOperacion())) {
				final String mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los tipos de cuenta en la fuente de información deseada";
				final String mensajeTecnico = "No es posible consultar objetos tipo cuenta cuya operación no corresponde a CONSULTAR";

				throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.DATOS);
			}

			if (tipoCuenta.getCodigo() > 0) {
				sentenciaBuilder.append("WHERE	IN_CODIGO = ? ");
				listaParametros.add(tipoCuenta.getCodigo());
				colocarWhere = false;
			}

			if (!obtenerUtilTexto().cadenaEsVaciaONula(tipoCuenta.getNombre())) {

				if (colocarWhere) {
					sentenciaBuilder.append("WHERE	");
				} else {
					sentenciaBuilder.append("AND	");
				}

				sentenciaBuilder.append(" NV_NOMBRE LIKE ? ");
				listaParametros.add("%".concat(tipoCuenta.getNombre()).concat("%"));
				colocarWhere = false;
			}
		}

		sentenciaBuilder.append("ORDER BY	NV_NOMBRE ASC ");

		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaBuilder.toString())) {

			// Colocar parámetros a la sentencia sql
			for (int indice = 0; indice < listaParametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, listaParametros.get(indice));
			}

			try (final ResultSet cursorResultados = sentenciaPreparada.executeQuery()) {
				while (cursorResultados.next()) {
					listaResultados.add(TipoCuentaDominio.CREAR(cursorResultados.getInt("IN_CODIGO"), cursorResultados.getString("NV_NOMBRE"), OperacionEnum.POBLAR));
				}
			}
		} catch (final SQLException excepcion) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los tipos de cuenta en la fuente de información deseada";
			final String mensajeTecnico = "Se ha presentado un problema tratando de consultar los tipos de cuenta en la base de datos SQL Server.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, excepcion, ExcepcionEnumeracion.DATOS);
		}

		return listaResultados;
	}
}
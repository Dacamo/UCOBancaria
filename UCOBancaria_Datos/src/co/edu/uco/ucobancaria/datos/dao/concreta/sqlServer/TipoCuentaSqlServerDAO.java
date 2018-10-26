package co.edu.uco.ucobancaria.datos.dao.concreta.sqlServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobase_transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase_transversal.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobancaria.dominio.TipoCuentaDominio;

public final class TipoCuentaSqlServerDAO implements ITipoCuentaDAO {
	
	private final Connection conexion;
	public TipoCuentaSqlServerDAO(final Connection conexion) {
		final String mensajeUsuario = "Se ha presentado un problema tratando de obtener" + "llevar a cabo la operacion deseada de un tipo de cuenta";
		this.conexion=conexion;
	}

	@Override
	public final void crear(final TipoCuentaDominio Tipocuenta) {
		// TODO Auto-generated method stub
		final StringBuilder sentencia = new StringBuilder();
		sentencia.append("INSERT INTO BAN_TIPO");
		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentencia.toString())){
			//colocar parametros a la sentencia sql
			sentenciaPreparada.setString(1, Tipocuenta.getNombre());
			sentenciaPreparada.executeUpdate();
			
			
			
		}catch (final SQLException exception) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener" + "llevar a cabo la operacion deseada de un tipo de cuenta";
			final String mensajeTecnico ="se ha presentado un problema tratando de crear un tipomovimiento en la base de datos sqlserver";
			throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeTecnico, ExcepcionEnumeracion.DATOS);
		}
		
	}

	@Override
	public final void actualizar(final TipoCuentaDominio Tipocuenta) {
		// TODO Auto-generated method stub
				final StringBuilder sentencia = new StringBuilder();
				sentencia.append("UPDATE BAN_TIPO_CUENTA_TBL NV_NOMBRE =?, NV_SIGNO");
				try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentencia.toString())){
					//colocar parametros a la sentencia sql
					sentenciaPreparada.setString(1, Tipocuenta.getNombre());
					
					
					
					
				}catch (final SQLException exception) {
					final String mensajeUsuario = "Se ha presentado un problema tratando de obtener" + "llevar a cabo la operacion deseada de un tipo de cuenta";
					final String mensajeTecnico ="se ha presentado un problema tratando de crear un tipomovimiento en la base de datos sqlserver";
					throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeTecnico, ExcepcionEnumeracion.DATOS);
				}
				
			}
		
	

	@Override
	public final void eliminar(final TipoCuentaDominio Tipocuenta) {
		// TODO Auto-generated method stub
		final StringBuilder sentencia = new StringBuilder();
		sentencia.append("DELETE BAN_TIPO_CUENTA_TBL SET NV_NOMBRE =?, NV_SIGNO");
		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentencia.toString())){
			//colocar parametros a la sentencia sql
			sentenciaPreparada.setString(1, Tipocuenta.getNombre());
			
			
			
		}catch (final SQLException exception) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de obtener" + "llevar a cabo la operacion deseada de un tipo de cuenta";
			final String mensajeTecnico ="se ha presentado un problema tratando de crear un tipomovimiento en la base de datos sqlserver";
			throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeTecnico, ExcepcionEnumeracion.DATOS);
		}
		
	}

		
	

	@Override
	public final List<TipoCuentaDominio> consultar(final TipoCuentaDominio Tipocuenta) {
		
		boolean colocoWhere= true;
		
		final StringBuilder sentencia = new StringBuilder();
		sentencia.append("SELECT IN_CODIGO");
		
		if(Tipocuenta != null) {
			if(Tipocuenta.getCodigo()>0) {
				sentencia.append("WHERE IN_CODIGO = ?");
				colocoWhere = false;
			}
			if(Tipocuenta.getNombre() !=null && Tipocuenta.getNombre().trim().intern() != "") {
				if(colocoWhere) {
					sentencia.append("WHERE");
				}else {
					sentencia.append("AND");
				}
				sentencia.append("NV_NOMBRE LIKE");
				colocoWhere= false;
			}
		}
		sentencia.append("ORDER BY NV_NOMBRE ASC");
		
		try (final PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentencia.toString())){
			//colocar parametros a la sentencia sql
			sentenciaPreparada.setString(1, Tipocuenta.getNombre());
			
			
			
		}catch (final SQLException exception) {
			final String mensajeUsuario = "Se ha presentado un problema tratando de consultar" + "la informacion de los tipos de cuenta";
			final String mensajeTecnico ="se ha presentado un problema tratando de consultar un tipoCuenta en la base de datos sqlserver";
			throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeTecnico, ExcepcionEnumeracion.DATOS);
		}
		return null;
	}

}

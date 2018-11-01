package co.edu.uco.ucobancaria.negocio.fachada.concreta;

import java.util.List;

import co.edu.uco.ucobancaria.datos.Factoria.abstracta.FactoriaDAO;
import co.edu.uco.ucobancaria.negocio.fachada.ITipoCuentaFachada;
import co.edu.uco.ucobancaria.negocio.negocio.ITipoCuentaNegocio;
import co.edu.uco.ucobancaria.negocio.negocio.concreta.TipoCuentaNegocio;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.uco.ucobase.utilitarios.sql.Enumeracion.FuenteInformacionEnum;
import co.edu.ucobancaria.dto.TipoCuentaDTO;

public final class TipoCuentaFachada implements ITipoCuentaFachada {

	@Override
	public final void crear(TipoCuentaDTO tipoCuenta) {
		final FactoriaDAO factoria = FactoriaDAO.ObtenerFactoria(FuenteInformacionEnum.SQL_SERVER);
		try {
			factoria.IniciarTransaccion();
			final ITipoCuentaNegocio = new TipoCuentaNegocio(factoria);
			negocio.crear(tipoCuenta);
		} catch (final AplicacionExcepcion excepcion) {
			factoria.cancelarTransaccion;
			throw excepcion;
		}catch (final Exception exception  )  {
			factoria.cancelarTransaccion();
			final String mensajeUsuario ="Se ha presentado un problema tratando de registrar la infomacion del nuevo tipoCuenta";
			final String mensajeTecnico ="Se ha presentado un problema inesperado tratando de crear el nuevo tipo de cuenta";
			throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeUsuario, excepcion, ExcepcionEnumeracion.FACHADA);
		}finally {
			factoria.cerrarConexion();
		}
		
	}

	@Override
	public void actualizar(TipoCuentaDTO tipoCuenta) {
		//hacer
		
	}

	@Override
	public void eliminar(TipoCuentaDTO tipoCuenta) {
		//hacer
		
	}

	@Override
	public List<TipoCuentaDTO> consultar(TipoCuentaDTO tipoCuenta) {
		//hacer
		return null;
	}

}

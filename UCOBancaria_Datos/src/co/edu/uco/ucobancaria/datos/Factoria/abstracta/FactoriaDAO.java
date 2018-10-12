package co.edu.uco.ucobancaria.datos.Factoria.abstracta;

import co.edu.uco.ucobancaria.datos.dao.interfaces.IClienteDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ICuentaDAOs;
import co.edu.uco.ucobancaria.datos.dao.interfaces.IMovimientoDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoCuentaDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ITipoMovimientoDAO;

public abstract class FactoriaDAO {
	
	protected abstract void abrirConexion();
	
	protected abstract void iniciarTransaccion();
	
	protected abstract void cerrarConexion();
	
	protected abstract void confirmarTransaccion();
	
	protected abstract void cancelarTransaccion();
	
	
	public abstract IClienteDAO ObtenerClienteDAO();
	public abstract ICuentaDAOs ObtenerCuentaDAO();
	public abstract IMovimientoDAO ObtenerMovimientoDAO();
	public abstract ITipoMovimientoDAO ObtenerTipoMovimientoDAO();
	public abstract ITipoCuentaDAO ObtenerTipoCuentaDAO();
	
}

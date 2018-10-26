package co.edu.uco.ucobancaria.datos.Factoria.abstracta;

import co.edu.uco.ucobancaria.datos.dao.interfaces.IClienteDAO;
import co.edu.uco.ucobancaria.datos.dao.interfaces.ICuentaDAO;
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
	public abstract ICuentaDAO ObtenerCuentaDAO();
	public abstract IMovimientoDAO ObtenerMovimientoDAO();
	public abstract ITipoMovimientoDAO ObtenerTipoMovimientoDAO();
	public abstract ITipoCuentaDAO ObtenerTipoCuentaDAO();
	
	//tarea: traer toda esto desde java para sql server con jdbc -----> 
	//agregar dependencia del repo de maven sqlserver JDBC 7.0.0, copiar dependencia se pega en capa de datos, en pom, dependencias
	//jdbc sqlserver driver for sql (conexion punto punto)
}

package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;


import co.edu.ucobancaria.dominio.TipoCuentaDominio;

public interface ITipoCuentaDAO {

	void crear(TipoCuentaDominio Tipocuenta);
	void actualizar(TipoCuentaDominio Tipocuenta);
	void eliminar(TipoCuentaDominio Tipocuenta);
	List<TipoCuentaDominio> consultar(TipoCuentaDominio Tipocuenta);
}

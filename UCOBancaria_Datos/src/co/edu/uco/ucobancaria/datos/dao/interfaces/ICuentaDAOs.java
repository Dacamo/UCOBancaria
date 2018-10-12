package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;

import co.edu.ucobancaria.dominio.CuentaDominio;

public interface ICuentaDAOs {
	void crear(CuentaDominio cuenta);
	void actualizar(CuentaDominio cuenta);
	void eliminar(CuentaDominio cuenta);
	List<CuentaDominio> consultar(CuentaDominio cuenta);
}

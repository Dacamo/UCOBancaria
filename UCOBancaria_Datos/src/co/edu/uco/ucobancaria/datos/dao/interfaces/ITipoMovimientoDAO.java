package co.edu.uco.ucobancaria.datos.dao.interfaces;

import java.util.List;


import co.edu.ucobancaria.dominio.TipoMovimientoDominio;

public interface ITipoMovimientoDAO {

	void crear(TipoMovimientoDominio tipomovimiento);
	void actualizar(TipoMovimientoDominio tipomovimiento);
	void eliminar(TipoMovimientoDominio tipomovimiento);
	List<TipoMovimientoDominio> consultar(TipoMovimientoDominio tipomovimiento);
}

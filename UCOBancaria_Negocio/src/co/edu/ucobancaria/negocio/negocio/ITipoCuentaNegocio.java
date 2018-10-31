package co.edu.ucobancaria.negocio.negocio;

import java.util.List;

import co.edu.ucobancaria.dto.TipoCuentaDTO;

public interface ITipoCuentaNegocio {
	
	void crear(TipoCuentaDTO tipoCuenta);

	void actualizar(TipoCuentaDTO tipoCuenta);

	void eliminar(TipoCuentaDTO tipoCuenta);

	List<TipoCuentaDTO> consultar(TipoCuentaDTO tipoCuenta);
}

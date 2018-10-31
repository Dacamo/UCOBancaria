package co.edu.ucobancaria.negocio.negocio.ensamblador.concreta;

import co.edu.ucobancaria.dominio.TipoCuentaDominio;
import co.edu.ucobancaria.dto.TipoCuentaDTO;
import co.edu.ucobancaria.negocio.negocio.ensamblador.IEnsamblador;
import co.edu.uco.ucobase.transversal.dominio.enumeracion.OperacionEnum;

import static co.edu.uco.ucobase.transversal.objeto.UtilObjeto.obtenerUtilObjeto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.ucobase.transversal.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.transversal.excepcion.excepcion.AplicacionExcepcion;

public class TipoCuentaEnsamblador implements IEnsamblador<TipoCuentaDominio, TipoCuentaDTO>{
	private static final IEnsamblador<TipoCuentaDominio, TipoCuentaDTO> INSTANCIA = new TipoCuentaEnsamblador();

	private TipoCuentaEnsamblador() {
		super();
	}

	public static final IEnsamblador<TipoCuentaDominio, TipoCuentaDTO> obtenerTipoCuentaEnsamblador() {
		return INSTANCIA;
	}

	@Override
	public final TipoCuentaDTO enmsablarDTO(final TipoCuentaDominio objetoDominio) {

		if (obtenerUtilObjeto().objetoEsNulo(objetoDominio)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operaci�n deseada sobre un tipo de cuenta";
			final String mensajeTecnico = "No es posible ensamblar un TipoCuentaDTO con un TipoCuentaDominio nulo.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.NEGOCIO);
		}

		return new TipoCuentaDTO(objetoDominio.getCodigo(), objetoDominio.getNombre());
	}

	@Override
	public final TipoCuentaDominio ensamblarDominio(final TipoCuentaDTO objetoDto, final OperacionEnum operacion) {

		if (obtenerUtilObjeto().objetoEsNulo(operacion)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operaci�n deseada sobre un tipo de cuenta";
			final String mensajeTecnico = "No es posible ensamblar un TipoCuentaDominio con la operaci�n vac�a. La operaci�n es requerida para asegurar la integridad del objeto.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.NEGOCIO);
		}

		final TipoCuentaDTO mapeadorDTO = obtenerUtilObjeto().obtenerValorDefecto(objetoDto, new TipoCuentaDTO());

		return TipoCuentaDominio.CREAR(mapeadorDTO.getCodigo(), mapeadorDTO.getNombre(), operacion);
	}

	@Override
	public final List<TipoCuentaDTO> enmsablarListaDTO(final List<TipoCuentaDominio> listaObjetosDominio) {

		final List<TipoCuentaDominio> listaMapeadoraDominio = obtenerUtilObjeto().obtenerValorDefecto(listaObjetosDominio, new ArrayList<>());
		final List<TipoCuentaDTO> listaDtos = new ArrayList<>();

		for (final TipoCuentaDominio tipoCuentaDominio : listaMapeadoraDominio) {
			listaDtos.add(enmsablarDTO(tipoCuentaDominio));
		}

		return listaDtos;
	}
}

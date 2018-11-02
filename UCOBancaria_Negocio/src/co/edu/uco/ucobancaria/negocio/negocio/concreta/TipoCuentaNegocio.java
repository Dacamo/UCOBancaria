package co.edu.uco.ucobancaria.negocio.negocio.concreta;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

import java.util.List;

import co.edu.uco.ucobancaria.datos.Factoria.abstracta.FactoriaDAO;
import co.edu.uco.ucobancaria.negocio.negocio.ITipoCuentaNegocio;
import co.edu.uco.ucobancaria.negocio.negocio.ensamblador.concreta.TipoCuentaEnsamblador;
import co.edu.uco.ucobase.utilitarios.dominio.enumeracion.OperacionEnum;
import co.edu.uco.ucobase.utilitarios.excepcion.enumeracion.ExcepcionEnumeracion;
import co.edu.uco.ucobase.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import co.edu.ucobancaria.dominio.TipoCuentaDominio;
import co.edu.ucobancaria.dto.TipoCuentaDTO;



public class TipoCuentaNegocio implements ITipoCuentaNegocio {

	private final FactoriaDAO factoria;

	public TipoCuentaNegocio(final FactoriaDAO factoria) {

		super();

		if (obtenerUtilObjeto().objetoEsNulo(factoria)) {
			final String mensajeUsuario = "Se ha presentado un problema tratando realizar la operación deseada sobre un tipo de cuenta";
			final String mensajeTecnico = "No es posible crear un TipoCuentaNegocio con una factoria nula.";

			throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnumeracion.NEGOCIO);
		}

		this.factoria = factoria;
	}

	@Override
	public final void crear(final TipoCuentaDTO tipoCuenta) {

		// 1. Ensamblar dominio
		final TipoCuentaDominio tipoCuentaDominio = TipoCuentaEnsamblador.obtenerTipoCuentaEnsamblador().ensamblarDominio(tipoCuenta, OperacionEnum.CREAR);
			
		
		// 2. Validar que no exista un tipo de cuenta con el nombre deseado
		final TipoCuentaDominio validaReglaUno= TipoCuentaDominio.CREAR(0,  tipoCuentaDominio.getNombre(), OperacionEnum.CREAR);
		final List<TipoCuentaDominio> registrosReglaUno = factoria.obtenerTipoCuentaDAO().consultar(validaReglaUno);
		
		if(!registrosReglaUno.isEmpty()) {
			final String mensajeusuario ="Ya existe un tipo de cuenta con ese nombre";
			final String mensajeTecnico ="No se puede registrar dos tipos de cuenta";
			 throw AplicacionExcepcion.CREAR(mensajeusuario,mensajeTecnico,ExcepcionEnumeracion.NEGOCIO);
			 
		}
		
		//3. crear el tipo de cuenta en la fuente de informacion
		factoria.obtenerTipoCuentaDAO().crear(tipoCuentaDominio);
	}
	
	@Override
	public final void actualizar(final TipoCuentaDTO tipoCuenta) {

		// 1. Ensamblar dominio
		final TipoCuentaDominio tipoCuentaDominio = TipoCuentaEnsamblador.obtenerTipoCuentaEnsamblador().ensamblarDominio(tipoCuenta, OperacionEnum.ACTUALIZAR);

		// 2. Crear el tipo de cuenta en la fuente de información
		final TipoCuentaDominio validarReglaUno = TipoCuentaDominio.CREAR(tipoCuentaDominio.getCodigo(),  tipoCuentaDominio.getNombre(), OperacionEnum.CREAR);
		final List<TipoCuentaDominio> registrosReglaUno = factoria.obtenerTipoCuentaDAO().consultar(validarReglaUno);
		
		if(!registrosReglaUno.isEmpty()) {
			final String mensajeusuario ="no es posible actualizar un tipo de cuenta no existente";
			final String mensajeTecnico ="No se puede actualizar ya que el codigo no existe";
			 throw AplicacionExcepcion.CREAR(mensajeusuario,mensajeTecnico,ExcepcionEnumeracion.NEGOCIO);	 
		}
		 final TipoCuentaDominio validarReglaDos = TipoCuentaDominio.CREAR(0, tipoCuentaDominio.getNombre(), OperacionEnum.CREAR);
		 
		 final List<TipoCuentaDominio> registrosReglaDos= factoria.obtenerTipoCuentaDAO().consultar(validarReglaDos);
		 
		 if(!registrosReglaDos.isEmpty() && tipoCuentaDominio.getCodigo() != registrosReglaDos.get(0).getCodigo()) {
			 final String mensajeUsuario = " no es posible actualizar un tipo de cuenta no existente";
			 final String mensajeTecnico = "no se puede actualizar ya que el codigo no es existente";
			 
			 throw AplicacionExcepcion.CREAR(mensajeUsuario,mensajeTecnico,ExcepcionEnumeracion.NEGOCIO);
			 
		 }
		 
		 //4. Solo actualizo esi cambiaron los datos
		 if(registrosReglaUno.get(0).getNombre().equals(tipoCuentaDominio.getNombre())) {
			 factoria.obtenerTipoCuentaDAO().actualizar(tipoCuentaDominio);
		 }
	}
	

	@Override
	public final void eliminar(final TipoCuentaDTO tipoCuenta) {

		// 1. Ensamblar dominio
		final TipoCuentaDominio tipoCuentaDominio = TipoCuentaEnsamblador.obtenerTipoCuentaEnsamblador().ensamblarDominio(tipoCuenta, OperacionEnum.ELIMINAR);
		
		final TipoCuentaDominio validarReglaUno=  TipoCuentaDominio.CREAR(tipoCuentaDominio.getCodigo(), tipoCuentaDominio.getNombre(), OperacionEnum.CREAR);
		final List<TipoCuentaDominio> registrosReglaUno = factoria.obtenerTipoCuentaDAO().consultar(validarReglaUno);
		
		if(!registrosReglaUno.isEmpty()) {
			final String mensajeusuario ="no es posible eliminar un tipo de cuenta no existente";
			final String mensajeTecnico ="No se puede eliminar ya que el codigo no existe";
			 throw AplicacionExcepcion.CREAR(mensajeusuario,mensajeTecnico,ExcepcionEnumeracion.NEGOCIO);	 
		}
		
		// 2. Crear el tipo de cuenta en la fuente de información
		factoria.obtenerTipoCuentaDAO().eliminar(tipoCuentaDominio);
	}

	@Override
	public final List<TipoCuentaDTO> consultar(final TipoCuentaDTO tipoCuenta) {

		// 1. Ensamblar dominio
		final TipoCuentaDominio tipoCuentaDominio = TipoCuentaEnsamblador.obtenerTipoCuentaEnsamblador().ensamblarDominio(tipoCuenta, OperacionEnum.CONSULTAR);

		// 2. Crear el tipo de cuenta en la fuente de información
		final List<TipoCuentaDominio> listaDominios = factoria.obtenerTipoCuentaDAO().consultar(tipoCuentaDominio);

		// 3. Ensamblar lista de retorno
		return TipoCuentaEnsamblador.obtenerTipoCuentaEnsamblador().enmsablarListaDTO(listaDominios);
	}
}

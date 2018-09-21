package co.edu.ucobase.transversal.objeto;

public final class UtilObjeto {

	/**
	 * objeto utilitario que expone servicios que pueden ser utilizado de forma 
	 * generica por algun objeto que lo requiera
	 */
	
	private static final UtilObjeto INSTANCIA = new UtilObjeto();
	
	private UtilObjeto() {
		super();
	}
	
	public static final UtilObjeto obtenerUtilObjeto () {
		return INSTANCIA;
	}
	
	public <T> T obtenerValorDefecto (T objeto, T valorDefecto) {
		T retorno= objeto;
		if(objeto==null) {
			retorno = valorDefecto;
		}
		return retorno;
	
	}
}

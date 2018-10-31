package co.edu.uco.ucobase.utilitarios.cadenas;

import static co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto.obtenerUtilObjeto;

public final class UtilTexto {
	
	private static final UtilTexto INSTANCIA = new UtilTexto();
	
	private UtilTexto() {
		super();
	}
	
	public static final UtilTexto obtenerUtilTexto () {
		return INSTANCIA;
	}
	
	public <T> T obtenerValorDefecto (T objeto, T valorDefecto) {
		T retorno= objeto;
		if(objeto==null) {
			retorno = valorDefecto;
		}
		return retorno;
	
	}
	public String aplicarTrim(String cadena) {
		return obtenerUtilObjeto().obtenerValorDefecto(cadena, "");
		
	}
	
	public final boolean cadenaEsVaciaONula(final String cadena) {
		return aplicarTrim(cadena).intern() == "" ;
	}
	
	
}

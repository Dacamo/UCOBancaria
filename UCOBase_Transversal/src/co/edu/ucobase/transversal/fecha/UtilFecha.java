package co.edu.ucobase.transversal.fecha;


import java.util.Date;


public class UtilFecha {
	
	private static final UtilFecha INSTANCIA = new UtilFecha();
	
	private UtilFecha() {
		super();
	}
	
	public static final UtilFecha obtenerUtilFecha () {
		return INSTANCIA;
	}
	
	public <T> T obtenerValorDefecto (T objeto) {
		T retorno= objeto;
		if(objeto==null) {
			retorno = (T) new Date();
			System.out.println(retorno);
		}
		return retorno;
	
	}
	
}

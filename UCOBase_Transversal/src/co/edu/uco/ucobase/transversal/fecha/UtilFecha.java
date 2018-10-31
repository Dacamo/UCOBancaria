package co.edu.uco.ucobase.transversal.fecha;


import java.util.Calendar;
import java.util.Date;


public class UtilFecha {
	
	private static final UtilFecha INSTANCIA = new UtilFecha();

	private UtilFecha() {
		super();
	}

	public static final UtilFecha obtenerUtilFecha() {
		return INSTANCIA;
	}

	public final Date obtenerFechaActual() {
		return Calendar.getInstance().getTime();
	}
	
	
}

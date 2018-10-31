package co.edu.uco.ucobase.utilitarios;
import org.junit.Assert;
import org.junit.Test;

import co.edu.uco.ucobase.utilitarios.objeto.UtilObjeto;

import static co.edu.uco.ucobase.utilitarios.cadenas.UtilTexto.obtenerUtilTexto;
import static co.edu.uco.ucobase.utilitarios.fecha.UtilFecha.obtenerUtilFecha;




public class TransversalTest {
	

	@Test
	public void UtilTextoObtenerValorDefectoAssert() {
		// Arrange
		String ejemplo= "Nombre";
		//Act
		String resultado = obtenerUtilTexto().obtenerValorDefecto(ejemplo, " ");
		
		// Assert
		Assert.assertEquals(ejemplo, resultado);
	}
	@Test
	public void UtilTextoObtenerValorDefectoDissert() {
		// Arrange
		String ejemplo = null;
		//Act
		String resultado = obtenerUtilTexto().obtenerValorDefecto(ejemplo, " ");
		
		// Assert
		Assert.assertEquals(" ", resultado);
	}
	@Test
	public void UtilTextoAplicarTrimAssert() {
		// Arrange
		String ejemplo= "Nombre";
		//Act
		String resultado = obtenerUtilTexto().aplicarTrim(ejemplo);
		
		// Assert
		Assert.assertEquals(ejemplo, resultado);
	}
	
	@Test 
	public void UtilObjetoObtenerValorObjeto () {
		//arrange
		Object objeto = null;
		//act
		String resultado = (String) UtilObjeto.obtenerUtilObjeto().obtenerValorDefecto(objeto, " ");
		//assert
		Assert.assertEquals(" ", resultado);
		
	}
	
	
	
	
}



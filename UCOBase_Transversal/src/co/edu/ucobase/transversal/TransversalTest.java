package co.edu.ucobase.transversal;
import org.junit.Assert;
import org.junit.Test;

import co.edu.ucobase.transversal.objeto.UtilObjeto;

import static co.edu.ucobase.transversal.cadenas.UtilTexto.obtenerUtilTexto;
import static co.edu.ucobase.transversal.fecha.UtilFecha.obtenerUtilFecha;

import java.util.Date;


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
	
	@Test
	public void utilfechaobtenervalordefectoassert() {
		// Arrange
		String ejemplo = null;
		//Act
		String resultado = obtenerUtilFecha().obtenerValorDefecto(ejemplo);
		System.out.println(resultado);
		
		// Assert
		Assert.assertNotNull(resultado.toString());
	}
	
	
}



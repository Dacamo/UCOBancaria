package co.edu.ucobancaria.dto;
import org.junit.Assert;
import org.junit.Test;

public class ClienteDTOTest {
	

	@Test
	public void getcodigoTest() {
		// Arrange
		ClienteDTO cliente = new ClienteDTO(5, "asd5", "asd", "asdsad", "asd54s5");
		
		
		// Act
		int resultado = cliente.getCodigo();
		
		// Assert
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void getNumeroIdentificacionTest() {
		// Arrange
		ClienteDTO cliente = new ClienteDTO(5, "asd5", "asd", "asdsad", "asd54s5");
		
		
		// Act
		String resultado = cliente.getNumeroIdentificacion();
		
		// Assert
		Assert.assertEquals("asd5", resultado);
	}
}

package softur.testUnitario.validadorCPF;



import junit.framework.TestCase;

import org.junit.Test;

import softur.validadores.ValidadorCPF;



public class TesteRetiraCaracteresInvalidos extends TestCase {
	
	@Test
	public void testRetiraCaracteresInvalidos() {
		String cpf = "382.337.024-39fsdasdfkjlaskdjflkjasgljasdgfljalsdgfjlasldfjlksm)*)(&&*^&*%&^$&^(&()(";
		String cpfComEstadoEsperado = "38233702439";
		String cpfComEstadoAtual = ValidadorCPF.retiraCaracteresInvalidos(cpf);

		assertEquals(cpfComEstadoEsperado, cpfComEstadoAtual);
	}
	
	@Test
	public void testRetiraTracosPontos() {
		String cpf = "382.337.024-39";
		String cpfComEstadoEsperado = "38233702439";
		String cpfComEstadoAtual = ValidadorCPF.retiraCaracteresInvalidos(cpf);

		assertEquals(cpfComEstadoEsperado, cpfComEstadoAtual);
	}
	
	@Test
	public void testRetiraAssentuacao() {
		String cpf = "382#337%024@@39";
		String cpfComEstadoEsperado = "38233702439";
		String cpfComEstadoAtual = ValidadorCPF.retiraCaracteresInvalidos(cpf);

		assertEquals(cpfComEstadoEsperado, cpfComEstadoAtual);
	}
	
	@Test
	public void testRetiraSinaisMatematicos() {
		String cpf = "382+33-7*024//3=9";
		String cpfComEstadoEsperado = "38233702439";
		String cpfComEstadoAtual = ValidadorCPF.retiraCaracteresInvalidos(cpf);

		assertEquals(cpfComEstadoEsperado, cpfComEstadoAtual);
	}


}

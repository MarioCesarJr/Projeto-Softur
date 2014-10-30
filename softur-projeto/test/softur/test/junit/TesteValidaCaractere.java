package softur.test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import softur.validadores.ValidadorCaracteres;

public class TesteValidaCaractere {
	
	@Test
	public void testeCaractereNomeMaiorQueLimite(){
		String testLetra = "polkjuytgbncbdretacvbgdnetafvcgd";
		boolean validar = ValidadorCaracteres.tamanhoNome(testLetra);
		assertFalse(validar);
		
	}
	@Test
	public void testeCaractereNomeDentroDoLimite(){
		String testLetra = "polkjuytgbncbdretacvbgdnet";
		boolean validar = ValidadorCaracteres.tamanhoNome(testLetra);
		assertTrue(validar);
		
	}

}

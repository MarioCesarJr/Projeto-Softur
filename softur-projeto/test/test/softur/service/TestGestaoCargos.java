package test.softur.service;

import org.junit.Assert;
import org.junit.Test;

import softur.entities.Cargo;
import softur.service.GestaoCargos;
import softur.service.RegraNegocioException;

public class TestGestaoCargos {
	
	@Test
	public void deveRestornarUmCargo() throws RegraNegocioException{
		GestaoCargos gestaoCargos = new GestaoCargos();
		Cargo cargo = new Cargo();
	    cargo.setNomeCargo("Gerente");
		
		Assert.assertEquals(true,gestaoCargos.validarCampos(cargo));
	
	}

}

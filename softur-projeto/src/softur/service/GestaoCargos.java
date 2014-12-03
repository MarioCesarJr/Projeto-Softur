package softur.service;

import softur.entities.Cargo;
import softur.repository.Cargos;

public class GestaoCargos {

	
	public void salvar(Cargo cargo) throws RegraNegocioException{
		Cargos cargos = new Cargos();
		
		if(existeCargoIgual(cargo)){
			throw new RegraNegocioException("Já existe um cargo igual a este.");
		}
		
		validarCampos(cargo);
		
		cargos.salvar(cargo);
	}
	
	public void excluir(Cargo cargo) {
		Cargos cargos = new Cargos();
		cargos.deletar(cargo);	
		
	}
	
	private boolean existeCargoIgual(Cargo cargo){
		Cargos cargos = new Cargos();
		Cargo cargoIgual = cargos.cargoIgual(cargo);
		return cargoIgual != null && !cargoIgual.equals(cargo);
	}
	
	public boolean validarCampos(Cargo cargo) throws RegraNegocioException{
	
		if(cargo.getNomeCargo() == null || cargo.getNomeCargo().equals("")){
			
			throw new RegraNegocioException("O campo cargo é obrigatório.");
		}
		
		if(cargo.getNomeCargo().length() > 35) {
			
			throw new RegraNegocioException("É permitido no máximo 35 caracteres.");
		}
	
	     return true;
	}
	
}

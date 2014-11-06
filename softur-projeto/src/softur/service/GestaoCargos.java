package softur.service;

import softur.entities.Cargo;
import softur.repository.Cargos;

public class GestaoCargos {

	private Cargos cargos = new Cargos();
	
	public void salvar(Cargo cargo) throws RegraNegocioException{
		if(existeCargoIgual(cargo)){
			throw new RegraNegocioException("Já existe um cargo igual a este.");
		}
		
		validarCampos(cargo);
		
		this.cargos.salvar(cargo);
	}
	
	public void excluir(Cargo cargo) {
	
			this.cargos.deletar(cargo);	
		
	}
	
	private boolean existeCargoIgual(Cargo cargo){
		Cargo cargoIgual = this.cargos.cargoIgual(cargo);
		return cargoIgual != null && !cargoIgual.equals(cargo);
	}
	
	private void validarCampos(Cargo cargo) throws RegraNegocioException{
		if(cargo.getNomeCargo() == null || cargo.getNomeCargo().equals("")){
			
			throw new RegraNegocioException("O campo cargo é obrigatório.");
		}
		
		if(cargo.getNomeCargo().length() > 35) {
			
			throw new RegraNegocioException("É permitido no máximo 35 caracteres.");
		}
	
	}
	
}

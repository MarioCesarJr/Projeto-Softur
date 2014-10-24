package softur.service;

import softur.entities.Cargo;
import softur.repository.Cargos;

public class GestaoCargos {

	private Cargos cargos;
	
	public GestaoCargos(Cargos cargos){
		this.cargos = cargos;
		
	}
	
	public void salvar(Cargo cargo) throws RegraNegocioException{
		if(existeCargoIgual(cargo)){
			throw new RegraNegocioException("Já existe um cargo igual a este.");
		}
		this.cargos.salvar(cargo);
	}
	
	public void excluir(Cargo cargo) {
	
			this.cargos.deletar(cargo);	
		
	}
	
	private boolean existeCargoIgual(Cargo cargo){
		Cargo cargoIgual = this.cargos.cargoIgual(cargo);
		return cargoIgual != null && !cargoIgual.equals(cargo);
	}
	
}

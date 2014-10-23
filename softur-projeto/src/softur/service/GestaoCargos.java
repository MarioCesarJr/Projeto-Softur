package softur.service;

import softur.entities.Cargo;
import softur.repository.Cargos;

public class GestaoCargos {

	private Cargos cargos;
	
	public GestaoCargos(Cargos cargos){
		this.cargos = cargos;
		
	}
	
	public void salvar(Cargo cargo){
		this.cargos.salvar(cargo);
	}
	
	public void excluir(Cargo cargo){
		this.cargos.deletar(cargo);
	}
}

package softur.repository;

import java.util.List;

import softur.entities.Cargo;

public interface Cargos {
    
	public void salvar(Cargo cargo);
	public List<Cargo> listarTodos();
	public Cargo buscarPorCodigo(Long codigo);
	public void deletar(Cargo cargo);
    public Cargo cargoIgual(Cargo cargo);	
}

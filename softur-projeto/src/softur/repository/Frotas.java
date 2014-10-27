package softur.repository;

import java.util.List;


import softur.entities.Frota;

public interface Frotas {
	public void salvar(Frota Frota);
	public void deletar(Frota Frota);
	public void atualizar(Frota Frota);
	public Frota buscarId(Long codigo);
	public List<Frota> listarTodos();
	public Frota comDadosIguais(Frota frota);


}

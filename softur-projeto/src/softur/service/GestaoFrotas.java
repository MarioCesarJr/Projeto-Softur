package softur.service;

import softur.entities.Frota;
import softur.repository.Frotas;



public class GestaoFrotas {
private Frotas frotas;
	public GestaoFrotas(Frotas frotas){
		this.frotas = frotas;
	}
	
	public void salvar(Frota frota) throws RegraNegocioException{
		if(existeNomeIgual(frota)){
			throw new RegraNegocioException("Já existe um nome igual a este.");
		}
		
		this.frotas.salvar(frota);
	}
	
	private boolean existeNomeIgual(Frota frota) {
		Frota nomeIgual = this.frotas.comDadosIguais(frota);
		return nomeIgual != null && !nomeIgual.equals(frota);
	}
    
	public void excluir(Frota frota){
		this.frotas.deletar(frota);
	}


}

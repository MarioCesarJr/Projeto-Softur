package softur.service;

import softur.entities.Viagem;
import softur.repository.Viagens;

public class GestaoViagem {

	private Viagens viagens = new Viagens();

	public void salvar(Viagem viagem) {
		viagens.salvar(viagem);
	}

	public void excluir(Viagem viagem) {
		viagens.excluir(viagem);
	}
}

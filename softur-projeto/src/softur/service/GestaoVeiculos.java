package softur.service;

import softur.entities.Veiculo;
import softur.repository.Veiculos;

public class GestaoVeiculos {

	private Veiculos veiculos = new Veiculos();

	public void salvar(Veiculo veiculo) {
		this.veiculos.salvar(veiculo);
	}

	public void excluir(Veiculo veiculo) {
        this.veiculos.deletar(veiculo);
	}
}

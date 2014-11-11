package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Veiculo;
import softur.repository.Veiculos;
import softur.service.GestaoVeiculos;

@ManagedBean
public class ConsultaVeiculoBean {

	private List<Veiculo> veiculoList;
	private Veiculo veiculoSelecionado;

	@PostConstruct
	public void init() {
		Veiculos veiculos = new Veiculos();
		this.veiculoList = veiculos.listarTodos();
	}

	public String excluir() {
		GestaoVeiculos gestaoVeiculos = new GestaoVeiculos();
		gestaoVeiculos.excluir(this.veiculoSelecionado);
		this.init();
		return "";
	}

	public List<Veiculo> getVeiculoList() {
		return veiculoList;
	}

	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}

	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}

}

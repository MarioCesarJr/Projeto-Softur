package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Cargo;
import softur.repository.Cargos;
import softur.service.GestaoCargos;

@ManagedBean
public class ConsultaCargoBean {

	private List<Cargo> cargosList;
	private Cargo cargoSelecionado;
	
	@PostConstruct
	public void init(){
		Cargos cargos = new Cargos();
		this.cargosList = cargos.listarTodos();
	}
	
	/*****************************************************************
	 * FUNCIONARIO VINCULADO AO CARGO
	 ******************************************************************/
	public String excluir(){
		GestaoCargos gestaoCargos = new GestaoCargos();			
			
		gestaoCargos.excluir(this.cargoSelecionado);
		
		this.init();
		return "";
	}

	public List<Cargo> getCargos() {
		return cargosList;
	}

	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}
	
	
}

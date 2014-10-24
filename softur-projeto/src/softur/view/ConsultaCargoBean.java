package softur.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import softur.entities.Cargo;
import softur.repository.Cargos;
import softur.service.GestaoCargos;
import softur.util.Repositorios;

@ManagedBean
public class ConsultaCargoBean {

	private Repositorios repositorios = new Repositorios();
	private List<Cargo> cargos = new ArrayList<Cargo>();
	private Cargo cargoSelecionado;
	
	@PostConstruct
	public void init(){
		Cargos cargos = this.repositorios.getCargos();
		this.cargos = cargos.listarTodos();
	}
	
	/*****************************************************************
	 * FUNCIONARIO VINCULADO AO CARGO
	 ******************************************************************/
	public String excluir(){
		GestaoCargos gestaoCargos = new GestaoCargos(this.repositorios.getCargos());			
			
		gestaoCargos.excluir(this.cargoSelecionado);
			
		return "";
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public Cargo getCargoSelecionado() {
		return cargoSelecionado;
	}

	public void setCargoSelecionado(Cargo cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}
	
	
}

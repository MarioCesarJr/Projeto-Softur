package softur.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.persistence.PersistenceException;

import softur.entities.Cargo;
import softur.repository.Cargos;
import softur.service.GestaoCargos;
import softur.util.FacesUtil;

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
	 * FUNCIONARIO VINCULADO AO CARGO ! Lançando Excessão
	 ******************************************************************/
	public String excluir(){
		GestaoCargos gestaoCargos = new GestaoCargos();			
			
		try{
		
		gestaoCargos.excluir(this.cargoSelecionado);
		this.init();
		
		}catch(PersistenceException p){
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Existe Funcionario ocupando este Cargo !");
		}
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

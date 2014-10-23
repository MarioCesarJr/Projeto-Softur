package softur.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Cargo;
import softur.service.GestaoCargos;
import softur.util.FacesUtil;
import softur.util.Repositorios;

@ManagedBean
public class CadastroCargoBean {

	private Repositorios repositorios = new Repositorios();
	private Cargo cargo = new Cargo();

	public String salvar() {
		GestaoCargos gestaoCargos = new GestaoCargos(this.repositorios.getCargos());
		gestaoCargos.salvar(cargo);
		this.cargo = new Cargo();
		
		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cargo salvo com sucesso!");
		
		return "";
	}

	public Cargo getCargo() {
		return cargo;
	}
}

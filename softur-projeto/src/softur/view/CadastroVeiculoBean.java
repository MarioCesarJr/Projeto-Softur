package softur.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import softur.entities.Veiculo;
import softur.service.GestaoVeiculos;
import softur.util.FacesUtil;

@ManagedBean
public class CadastroVeiculoBean {

	private Veiculo veiculo = new Veiculo();
	

	public String salvar() {
		GestaoVeiculos gestaoVeiculos = new GestaoVeiculos();
		gestaoVeiculos.salvar(veiculo);

		this.veiculo = new Veiculo();

		FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Veículo salvo com sucesso !");

		return "";
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
		if(this.veiculo == null){
			this.veiculo = new Veiculo();
		}
	}
	
	

}

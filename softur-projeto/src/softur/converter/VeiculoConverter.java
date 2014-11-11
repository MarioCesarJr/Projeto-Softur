package softur.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import softur.entities.Veiculo;
import softur.repository.Veiculos;

@FacesConverter(forClass = Veiculo.class)
public class VeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Veiculo retorno = null;
        Veiculos veiculos = new Veiculos();
		
		if (value != null && !value.equals("")) {
			retorno = veiculos.buscarId(new Long(value));
			
			if(retorno == null){
				   String descricaoErro = "Veiculo nao existe";
				   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
					throw new ConverterException(message);
			   }
		}

		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value != null){
			  Long codigo = ((Veiculo) value).getId();
			  return codigo == null ? "" : codigo.toString();
		  }
		return null;
	}
}

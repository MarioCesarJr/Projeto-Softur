package softur.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import softur.entities.Viagem;
import softur.repository.Viagens;

@FacesConverter(forClass=Viagem.class)
public class ViagemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Viagem retorno = null;
        Viagens viagens = new Viagens();
		
		if (value != null && !value.equals("")) {
			retorno = viagens.buscar(new Long(value));
			
			if(retorno == null){
				   String descricaoErro = "Viagem nao existe";
				   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
					throw new ConverterException(message);
			 
			}
		}
	
		return retorno;
	}

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			  Long codigo = ((Viagem) value).getId();
			  return codigo == null ? "" : codigo.toString();
		  }
		return null;
	}

	
}

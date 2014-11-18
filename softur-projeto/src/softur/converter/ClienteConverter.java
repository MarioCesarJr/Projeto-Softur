package softur.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import softur.entities.Cliente;
import softur.repository.Clientes;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	   Cliente retorno = null;
	   Clientes clientes = new Clientes();
	   
	   if(value != null && !value.equals("")){
		   retorno = clientes.buscarId(new Long(value));
		   
		   if(retorno == null){
			   String descricaoErro = "Cliente não existe";
			   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
				throw new ConverterException(message);
		   }
	   }
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		  
		  if(value != null){
			  Long codigo = ((Cliente) value).getId();
			  return codigo == null ? "" : codigo.toString();
		  }
		return null;
	}

}

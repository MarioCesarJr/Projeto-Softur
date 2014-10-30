package softur.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import softur.entities.Funcionario;
import softur.repository.Funcionarios;

@FacesConverter(forClass=Funcionario.class)
public class FuncionarioConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	   Funcionario retorno = null;
	   Funcionarios funcionarios = new Funcionarios();
	   
	   if(value != null && !value.equals("")){
		   retorno = funcionarios.buscarId(new Long(value));
		   
		   if(retorno == null){
			   String descricaoErro = "Funcionario não existe";
			   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);
				throw new ConverterException(message);
		   }
	   }
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		  
		  if(value != null){
			  Long codigo = ((Funcionario) value).getId();
			  return codigo == null ? "" : codigo.toString();
		  }
		return null;
	}

}

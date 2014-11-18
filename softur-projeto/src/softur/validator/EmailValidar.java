package softur.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValida")
public class EmailValidar implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent componente, Object objeto)
			throws ValidatorException {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher((String)objeto);
		if(!m.matches()){
			((UIInput)componente).setValid(false);
			FacesMessage message = new FacesMessage();
			message.setDetail("email inválido");
			message.setSummary("email inválido");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(componente.getClientId(context), message);
			
		}
		
	}
	
	

}

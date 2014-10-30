package softur.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import softur.entities.Cargo;
import softur.util.JpaUtil;

@FacesConverter(forClass=Cargo.class)
public class CargoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cargo retorno = null;
		
		if(value != null){
			EntityManager entityManager = JpaUtil.getEntityManager();
			Session session = entityManager.unwrap(Session.class);
			retorno = (Cargo) session.get(Cargo.class, new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Cargo) value).getId().toString();
		}
		return null;
	}

}

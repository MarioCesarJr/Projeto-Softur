package softur.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 ************************************************************************* 
 * CLASSE RESPONSAVEL POR ABRIR E FECHAR TRANSACOES COM O BANCO DE DADOS 
 *************************************************************************
 */

@WebFilter(servletNames = { "Faces Servlet" })
public class JpaSessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		EntityManager entityManager = JpaUtil.createEntityManager();
	
		try {
			
			entityManager.getTransaction().begin();
			
			chain.doFilter(request, response);
			
			entityManager.getTransaction().commit();
		
		} catch (Exception exception) {
			
			entityManager.getTransaction().rollback();
		
		} finally {
			
			entityManager.close();
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		JpaUtil.initFactory();

	}

	@Override
	public void destroy() {
		JpaUtil.closeFactory();

	}

}

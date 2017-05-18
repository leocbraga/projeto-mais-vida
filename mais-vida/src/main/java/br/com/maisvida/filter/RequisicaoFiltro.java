package br.com.maisvida.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.maisvida.service.LoginService;

@Component
public class RequisicaoFiltro implements Filter{

	@Autowired
	private LoginService loginService;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String token = request.getHeader("Authorization");
		
		
		//TODO verificar porque não está funcionando o filtro de url
		if(request.getRequestURL().toString().contains("api")  && token != null){
			if(!loginService.isTokenValido(token)){
				response.sendError(response.SC_FORBIDDEN);
				return;
			}
		}
		
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

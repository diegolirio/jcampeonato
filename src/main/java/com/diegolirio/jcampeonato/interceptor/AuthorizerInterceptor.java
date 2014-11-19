package com.diegolirio.jcampeonato.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		logger.info(uri);

		// Acesso das requisicao com system na path da uri somente para usuario logado.
		if(uri.contains("/system") && request.getSession().getAttribute("usuario") != null) { 
			return true;
		}
		
		// Se nao existir /system na path da uri considero uri's publicas, 
		//   considerando resources e static (css, img, js).
		if(uri.contains("/system") == false) {
			return true;
		}
		// se usuario estiver logado redireciona p/ principal, se nao p/ login
		response.sendRedirect(request.getSession().getAttribute("usuario") == null ? request.getContextPath()+"/usuario/login?next="+uri : request.getContextPath());
		return false;
	}
	
	

}

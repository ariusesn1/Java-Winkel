package com.java.config;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.java.entity.Account;
import com.java.service.SessionService;


@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService sessionService;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Account user = sessionService.get("user"); 

		if (user == null) { 
			sessionService.set("security-uri", uri);
			response.sendRedirect("/signin?error=Please-login!");
			return false;
		}
		if (user != null) {
			if (user.getRoles() != 1 ) {
				response.sendRedirect("/signin?error=Access-denied!");
				return false;
			}	
		}
		
		return true;
	}
	
	

}

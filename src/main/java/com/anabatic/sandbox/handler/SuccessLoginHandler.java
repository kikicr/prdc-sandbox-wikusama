package com.anabatic.sandbox.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.anabatic.sandbox.enumeration.RoleEnum;

public class SuccessLoginHandler implements AuthenticationSuccessHandler{
	private String[] url={"admin","me"};
	protected final Log log = LogFactory.getLog(getClass());
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
			try{
				response.sendRedirect(getRedirUrl(authentication.getAuthorities()));
			}
			catch(Exception e){
				
				e.printStackTrace();
			}
		
	}
	private String getRedirUrl(Collection<? extends GrantedAuthority> gr){
		String url="";
		for(GrantedAuthority g:gr){
			log.info(g.getAuthority());
			if(g.getAuthority().equals("ROLE_ADMIN")){
				url=this.url[0];
				break;
			}else if(g.getAuthority().equals("ROLE_USER")){
				url=this.url[1];
				break;
			}
		}
		return url;
	}

}

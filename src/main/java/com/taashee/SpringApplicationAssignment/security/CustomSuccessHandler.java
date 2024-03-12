package com.taashee.SpringApplicationAssignment.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		if(isAdmin(authentication)) {
			redirectStrategy.sendRedirect(request, response, "/getAllCourses");
		} else if(isInstructor(authentication)) {
			redirectStrategy.sendRedirect(request, response, "/getInstructorCourse");

		} else {
			redirectStrategy.sendRedirect(request, response, "/getStudentCourses");
		}
	}
	
	private boolean isAdmin(Authentication authentication) {
		return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	private boolean isInstructor(Authentication authentication) {
		return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"));
	}
}

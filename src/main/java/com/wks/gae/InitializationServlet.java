package com.wks.gae;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.googlecode.objectify.ObjectifyService;
import com.wks.gae.model.Person;
import com.wks.gae.model.PostalAddress;

public class InitializationServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ObjectifyService.register(Person.class);
		ObjectifyService.register(PostalAddress.class);
		
	}
}

package com.wks.gae.controller;

import com.threewks.thundr.view.jsp.JspView;
import com.wks.gae.dao.DAOFactory;

public class PersonController {

	private DAOFactory dao;
	
	public PersonController(DAOFactory dao){
		this.dao = dao;
	}
	
	public JspView home(){
		return new JspView("index.jsp");
	}
}

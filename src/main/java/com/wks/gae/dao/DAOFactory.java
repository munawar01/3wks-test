package com.wks.gae.dao;


public interface DAOFactory {

	public PersonDAO person();
	public PostalAddressDAO postalAddress();
}

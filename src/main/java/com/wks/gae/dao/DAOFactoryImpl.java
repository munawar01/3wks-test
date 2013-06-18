package com.wks.gae.dao;

import javax.inject.Singleton;

@Singleton
public class DAOFactoryImpl implements DAOFactory {

	@Override
	public PersonDAO person() {
		return new PersonDAO();
	}

	@Override
	public PostalAddressDAO postalAddress() {
		return new PostalAddressDAO();
	}

}

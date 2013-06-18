package com.wks.gae;

import com.threewks.thundr.injection.InjectionConfiguration;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.wks.gae.dao.DAOFactory;
import com.wks.gae.dao.DAOFactoryImpl;

public class GaeInjectionConfiguration implements InjectionConfiguration {

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
		injectionContext.inject(DAOFactoryImpl.class).as(DAOFactory.class);
	}

}

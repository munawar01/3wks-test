package com.wks.gae.model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import lombok.Data;

public @Data class Model implements Serializable {

	@Id
	private Long id;
	@Index
	private Date lastUpdated;
	
	//
	public Date getLastUpdated(){
		return new Date();
	}
}

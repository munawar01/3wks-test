package com.wks.gae.model;

import java.io.Serializable;

import lombok.Data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity(name = "person")
public @Data class Person extends Model implements Serializable {

	private String firstName;
	private String lastName;
	
	@Index
	private Long addressId;
	
	/*public Person(){}
	
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}*/
}

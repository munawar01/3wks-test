package com.wks.gae.model;

import java.io.Serializable;

import lombok.Data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity(name="postal_address")
@Index
public @Data class PostalAddress extends Model implements Serializable {

	private String address;
	private Long lat;
	private Long lng;
}

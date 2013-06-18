package com.wks.gae.util;

import java.util.List;
import lombok.Data;

/**
 * Full example JSON
 * http://maps.google.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway+Mountain+View+CA&sensor=true
 */
public @Data class GeocodeJson {

	private List<ResultsJson> results;
	private String status;
	
	public @Data class ResultsJson {
		private String formatted_address;
		private GeometryJson geometry;
	}
	
	public @Data class GeometryJson {
		private LocationJson location;
		private String location_type;
	}
	
	public @Data class LocationJson {
		private long lat;
		private long lng;
	}
}

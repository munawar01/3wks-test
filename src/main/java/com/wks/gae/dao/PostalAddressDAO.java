package com.wks.gae.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.wks.gae.model.PostalAddress;
import com.wks.gae.util.GeocodeJson;
import com.wks.gae.util.GeocodeJson.GeometryJson;

public class PostalAddressDAO extends BaseDAO<PostalAddress> {

	private final Logger LOGGER = Logger.getLogger(PostalAddressDAO.class.getName());
	private final String GEOCODING_BASE_URL = "http://maps.google.com/maps/api/geocode/json?address=";
	
	public PostalAddressDAO(){
		super(PostalAddress.class);
	}
	
	@Override
	public Long save(PostalAddress e) {
		setLatLng(e);
		return super.save(e);
	}
	
	private void setLatLng(PostalAddress address){
		
		try {
			URL u = new URL(GEOCODING_BASE_URL+address.getAddress());
			LOGGER.fine("GEO CODING URL "+u.toString());
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			
			uc.setDoOutput(true);
			uc.setRequestProperty("Host", u.getHost());
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// post
			/*PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(strBuffer.toString());
			pw.close();*/

			// read response
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String result = "";
			while((result = in.readLine()) != null){
				sb.append(result);
			}
			
			in.close();
			
			LOGGER.fine("GEOCODE RESULT "+sb.toString());
			
			Gson g = new Gson();
			GeocodeJson geocode = g.fromJson(sb.toString(), GeocodeJson.class);
			if(geocode.getStatus().equalsIgnoreCase("OK") && geocode.getResults() != null){
				if(geocode.getResults().size() > 0){
					GeometryJson geomentry = geocode.getResults().get(0).getGeometry();
					address.setLat(geomentry.getLocation().getLat());
					address.setLng(geomentry.getLocation().getLng());
				}
			}
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
}

package com.weather.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "location_config")
public class LocationConfiguration {
    @Id
    private String id;
    private String location;
    private String lattitude;
    private String logitude;
    private String timezone;


    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
    
    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getLattitude() {
	return lattitude;
    }

    public void setLattitude(String lattitude) {
	this.lattitude = lattitude;
    }

    public String getLogitude() {
	return logitude;
    }

    public void setLogitude(String logitude) {
	this.logitude = logitude;
    }

    public String getTimezone() {
	return timezone;
    }

    public void setTimezone(String timezone) {
	this.timezone = timezone;
    }

}

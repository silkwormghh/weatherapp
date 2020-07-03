package com.weather.app.api.darksky.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "weather_data")
public class DarkSkyResponseBean  implements Serializable {


    private static final long serialVersionUID = 6076801090243456153L;
    private String latitude;
    private String longitude;
    private String timezone;
    private DarkSkyDailyBean daily;

    
    public String getLatitude() {
	return latitude;
    }

    public void setLatitude(String latitude) {
	this.latitude = latitude;
    }

    public String getLongitude() {
	return longitude;
    }

    public void setLongitude(String longitude) {
	this.longitude = longitude;
    }

    public String getTimezone() {
	return timezone;
    }

    public void setTimezone(String timezone) {
	this.timezone = timezone;
    }
   
    
    public DarkSkyDailyBean getDaily() {
	return daily;
    }

    public void setDaily(DarkSkyDailyBean daily) {
	this.daily = daily;
    }

    @Override
    public String toString() {
	return "DarkSkyResponseBean [latitude=" + latitude + ", longitude=" + longitude + ", timezone=" + timezone
		+ ", daily=" + daily + "]";
    }

}

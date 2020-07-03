package com.weather.app.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weather_data")
public class WeatherData {
    @Id
    private String id;
    private LocalDateTime dateTimeField;
    private String location;
    private String latitude;
    private String longitude;
    private String timezone;
    private String apparentTemperature;
    private String apparentTemperatureHigh;
    private String apparentTemperatureHighTime;
    private String apparentTemperatureHighTimeDisplay;
    private String apparentTemperatureLow;
    private String apparentTemperatureLowTime;
    private String apparentTemperatureLowTimeDisplay;
    private String apparentTemperatureMax;
    private String apparentTemperatureMaxTime;
    private String apparentTemperatureMaxTimeDisplay;
    private String apparentTemperatureMin;
    private String apparentTemperatureMinTime;
    private String apparentTemperatureMinTimeDisplay;
    private String cloudCover;
    private String dewPoint;
    private String humidity;
    private String icon;
    private String moonPhase;
    private String nearestStormDistance;
    private String ozone;
    private String precipIntensity;
    private String precipIntensityError;
    private String precipIntensityMax;
    private String precipIntensityMaxTime;
    private String precipIntensityMaxTimeDisplay;
    private String precipProbability;
    private String precipType;
    private String pressure;
    private String summary;
    private String sunriseTime;
    private String sunriseTimeDisplay;

    private String sunsetTime;
    private String sunsetTimeDisplay;
    private String temperatureHigh;
    private String temperatureHighTime;
    private String temperatureHighTimeDisplay;
    private String temperatureLow;
    private String temperatureLowTime;
    private String temperatureLowTimeDisplay;
    private String temperatureMax;
    private String temperatureMaxTime;
    private String temperatureMaxTimeDisplay;
    private String temperatureMin;
    private String temperatureMinTime;
    private String temperatureMinTimeDisplay;
    private String time;
    private String dateDisplay;
    private String uvIndex;
    private String uvIndexTime;
    private String uvIndexTimeDisplay;
    private String visibility;
    private String windBearing;
    private String windGust;
    private String windGustTime;
    private String windGustTimeDisplay;
    private String windSpeed;

    public String getId() {
	return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }


    public LocalDateTime getDateTimeField() {
	return dateTimeField;
    }

    public void setDateTimeField(LocalDateTime dateTimeField) {
	this.dateTimeField = dateTimeField;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public String getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(String apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public String getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public void setApparentTemperatureHigh(String apparentTemperatureHigh) {
        this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    public String getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public void setApparentTemperatureHighTime(String apparentTemperatureHighTime) {
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    public String getApparentTemperatureHighTimeDisplay() {
	return apparentTemperatureHighTimeDisplay;
    }

    public void setApparentTemperatureHighTimeDisplay(String apparentTemperatureHighTimeDisplay) {
	this.apparentTemperatureHighTimeDisplay = apparentTemperatureHighTimeDisplay;
    }

    public String getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public void setApparentTemperatureLow(String apparentTemperatureLow) {
        this.apparentTemperatureLow = apparentTemperatureLow;
    }

    public String getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }

    public void setApparentTemperatureLowTime(String apparentTemperatureLowTime) {
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
    }

    public String getApparentTemperatureLowTimeDisplay() {
	return apparentTemperatureLowTimeDisplay;
    }

    public void setApparentTemperatureLowTimeDisplay(String apparentTemperatureLowTimeDisplay) {
	this.apparentTemperatureLowTimeDisplay = apparentTemperatureLowTimeDisplay;
    }

    public String getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(String apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public String getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(String apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public String getApparentTemperatureMaxTimeDisplay() {
	return apparentTemperatureMaxTimeDisplay;
    }

    public void setApparentTemperatureMaxTimeDisplay(String apparentTemperatureMaxTimeDisplay) {
	this.apparentTemperatureMaxTimeDisplay = apparentTemperatureMaxTimeDisplay;
    }

    public String getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(String apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public String getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(String apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public String getApparentTemperatureMinTimeDisplay() {
	return apparentTemperatureMinTimeDisplay;
    }

    public void setApparentTemperatureMinTimeDisplay(String apparentTemperatureMinTimeDisplay) {
	this.apparentTemperatureMinTimeDisplay = apparentTemperatureMinTimeDisplay;
    }

    public String getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(String cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public String getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(String nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public String getOzone() {
        return ozone;
    }

    public void setOzone(String ozone) {
        this.ozone = ozone;
    }

    public String getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(String precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public String getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(String precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    public String getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(String precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public String getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(String precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public String getPrecipIntensityMaxTimeDisplay() {
	return precipIntensityMaxTimeDisplay;
    }

    public void setPrecipIntensityMaxTimeDisplay(String precipIntensityMaxTimeDisplay) {
	this.precipIntensityMaxTimeDisplay = precipIntensityMaxTimeDisplay;
    }

    public String getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(String precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public String getSunriseTimeDisplay() {
	return sunriseTimeDisplay;
    }

    public void setSunriseTimeDisplay(String sunriseTimeDisplay) {
	this.sunriseTimeDisplay = sunriseTimeDisplay;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public String getSunsetTimeDisplay() {
	return sunsetTimeDisplay;
    }

    public void setSunsetTimeDisplay(String sunsetTimeDisplay) {
	this.sunsetTimeDisplay = sunsetTimeDisplay;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(String temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public String getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public void setTemperatureHighTime(String temperatureHighTime) {
        this.temperatureHighTime = temperatureHighTime;
    }

    public String getTemperatureHighTimeDisplay() {
	return temperatureHighTimeDisplay;
    }

    public void setTemperatureHighTimeDisplay(String temperatureHighTimeDisplay) {
	this.temperatureHighTimeDisplay = temperatureHighTimeDisplay;
    }

    public String getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(String temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public String getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public void setTemperatureLowTime(String temperatureLowTime) {
        this.temperatureLowTime = temperatureLowTime;
    }

    public String getTemperatureLowTimeDisplay() {
	return temperatureLowTimeDisplay;
    }

    public void setTemperatureLowTimeDisplay(String temperatureLowTimeDisplay) {
	this.temperatureLowTimeDisplay = temperatureLowTimeDisplay;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(String temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public String getTemperatureMaxTimeDisplay() {
	return temperatureMaxTimeDisplay;
    }

    public void setTemperatureMaxTimeDisplay(String temperatureMaxTimeDisplay) {
	this.temperatureMaxTimeDisplay = temperatureMaxTimeDisplay;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(String temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public String getTemperatureMinTimeDisplay() {
	return temperatureMinTimeDisplay;
    }

    public void setTemperatureMinTimeDisplay(String temperatureMinTimeDisplay) {
	this.temperatureMinTimeDisplay = temperatureMinTimeDisplay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDateDisplay() {
	return dateDisplay;
    }

    public void setDateDisplay(String dateDisplay) {
	this.dateDisplay = dateDisplay;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getUvIndexTime() {
        return uvIndexTime;
    }

    public void setUvIndexTime(String uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
    }

    public String getUvIndexTimeDisplay() {
	return uvIndexTimeDisplay;
    }

    public void setUvIndexTimeDisplay(String uvIndexTimeDisplay) {
	this.uvIndexTimeDisplay = uvIndexTimeDisplay;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(String windBearing) {
        this.windBearing = windBearing;
    }

    public String getWindGust() {
        return windGust;
    }

    public void setWindGust(String windGust) {
        this.windGust = windGust;
    }

    public String getWindGustTime() {
        return windGustTime;
    }

    public void setWindGustTime(String windGustTime) {
        this.windGustTime = windGustTime;
    }

    public String getWindGustTimeDisplay() {
	return windGustTimeDisplay;
    }

    public void setWindGustTimeDisplay(String windGustTimeDisplay) {
	this.windGustTimeDisplay = windGustTimeDisplay;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

}

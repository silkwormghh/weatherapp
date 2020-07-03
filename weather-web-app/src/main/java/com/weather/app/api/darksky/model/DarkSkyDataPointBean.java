package com.weather.app.api.darksky.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkSkyDataPointBean  implements Serializable {
    
    private static final long serialVersionUID = 7510216349585382119L;
    private String apparentTemperature;
    private String apparentTemperatureHigh;
    private String apparentTemperatureHighTime;
    private String apparentTemperatureLow;
    private String apparentTemperatureLowTime;
    private String apparentTemperatureMax;
    private String apparentTemperatureMaxTime;
    private String apparentTemperatureMin;
    private String apparentTemperatureMinTime;
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
    private String precipProbability;
    private String precipType;
    private String pressure;
    private String summary;
    private String sunriseTime;
    private String sunsetTime;
    private String temperatureHigh;
    private String temperatureHighTime;
    private String temperatureLow;
    private String temperatureLowTime;
    private String temperatureMax;
    private String temperatureMaxTime;
    private String temperatureMin;
    private String temperatureMinTime;
    private String time;
    private String uvIndex;
    private String uvIndexTime;
    private String visibility;
    private String windBearing;
    private String windGust;
    private String windGustTime;
    private String windSpeed;

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

    public String getSunsetTime() {
	return sunsetTime;
    }

    public void setSunsetTime(String sunsetTime) {
	this.sunsetTime = sunsetTime;
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

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
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

    public String getWindSpeed() {
	return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
	this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
	return "DarkSkyDataPointBean [apparentTemperature=" + apparentTemperature + ", apparentTemperatureHigh="
		+ apparentTemperatureHigh + ", apparentTemperatureHighTime=" + apparentTemperatureHighTime
		+ ", apparentTemperatureLow=" + apparentTemperatureLow + ", apparentTemperatureLowTime="
		+ apparentTemperatureLowTime + ", apparentTemperatureMax=" + apparentTemperatureMax
		+ ", apparentTemperatureMaxTime=" + apparentTemperatureMaxTime + ", apparentTemperatureMin="
		+ apparentTemperatureMin + ", apparentTemperatureMinTime=" + apparentTemperatureMinTime
		+ ", cloudCover=" + cloudCover + ", dewPoint=" + dewPoint + ", humidity=" + humidity + ", icon=" + icon
		+ ", moonPhase=" + moonPhase + ", nearestStormDistance=" + nearestStormDistance + ", ozone=" + ozone
		+ ", precipIntensity=" + precipIntensity + ", precipIntensityError=" + precipIntensityError
		+ ", precipIntensityMax=" + precipIntensityMax + ", precipIntensityMaxTime=" + precipIntensityMaxTime
		+ ", precipProbability=" + precipProbability + ", precipType=" + precipType + ", pressure=" + pressure
		+ ", summary=" + summary + ", sunriseTime=" + sunriseTime + ", sunsetTime=" + sunsetTime
		+ ", temperatureHigh=" + temperatureHigh + ", temperatureHighTime=" + temperatureHighTime
		+ ", temperatureLow=" + temperatureLow + ", temperatureLowTime=" + temperatureLowTime
		+ ", temperatureMax=" + temperatureMax + ", temperatureMaxTime=" + temperatureMaxTime
		+ ", temperatureMin=" + temperatureMin + ", temperatureMinTime=" + temperatureMinTime + ", time=" + time
		+ ", uvIndex=" + uvIndex + ", uvIndexTime=" + uvIndexTime + ", visibility=" + visibility
		+ ", windBearing=" + windBearing + ", windGust=" + windGust + ", windGustTime=" + windGustTime
		+ ", windSpeed=" + windSpeed + "]";
    }

}

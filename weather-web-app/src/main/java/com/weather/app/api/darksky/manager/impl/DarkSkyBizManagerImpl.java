package com.weather.app.api.darksky.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weather.app.api.darksky.client.IDarkSkyRestClient;
import com.weather.app.api.darksky.manager.IDarkSkyBizManager;
import com.weather.app.api.darksky.model.DarkSkyDataPointBean;
import com.weather.app.api.darksky.model.DarkSkyResponseBean;
import com.weather.app.document.LocationConfiguration;
import com.weather.app.document.WeatherData;
import com.weather.app.repository.ILocationConfigurationRepository;
import com.weather.app.repository.IWeatherDataCustomRepository;
import com.weather.app.resources.TimeUtils;

@Component
public class DarkSkyBizManagerImpl implements IDarkSkyBizManager {

    private final Logger logger = LogManager.getLogger(DarkSkyBizManagerImpl.class);

    @Autowired
    ILocationConfigurationRepository locationRepository;

    @Autowired
    IWeatherDataCustomRepository weatherDataCustomRepository;

    @Autowired
    IDarkSkyRestClient darkSkyRestClient;

    @Override
    public void retrieveDarkSkyData() {
	List<LocationConfiguration> lst = this.locationRepository.findAll();

	if (CollectionUtils.isNotEmpty(lst)) {
	    logger.info("Num of Locations retrieved " + lst.size());

	    for (LocationConfiguration locationConfig : lst) {
		String lattitude = locationConfig.getLattitude();
		String longitude = locationConfig.getLogitude();
		String location = locationConfig.getLocation();
		String timezone = locationConfig.getTimezone();

		if (this.isNeedToRetrieve(location, timezone)) {
		    logger.info("Retrieving for " + lattitude + ", " + longitude + ", " + location);

		    DarkSkyResponseBean bean = this.darkSkyRestClient.retrieveWeatherData(lattitude, longitude, timezone);
		    this.weatherDataCustomRepository.insert(mapToEntiy(bean, location));

		    if (bean != null) {
			logger.info(" Bean:  " + bean.toString());
		    }
		}else {
		    logger.info("Skipping retrieval for " + lattitude + ", " + longitude + ", " + location);
		}
	    }

	} else {
	    logger.info("Nothing retrieved from db");
	}

    }
    
    @Override
    public List<WeatherData> getWeatherDataForToday() {
	List<LocationConfiguration> locationConfigurations = this.locationRepository.findAll();
	List<WeatherData> lstOfWeatherData = new ArrayList<>();
	for (LocationConfiguration locationConfig : locationConfigurations) {
	    WeatherData data = this.weatherDataCustomRepository.findTodaysForeCastByLocationAndTimezone(locationConfig.getLocation(), locationConfig.getTimezone());
	    if (data != null) {
		lstOfWeatherData.add(data);
	    }
	}

	return lstOfWeatherData;
    }
    
    @Override
    public void housekeepOldData() {
	List<LocationConfiguration> locationConfigurations = this.locationRepository.findAll();
	for (LocationConfiguration locationConfig : locationConfigurations) {
	    this.weatherDataCustomRepository.removeDataFromThreeDaysAgoByLocationAndTimezone(locationConfig.getLocation(), locationConfig.getTimezone());
	}
	
    }

    private boolean isNeedToRetrieve(String location, String timezone) {
	boolean isRetrieve = true;
	if( this.weatherDataCustomRepository.findTodaysForeCastByLocationAndTimezone(location, timezone) != null) {
	    isRetrieve = false;
	}
	return isRetrieve;
    }

    private List<WeatherData> mapToEntiy(DarkSkyResponseBean bean, String location) {
	List<WeatherData> weatherDataLst = new ArrayList<>();

	if (bean.getDaily() != null && CollectionUtils.isNotEmpty(bean.getDaily().getData())) {
		WeatherData data = new WeatherData();
		data.setLocation(location);
		data.setLatitude(bean.getLatitude());
		data.setLongitude(bean.getLongitude());
		data.setTimezone(bean.getTimezone());

		for (DarkSkyDataPointBean dataBean : bean.getDaily().getData()) {
		    data.setApparentTemperature(dataBean.getApparentTemperature());
		    data.setApparentTemperatureHigh(dataBean.getApparentTemperatureHigh());

		    data.setApparentTemperatureHighTime(dataBean.getApparentTemperatureHighTime());
		    data.setApparentTemperatureHighTimeDisplay(TimeUtils.convertUnixTimeToSimpleDateFormat(
			    dataBean.getApparentTemperatureHighTime(), bean.getTimezone()));

		    data.setApparentTemperatureLow(dataBean.getApparentTemperatureLow());

		    data.setApparentTemperatureLowTime(dataBean.getApparentTemperatureLowTime());
		    data.setApparentTemperatureLowTimeDisplay(TimeUtils.convertUnixTimeToSimpleDateFormat(
			    dataBean.getApparentTemperatureLowTime(), bean.getTimezone()));

		    data.setApparentTemperatureMax(dataBean.getApparentTemperatureMax());

		    data.setApparentTemperatureMaxTime(dataBean.getApparentTemperatureMaxTime());
		    data.setApparentTemperatureMaxTimeDisplay(TimeUtils.convertUnixTimeToSimpleDateFormat(
			    dataBean.getApparentTemperatureMaxTime(), bean.getTimezone()));
		    data.setApparentTemperatureMin(dataBean.getTemperatureMin());

		    data.setApparentTemperatureMinTime(dataBean.getApparentTemperatureMin());
		    data.setApparentTemperatureMinTimeDisplay(TimeUtils.convertUnixTimeToSimpleDateFormat(
			    dataBean.getApparentTemperatureMinTime(), bean.getTimezone()));

		    data.setCloudCover(dataBean.getCloudCover());
		    data.setDewPoint(dataBean.getDewPoint());
		    data.setHumidity(dataBean.getHumidity());
		    data.setIcon(dataBean.getIcon());
		    data.setMoonPhase(dataBean.getMoonPhase());
		    data.setNearestStormDistance(dataBean.getNearestStormDistance());
		    data.setOzone(dataBean.getOzone());
		    data.setPrecipIntensity(dataBean.getPrecipIntensity());
		    data.setPrecipIntensityError(dataBean.getPrecipIntensityError());
		    data.setPrecipIntensityMax(dataBean.getPrecipIntensityMax());
		    data.setPrecipIntensityMaxTime(dataBean.getPrecipIntensityMaxTime());
		    data.setPrecipProbability(dataBean.getPrecipProbability());
		    data.setPrecipType(dataBean.getPrecipType());
		    data.setPressure(dataBean.getPressure());
		    data.setSummary(dataBean.getSummary());

		    data.setSunriseTime(dataBean.getSunriseTime());

		    data.setSunriseTimeDisplay(
			    TimeUtils.convertUnixTimeToSimpleDateFormat(dataBean.getSunriseTime(), bean.getTimezone()));
		    data.setSunsetTime(dataBean.getSunsetTime());
		    data.setSunsetTimeDisplay(
			    TimeUtils.convertUnixTimeToSimpleDateFormat(dataBean.getSunsetTime(), bean.getTimezone()));

		    data.setTemperatureHigh(dataBean.getTemperatureHigh());
		    data.setTemperatureHighTime(dataBean.getTemperatureHighTime());
		    data.setTemperatureHighTimeDisplay(dataBean.getTemperatureHighTime());
		    data.setTemperatureLow(dataBean.getTemperatureLow());
		    data.setTemperatureLowTime(dataBean.getTemperatureLowTime());

		    data.setTemperatureLowTimeDisplay(TimeUtils
			    .convertUnixTimeToSimpleDateFormat(dataBean.getTemperatureLowTime(), bean.getTimezone()));
		    data.setTemperatureMax(dataBean.getTemperatureMax());
		    data.setTemperatureMaxTime(dataBean.getTemperatureMaxTime());
		    data.setTemperatureMaxTimeDisplay(TimeUtils
			    .convertUnixTimeToSimpleDateFormat(dataBean.getTemperatureMaxTime(), bean.getTimezone()));

		    data.setTemperatureMin(dataBean.getTemperatureMin());
		    data.setTemperatureMinTime(dataBean.getTemperatureMinTime());
		    data.setTemperatureMinTimeDisplay(TimeUtils
			    .convertUnixTimeToSimpleDateFormat(dataBean.getTemperatureMinTime(), bean.getTimezone()));

		    data.setTime(dataBean.getTime());
		    data.setTimeDisplay(TimeUtils
			    .convertUnixTimeToSimpleDateFormat(dataBean.getTime(), bean.getTimezone()));
		    data.setDateTimeField(
			    TimeUtils.convertUnixTimeToLocalDateTime(dataBean.getTime(), bean.getTimezone()));

		    data.setUvIndex(dataBean.getUvIndex());

		    data.setUvIndexTime(
			    TimeUtils.convertUnixTimeToSimpleDateFormat(dataBean.getUvIndexTime(), bean.getTimezone()));

		    data.setVisibility(dataBean.getVisibility());
		    data.setWindBearing(dataBean.getWindBearing());
		    data.setWindGust(dataBean.getWindGust());

		    data.setWindGustTime(dataBean.getWindGustTime());

		    data.setWindGustTimeDisplay(TimeUtils.convertUnixTimeToSimpleDateFormat(dataBean.getWindGustTime(),
			    bean.getTimezone()));

		    data.setWindSpeed(dataBean.getWindSpeed());

		}

		weatherDataLst.add(data);

	    }

	return weatherDataLst;

    }

 

}

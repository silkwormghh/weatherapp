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
import com.weather.app.resources.Constants;
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
	    logger.info(String.format(Constants.NUM_OF_LOCATIONS_RET, lst.size()));

	    for (LocationConfiguration locationConfig : lst) {
		String lattitude = locationConfig.getLattitude();
		String longitude = locationConfig.getLogitude();
		String location = locationConfig.getLocation();
		String timezone = locationConfig.getTimezone();

		if (this.isNeedToRetrieve(location, timezone)) {
		    logger.info(String.format(Constants.LAT_LOG_LOCATION_USED_FOR_RET, lattitude, longitude, location));

		    DarkSkyResponseBean bean = this.darkSkyRestClient.retrieveWeatherData(lattitude, longitude,
			    timezone);
		    this.weatherDataCustomRepository.insert(mapToEntiy(bean, location));
		} else {
		    logger.info(String.format(Constants.LAT_LOG_LOCATION_SKIPPED, lattitude, longitude, location));
		}
	    }

	} else {
	    logger.info(Constants.NTH_RET_FM_DB);
	}

    }

    @Override
    public List<WeatherData> getWeatherDataForToday() {
	List<LocationConfiguration> locationConfigurations = this.locationRepository.findAll();
	List<WeatherData> lstOfWeatherData = new ArrayList<>();
	for (LocationConfiguration locationConfig : locationConfigurations) {
	    WeatherData data = this.weatherDataCustomRepository.findTodaysForeCastByLocationAndTimezone(
		    locationConfig.getLocation(), locationConfig.getTimezone());
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
	    this.weatherDataCustomRepository.removeDataFromThreeDaysAgoByLocationAndTimezone(
		    locationConfig.getLocation(), locationConfig.getTimezone());
	}

    }

    private boolean isNeedToRetrieve(String location, String timezone) {
	boolean isRetrieve = true;
	if (this.weatherDataCustomRepository.findTodaysForeCastByLocationAndTimezone(location, timezone) != null) {
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
		data.setApparentTemperatureLow(dataBean.getApparentTemperatureLow());
		data.setApparentTemperatureMax(dataBean.getApparentTemperatureMax());
		data.setApparentTemperatureMin(dataBean.getTemperatureMin());
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
		data.setTemperatureHigh(dataBean.getTemperatureHigh());
		data.setTemperatureLow(dataBean.getTemperatureLow());
		data.setTemperatureMax(dataBean.getTemperatureMax());
		data.setTemperatureMin(dataBean.getTemperatureMin());
		data.setUvIndex(dataBean.getUvIndex());
		data.setVisibility(dataBean.getVisibility());
		data.setWindBearing(dataBean.getWindBearing());
		data.setWindGust(dataBean.getWindGust());
		data.setWindSpeed(dataBean.getWindSpeed());

		// Time attributes
		data.setApparentTemperatureLowTime(dataBean.getApparentTemperatureLowTime());
		data.setApparentTemperatureMaxTime(dataBean.getApparentTemperatureMaxTime());
		data.setApparentTemperatureMinTime(dataBean.getApparentTemperatureMin());
		data.setSunriseTime(dataBean.getSunriseTime());
		data.setSunsetTime(dataBean.getSunsetTime());
		data.setTemperatureHighTime(dataBean.getTemperatureHighTime());
		data.setTemperatureLowTime(dataBean.getTemperatureLowTime());
		data.setTemperatureMaxTime(dataBean.getTemperatureMaxTime());
		data.setTemperatureMinTime(dataBean.getTemperatureMinTime());
		data.setTime(dataBean.getTime());
		data.setApparentTemperatureHighTime(dataBean.getApparentTemperatureHighTime());
		data.setWindGustTime(dataBean.getWindGustTime());
		data.setDateTimeField(TimeUtils.convertUnixTimeToLocalDateTime(dataBean.getTime(), bean.getTimezone()));

		// Format for display purpose

		data.setApparentTemperatureLowTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getApparentTemperatureLowTime(), bean.getTimezone()));

		data.setApparentTemperatureMaxTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getApparentTemperatureMaxTime(), bean.getTimezone()));

		data.setApparentTemperatureMinTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getApparentTemperatureMinTime(), bean.getTimezone()));

		data.setSunriseTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getSunriseTime(), bean.getTimezone()));
		
		data.setSunsetTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getSunsetTime(), bean.getTimezone()));

		data.setTemperatureHighTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getTemperatureHighTime(), bean.getTimezone()));

		data.setTemperatureLowTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getTemperatureLowTime(), bean.getTimezone()));

		data.setTemperatureMaxTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getTemperatureMaxTime(), bean.getTimezone()));

		data.setTemperatureMinTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getTemperatureMinTime(), bean.getTimezone()));

		data.setDateDisplay(TimeUtils.getDateFromUnixTime(dataBean.getTime(), bean.getTimezone()));
		
		data.setTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getTime(), bean.getTimezone()));
		data.setApparentTemperatureHighTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getApparentTemperatureHighTime(), bean.getTimezone()));

		data.setWindGustTimeDisplay(TimeUtils.getTimeFromUnixTime(dataBean.getWindGustTime(),bean.getTimezone()));

		data.setUvIndexTime(TimeUtils.getTimeFromUnixTime(dataBean.getUvIndexTime(), bean.getTimezone()));

	    }

	    weatherDataLst.add(data);

	}

	return weatherDataLst;

    }

}

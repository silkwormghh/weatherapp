package com.weather.app.repository.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.weather.app.document.WeatherData;
import com.weather.app.repository.IWeatherDataCustomRepository;
import com.weather.app.repository.IWeatherDataRepository;
import com.weather.app.resources.Constants;

@Component
public class WeatherDataCustomRepositoryImpl implements IWeatherDataCustomRepository {


    private MongoTemplate mongoTemplate;
    private IWeatherDataRepository weatherDataRepoistory;
    
    @Autowired
    public WeatherDataCustomRepositoryImpl(MongoTemplate mongoTemplate, IWeatherDataRepository weatherDataRepoistory) {
        this.mongoTemplate = mongoTemplate;
        this.weatherDataRepoistory = weatherDataRepoistory;
    }


    @Override
    public void insert(List<WeatherData> lstOfWeatherData) {
	this.weatherDataRepoistory.insert(lstOfWeatherData);
    }


    @Override
    public WeatherData findById(String id) {
	Optional<WeatherData> optionalWeatherData =  this.weatherDataRepoistory.findById(id);
	if(optionalWeatherData.isPresent()) {
	    return optionalWeatherData.get();
	}
	return null;
    }


    @Override
    public WeatherData findTodaysForeCastByLocationAndTimezone(String location, String timezone) {
	LocalDateTime today = LocalDateTime.now().atZone(ZoneId.of(timezone)).toLocalDateTime().truncatedTo(ChronoUnit.DAYS);
	LocalDateTime tmrw = today.plusDays(1).truncatedTo(ChronoUnit.DAYS);
	Query query = new Query().addCriteria(Criteria.where(Constants.DATE_TIME_FIELD).gte(today).lt(tmrw));
	query.addCriteria(Criteria.where(Constants.LOCATION).is(location));
	return mongoTemplate.findOne(query, WeatherData.class);
    }


    @Override
    public void removeDataFromThreeDaysAgoByLocationAndTimezone(String location, String timezone) {
	LocalDateTime threeDaysAgo = LocalDateTime.now().minusDays(3).atZone(ZoneId.of(timezone)).toLocalDateTime().truncatedTo(ChronoUnit.DAYS);
	Query query = new Query().addCriteria(Criteria.where(Constants.DATE_TIME_FIELD).lte(threeDaysAgo));
	mongoTemplate.findAllAndRemove(query, WeatherData.class);
	
    }


}

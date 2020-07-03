package com.weather.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.weather.app.document.WeatherData;

public interface IWeatherDataRepository extends MongoRepository<WeatherData, String> {
   
}

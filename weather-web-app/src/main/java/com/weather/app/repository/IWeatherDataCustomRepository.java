package com.weather.app.repository;

import java.util.List;
import com.weather.app.document.WeatherData;

public interface IWeatherDataCustomRepository {
    
    void insert(List<WeatherData> lstOfWeatherData);
    
    WeatherData findById(String id);
    
    WeatherData findTodaysForeCastByLocationAndTimezone(String location, String timezone);
    
   void removeDataFromThreeDaysAgoByLocationAndTimezone(String location, String timezone);
}

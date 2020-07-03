package com.weather.app.api.darksky.manager;

import java.util.List;

import com.weather.app.document.WeatherData;

public interface IDarkSkyBizManager {
    
    void retrieveDarkSkyData();
    
    void housekeepOldData();

    List<WeatherData> getWeatherDataForToday();
}

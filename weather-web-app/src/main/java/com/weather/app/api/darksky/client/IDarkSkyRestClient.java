package com.weather.app.api.darksky.client;

import com.weather.app.api.darksky.model.DarkSkyResponseBean;

public interface IDarkSkyRestClient{
      
    
    DarkSkyResponseBean retrieveWeatherData(String lattitude, String logitude, String timeZone);
 

    
}

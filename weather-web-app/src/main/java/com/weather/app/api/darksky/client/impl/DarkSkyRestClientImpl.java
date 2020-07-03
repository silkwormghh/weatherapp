package com.weather.app.api.darksky.client.impl;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.app.api.darksky.client.IDarkSkyRestClient;
import com.weather.app.api.darksky.model.DarkSkyResponseBean;
import com.weather.app.repository.IConfigurationCustomRepository;
import com.weather.app.resources.Constants;
import com.weather.app.resources.TimeUtils;

@Component
public class DarkSkyRestClientImpl implements IDarkSkyRestClient {
    
    private final Logger logger = LogManager.getLogger(DarkSkyRestClientImpl.class);    

    @Autowired
    IConfigurationCustomRepository configRepo;    
    
    public DarkSkyResponseBean retrieveWeatherData(String lattitude, String logitude, String timeZone) {
	String secretKey = this.configRepo.findSecretKey();
   	DarkSkyResponseBean bean = null;
   	if (StringUtils.isNoneBlank(lattitude, logitude, secretKey, timeZone)) {
   	    bean = getData(lattitude, logitude, secretKey, timeZone);
   	} else {
   	    this.logger.info(String.format(Constants.DARK_SKY_VAL_ARE_EMPTY, lattitude, logitude, timeZone,
   		    StringUtils.isEmpty(secretKey)));
   	}

   	return bean;
       }

       private DarkSkyResponseBean getData(String lattitude, String logitude, String secretKey, String timeZone) {
   	DarkSkyResponseBean result = null;
   	String unixTimeStamp = TimeUtils.getDateInUnix(LocalDateTime.now(), timeZone);
   	
   	String url = String.format(this.configRepo.findDarkApiUrl(), secretKey, lattitude, logitude, unixTimeStamp);

   	RestTemplate restTemplate = new RestTemplate();
   	
   	this.logger.info(String.format(Constants.DARK_SKY_RESQUEST, url));


   	result = restTemplate.getForObject(url, DarkSkyResponseBean.class);

   	this.logger.info(String.format(Constants.DARK_SKY_RESPONSE, result != null ? result.toString() : null));
   	return result;

       }



    
}

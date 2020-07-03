package com.weather.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weather.app.api.darksky.manager.IDarkSkyBizManager;

@SpringBootApplication
public class WeatherWebAppApplication implements CommandLineRunner {

    
    @Autowired
    IDarkSkyBizManager darkSkyBizManager;
    
    public static void main(String[] args) {
	SpringApplication.run(WeatherWebAppApplication.class, args);
    }

   
    @Override
    public void run(String... args) throws Exception {
	this.darkSkyBizManager.retrieveDarkSkyData();
    }

}

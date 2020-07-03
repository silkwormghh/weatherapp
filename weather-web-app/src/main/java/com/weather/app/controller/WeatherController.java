package com.weather.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weather.app.api.darksky.manager.IDarkSkyBizManager;
import com.weather.app.document.WeatherData;
import com.weather.app.repository.IWeatherDataCustomRepository;
import com.weather.app.resources.Constants;

@Controller
@RequestMapping("/weather/")
public class WeatherController {

    private final IWeatherDataCustomRepository weatherDataRepository;

    private final IDarkSkyBizManager darkSkyBizManager;

    @Autowired
    public WeatherController(IWeatherDataCustomRepository weatherDataRepository, IDarkSkyBizManager darkSkyBizManager) {
	this.weatherDataRepository = weatherDataRepository;
	this.darkSkyBizManager = darkSkyBizManager;
    }

    @GetMapping(Constants.LIST_PATH)
    public String showAllDetails(Model model) {
	model.addAttribute(Constants.WEATHER_DATA, darkSkyBizManager.getWeatherDataForToday());
	return Constants.INDEX;
    }

    @GetMapping(Constants.REFRESH_PATH)
    public String refreshModel(Model model) {
	this.darkSkyBizManager.retrieveDarkSkyData();
	showAllDetails(model);
	return Constants.INDEX;
    }

    @GetMapping(Constants.DETAILS_ID_PATH)
    public String showUpdateForm(@PathVariable(Constants.ID) String id, Model model) {
	WeatherData data = this.weatherDataRepository.findById(id);
	model.addAttribute(Constants.DETAIL, data);
	return Constants.SHOW_DETAILS;
    }



}

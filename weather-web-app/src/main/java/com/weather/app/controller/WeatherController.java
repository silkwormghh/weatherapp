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

    @GetMapping("list")
    public String showAllDetails(Model model) {
	model.addAttribute("weatherData", darkSkyBizManager.getWeatherDataForToday());
	return "index";
    }

    @GetMapping("list/refresh")
    public String refreshModel(Model model) {
	this.darkSkyBizManager.retrieveDarkSkyData();
	showAllDetails(model);
	return "index";
    }

    @GetMapping("details/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
	WeatherData data = this.weatherDataRepository.findById(id);
	model.addAttribute("detail", data);
	return "show-details";
    }



}

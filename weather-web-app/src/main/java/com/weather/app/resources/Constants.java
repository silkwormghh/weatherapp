package com.weather.app.resources;

public interface Constants {

    static final String DARK_SKY_URL = "https://api.darksky.net/forecast/%s/%s,%s,%s?exclude=currently,minutely,hourly,alerts,flags&units=si";
    
    //Logging statements
    static final String DARK_SKY_VAL_ARE_EMPTY = "Parameters are empty. lattitude {%s}, logitude {%s}, timezone {%s}, secretKeyIsNull {%s}";
    static final String DARK_SKY_RESQUEST = "URL: {%s}";
    static final String DARK_SKY_RESPONSE = "PayLoad {%s}";
    static final String NUM_OF_LOCATIONS_RET = "Num of Locations retrieved {%s}";
    static final String LAT_LOG_LOCATION_USED_FOR_RET = "Retrieving for {%s}, {%s}, {%s}";
    static final String LAT_LOG_LOCATION_SKIPPED = "Skipping retrieval for {%s}, {%s}, {%s}";
    static final String NTH_RET_FM_DB = "Nothing retrieved from db";
    
    //Document Names
    static final String DATE_TIME_FIELD = "dateTimeField";
    static final String LOCATION = "location";
    static final String CONFIG = "config";
    
    //Config Values
    static final String SECRET_KEY_CONFIG = "secret-key";
    static final String DARK_SKY_URL_CONFIG = "dark-sky-url";
    
  //HTML TEMPLATE Pages
    static final String INDEX = "index" ;
    static final String SHOW_DETAILS = "show-details" ;
    
    //Webservice constants
    static final String LIST_PATH = "list";
    static final String REFRESH_PATH = "list/refresh";
    static final String DETAILS_ID_PATH = "details/{id}";
    static final String ID = "id";
    static final String DETAIL = "detail";
    static final String WEATHER_DATA = "weatherData";
}

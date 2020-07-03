package com.weather.app.resources;

public interface Constants {

    static final String DARK_SKY_URL = "https://api.darksky.net/forecast/%s/%s,%s,%s?exclude=currently,minutely,hourly,alerts,flags&units=si";
    static final String DARK_SKY_VAL_ARE_EMPTY = "Parameters are empty. lattitude [%s], logitude [%s], timezone [%s], secretKeyIsNull [%s]";
    static final String DARK_SKY_RESQUEST = "URL: [%s]";
    static final String DARK_SKY_RESPONSE = "PayLoad [%s]";
}

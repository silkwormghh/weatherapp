package com.weather.app.resources;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeUtils {
    private final static Logger logger = LogManager.getLogger(TimeUtils.class);
    
    private static final String SIMPLE_DATE_FORMAT = "dd/MM/yyyy HH:mm";

    public static String convertUnixTimeToSimpleDateFormat(String unixTime, String timeZone) {
	String date = null;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);
	LocalDateTime dateTime = getLocalDateTimeFromUnixTime(unixTime, timeZone);
	if(dateTime != null) {
	    date = dateTime.format(formatter);
	}
	return date;
    }

    public static LocalDateTime convertUnixTimeToLocalDateTime(String unixTime, String timeZone) {
	return getLocalDateTimeFromUnixTime(unixTime, timeZone);
    }
    
    public static String getDateInUnix(LocalDateTime dateTime, String timeZone) {
	String unixDateTimeStr = null;
	if(dateTime != null && StringUtils.isNotEmpty(timeZone)) {
	   long unixDateTimeInSecs = dateTime.atZone(ZoneId.of(timeZone)).toInstant().toEpochMilli() / 1000L;
	   unixDateTimeStr = unixDateTimeInSecs + "";
	}
	return unixDateTimeStr;
    }

    private static LocalDateTime getLocalDateTimeFromUnixTime(String unixTime, String timeZone) {
	LocalDateTime dateTime = null;
	try {

	    if (StringUtils.isNoneEmpty(unixTime, timeZone)) {
		dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(unixTime)),
			ZoneId.of(timeZone));
	    }

	} catch (NumberFormatException e) {

	    logger.error(e, e);
	}

	return dateTime;
    }

}

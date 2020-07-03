package com.weather.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "configuration")
public class Configuration {
    @Id
    private String id;
    private String key;
    private String config;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getConfig() {
	return config;
    }

    public void setConfig(String config) {
	this.config = config;
    }

}

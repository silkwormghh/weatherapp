package com.weather.app.repository.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.weather.app.document.Configuration;
import com.weather.app.repository.IConfigurationCustomRepository;
import com.weather.app.resources.Constants;

@Component
public class ConfigurationCustomRepositoryImpl implements IConfigurationCustomRepository {

    private MongoTemplate mongoTemplate;
    
    @Autowired
    public ConfigurationCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public String findSecretKey() {
	return this.findConfigValue("secret-key", null);
    }
    
    @Override
    public String findDarkApiUrl() {
	return this.findConfigValue("dark-sky-url", Constants.DARK_SKY_URL);
    }
    
    private String findConfigValue(String configName, String defaultValue) {
	String key = null;
	Query query = new Query(Criteria.where("config").is(configName));
	
	List<Configuration>  lst = mongoTemplate.find(query, Configuration.class);

	if(CollectionUtils.isNotEmpty(lst)) {
	    key = lst.get(0).getKey();
	}else {
	    key = defaultValue;
	}
	return key;
    }

}

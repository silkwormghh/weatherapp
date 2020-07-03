package com.weather.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.weather.app.document.LocationConfiguration;

public interface ILocationConfigurationRepository extends MongoRepository<LocationConfiguration, String> {


}

package com.weather.app.repository;

public interface IConfigurationCustomRepository {

    String findSecretKey();

    String findDarkApiUrl();
}

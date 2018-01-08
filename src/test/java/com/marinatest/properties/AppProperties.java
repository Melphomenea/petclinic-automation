package com.marinatest.properties;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private static AppProperties instance = null;

    Properties properties = new Properties();

    public static AppProperties getinstance() {
        if(instance == null) {
            instance = new AppProperties();
        }
        return instance;
    }

    public AppProperties () {
        String appPropertiesFile = "app.properties";
        String localPropertiesFile = "local.properties";

        loadProperties(appPropertiesFile);
        loadProperties(localPropertiesFile);
    }

    public String getProperty(String key) { return properties.getProperty(key); }

    private void loadProperties(String fileName) {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (NullPointerException|IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


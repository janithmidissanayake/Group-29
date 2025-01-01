package com.group_29.ui_testing.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties")){
            props.load(input);

        } catch (Exception e){
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getProperty(String key){
        return props.getProperty(key);
    }
}

package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties properties;
    private final String propertyFilePath= "./Configuration/config.properties";
    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser != null){
            return browser;
        } else {
            throw new RuntimeException("url not specified in the Configuration.properties file.");
        }
    }

    public String getURL(){
        String url = properties.getProperty("baseURL");
        if(url != null){
            return url;
        } else {
            throw new RuntimeException("URL not specified in the Configuration.properties file.");
        }
    }

    public String getValidUser(){
        String user = properties.getProperty("user_valid");
        if(user != null){
            return user;
        } else {
            throw new RuntimeException("Valid Username not specified in the Configuration.properties file.");
        }
    }

    public String getInvalidUser(){
        String user = properties.getProperty("user_invalid");
        if(user != null){
            return user;
        } else {
            throw new RuntimeException("Invalid Username not specified in the Configuration.properties file.");
        }
    }

    public String getValidPsw(){
        String psw = properties.getProperty("psw_valid");
        if(psw != null){
            return psw;
        } else {
            throw new RuntimeException("Valid Password not specified in the Configuration.properties file.");
        }
    }

    public String getInvalidPsw(){
        String psw = properties.getProperty("psw_invalid");
        if(psw != null){
            return psw;
        } else {
            throw new RuntimeException("Invalid Password not specified in the Configuration.properties file.");
        }
    }

    public String getErrorMsgInvalidPsw(){
        String msg = properties.getProperty("msg_InvalidPsw");
        if(msg != null){
            return msg;
        } else {
            throw new RuntimeException("Error message on Invalid Password not specified in the Configuration.properties file.");
        }
    }

    public String getErrorMsgInvalidUser(){
        String msg = properties.getProperty("msg_InvalidUser");
        if(msg != null){
            return msg;
        } else {
            throw new RuntimeException("Error message on Invalid Username not specified in the Configuration.properties file.");
        }
    }

    public String getErrorMsgEmptyPsw(){
        String msg = properties.getProperty("msg_EmptyPsw");
        if(msg != null){
            return msg;
        } else {
            throw new RuntimeException("Error message on Empty Password not specified in the Configuration.properties file.");
        }
    }

    public String getErrorMsgEmptyForm(){
        String msg = properties.getProperty("msg_EmptyForm");
        if(msg != null){
            return msg;
        } else {
            throw new RuntimeException("Error message on Empty Form not specified in the Configuration.properties file.");
        }
    }
}

package actiondefs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesFileReader {

    private Properties properties;
    String path = System.getProperty("user.dir");
    private final String propertyFilePath = path + "\\Config.properties";

    public ConfigPropertiesFileReader() {
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

    public String getBaseUrl() {

        String BaseUrl = properties.getProperty("BaseUrlConfig");

        if (BaseUrl != null)
            return BaseUrl;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");

    }

}

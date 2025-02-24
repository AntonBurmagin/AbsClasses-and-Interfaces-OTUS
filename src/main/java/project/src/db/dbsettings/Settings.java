package project.src.db.dbsettings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Settings {

    public Map<String, String> getSettings(String path) {
        Map<String, String> result = new HashMap<>();
        Properties properties =  new Properties();

        try {
            properties.load(new FileInputStream(path));
            for (String key : properties.stringPropertyNames()) {
                result.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}

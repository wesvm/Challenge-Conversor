package converter.ConfigReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "config.properties";
    private final Properties properties;

    public ConfigReader() throws IOException{
        InputStream inputStream = new FileInputStream(CONFIG_FILE);
        properties = new Properties();
        properties.load(inputStream);
    }

    public String getApiUrl(){return properties.getProperty("urlApi");}
    public String getAppId(){return properties.getProperty("appId");}

}

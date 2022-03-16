package readers;

import java.util.Properties;

public class PropReader {
    public static String read(String key, Properties prop) {
        //get the property value and print it out
        return prop.getProperty(key);
    }
}

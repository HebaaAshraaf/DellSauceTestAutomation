package readers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public static Object[][] JsonReader(String s) {

        String filePath = "src/main/resources/testdata/" + s +"testdata.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = null;
        try {
            jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        } catch (org.json.simple.parser.ParseException e) {
            exceptions.ExceptionsMessages.JSONParseMsg(e);
        } catch (FileNotFoundException e) {
            exceptions.ExceptionsMessages.FileNotFoundMsg(e);
        } catch (IOException e) {
            exceptions.ExceptionsMessages.IOMsg(e);
        }
        String[][] arrayJSONData = new String[jarray.size()][2];
        Integer i = 0;
        for (Object jsonObj : jarray) {
            JSONObject searchData = (JSONObject) jsonObj;
            arrayJSONData[i][0] = (String) searchData.get("UserName");
            arrayJSONData[i][1] = (String) searchData.get("Password");
            i++;
        }
        return arrayJSONData;
    }
}

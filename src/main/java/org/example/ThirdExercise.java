package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class ThirdExercise {

    public String readJsonFile(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filename);
        Object obj = parser.parse(reader);
        JSONObject depedencies = (JSONObject) obj;
        return depedencies.toJSONString();
    }
}

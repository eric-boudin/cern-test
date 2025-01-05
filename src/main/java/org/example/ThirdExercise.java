package org.example;
import org.example.entities.Dependency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ThirdExercise {

    public List<Dependency> readJsonFile(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filename);
        Object obj = parser.parse(reader);
        JSONObject dependencies = (JSONObject) obj;

        return resolveGraph(dependencies);
    }

    private List<Dependency> resolveGraph(JSONObject json) {
        Set<String> set = json.keySet();
        List<Dependency> graph = new ArrayList<>();
        set.forEach(key -> {
            JSONArray values = (JSONArray) json.get(key);
            Dependency dep = new Dependency(key);
            for(int i=0; i<values.size(); i++) {
                if(json.containsKey(values.get(i)) && !((JSONArray)json.get(values.get(i))).isEmpty()) {
                    dep.addAllDependencies((getSubDependencies(json, (String) values.get(i))));
                }
                else {
                    dep.addDependency(new Dependency((String) values.get(i)));
                }
            }
            graph.add(dep);
        });
        return graph;
    }

    private List<Dependency> getSubDependencies(JSONObject json, String key) {
        JSONArray values = (JSONArray) json.get(key);
        Dependency subDep = new Dependency(key);
        for(int i=0; i<values.size(); i++) {
            if(json.containsKey(values.get(i))) {
                subDep.addAllDependencies(getSubDependencies(json, (String)values.get(i)));
            }
        }
        return List.of(subDep);
    }

    public String prettierGraph(List<Dependency> graph) {
        StringBuilder builder = new StringBuilder();
        for(Dependency dep : graph) {
            builder.append(dep.toString() + "\n");
        }
        return builder.toString();
    }

}

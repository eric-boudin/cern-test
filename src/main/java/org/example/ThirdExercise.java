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
            for (Object value : values) {
                if (json.containsKey(value) && !((JSONArray) json.get(value)).isEmpty()) {
                    dep.addAllDependencies((getSubDependencies(json, (String) value)));
                } else {
                    dep.addDependency(new Dependency((String) value));
                }
            }
            graph.add(dep);
        });
        return graph;
    }

    private List<Dependency> getSubDependencies(JSONObject json, String key) {
        JSONArray values = (JSONArray) json.get(key);
        Dependency subDep = new Dependency(key);
        for (Object value : values) {
            if (json.containsKey(value)) {
                subDep.addAllDependencies(getSubDependencies(json, (String) value));
            }
        }
        return List.of(subDep);
    }

    public String prettierGraph(List<Dependency> graph) {
        StringBuilder builder = new StringBuilder();
        for(Dependency dep : graph) {
            builder.append(dep.toString()).append("\n");
        }
        return builder.toString();
    }

}

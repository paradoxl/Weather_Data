package org.example;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Spike {
    public void spike() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
//            for (Map.Entry<?, ?> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + "=" + entry.getValue());
//
//            }

            String data = map.get("data").toString();

            String temp = data.substring(data.indexOf("value")+6, data.length() -6);
            System.out.println(temp);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ParseJson {
    public void read() throws Exception{
        try {
            Reader reader = new FileReader("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
            System.out.println("reader" + reader.toString());

            Gson gson = new Gson();
            getData data = gson.fromJson(reader.toString(), getData.class);
            System.out.println(data.getParam());
        }
        catch (Exception e){
            System.out.println("Failed");
        }

    }
}

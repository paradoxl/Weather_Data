package org.example;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;

public class ParseJson {
    public void read() throws Exception{
        try {
            Reader reader = new FileReader("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
            Gson gson = new Gson();
            data data = gson.fromJson(reader,data.class);
            System.out.println(data.getParameter() + "here");
        }
        catch (Exception e){
            System.out.println("Failed");
        }

    }
}

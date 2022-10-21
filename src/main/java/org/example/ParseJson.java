package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ParseJson {
    public void read() throws Exception{
        Reader reader = new FileReader("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
        Gson gson = new Gson();
//        Response response = gson.fromJson(reader, Response.class);
    }
}

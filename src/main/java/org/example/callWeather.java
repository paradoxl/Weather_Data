package org.example;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class callWeather {
    public void getData() throws Exception {
       Dotenv dotenv = Dotenv.load();
        //break the strings up into pieces. then concatinate.
        //figure out how to turn system date into the format below
        // determine how to generate lon lat from a location.
        String beg = "https://api.meteomatics.com/";
        String dateString = "2022-11-08T00:00:00Z/";
        String typeString = "t_2m:F/";
        String location = "37.043594,-95.658791/";
        String format = "json";


        String date = String.valueOf(LocalDateTime.now());
        System.out.println("date"+date);
        //api example
        // https://api.meteomatics.com/2022-10-29T00:00:00Z/t_2m:F/37.043594,-95.658791/json
        URL url = new URL(beg + date  + "Z/" + typeString + location + format);
        String encoding = Base64.getEncoder().encodeToString((dotenv.get("userName") + ":" + dotenv.get("passWord")).getBytes(StandardCharsets.UTF_8));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + encoding);

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader streamReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
//        System.out.println(responseStrBuilder);


        Path path = Paths.get("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
        try {
            Files.writeString(path, responseStrBuilder.toString(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("invalid path");
        }

    }
}




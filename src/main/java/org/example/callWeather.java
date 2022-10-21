package org.example;

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

public class callWeather {
    public void getData() throws Exception {
        String username = "student_evans";
        String password = "0xAD5bdm6R";
        System.out.print("username: " + username + ", password: " + password + "\n");
        URL url = new URL("https://api.meteomatics.com/2022-10-20T00:00:00Z/t_2m:F/40.479961,-104.907677/json");
        String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));

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
        System.out.println(responseStrBuilder);


        Path path = Paths.get("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
        try {
            Files.writeString(path, responseStrBuilder.toString(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("invalid path");
        }


    }
}




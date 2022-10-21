package org.example;

import com.google.gson.*;
import jdk.jfr.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)throws Exception{
        callWeather weather = new callWeather();

        weather.getData();

    }

    static class callWeather{

        public void getData() throws Exception {
            String username = "student_evans";
            String password = "0xAD5bdm6R";
            System.out.print("username: " + username + ", password: " + password + "\n");
            URL url = new URL("https://api.meteomatics.com/2022-10-20T00:00:00Z/t_2m:F/40.479961,-104.907677/json?model=mix");
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

//            System.out.print(responseStrBuilder);


            Path path = Paths.get("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
            try {
                Files.writeString(path, responseStrBuilder.toString(), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.out.println("invalid path");
            }


            // this portion uses org.simple.json
//         JSON parser with object
//            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json");
//            Object object = parser.parse(reader);
//            JSONObject jsonObject = (JSONObject) object;
//
//            Integer value = (Integer) jsonObject.get("value");
//            System.out.println("The value im looking for" + " " + value);
//
//
//            //json parser with array.
//
//            JSONObject jsonObject1 = (JSONObject) object;
//            JSONArray array1 = (JSONArray) jsonObject1.get("data");
//            Iterator i = array1.iterator();
//
//            while(i.hasNext()){
//                JSONObject slide = (JSONObject) i.next();
//                Double target = (Double) slide.get("value");
//                System.out.println("Value given arrays" + " " + target + " " + array1);
//
//            }
            Gson gson = new Gson();
           Spike spike = gson.fromJson(reader,Spike.class);
           System.out.println(spike.getParam());


        }
        }

    }

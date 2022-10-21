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
    public static void main(String[] args) throws Exception {
        callWeather weather = new callWeather();

        weather.getData();

    }
}
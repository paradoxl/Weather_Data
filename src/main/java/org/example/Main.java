package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        callWeather weather = new callWeather();
        ParseJson parser = new ParseJson();



        weather.getData();
        System.out.println("data incoming");
        parser.read();



    }
}
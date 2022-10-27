package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        callWeather weather = new callWeather();
        ParseJson parser = new ParseJson();



        weather.getData();
        System.out.println("data incoming");
        parser.read();

        //witihin the parser class try to implement a variable for each position on the json file.
        // the issue may be that there are not enough variables to properly collected data.


    }
}
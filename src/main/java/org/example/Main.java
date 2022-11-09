package org.example;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        callWeather weather = new callWeather();
        parse test = new parse();
        ConsoleHelper consoleHelper = new ConsoleHelper();

        String time = String.valueOf(LocalDateTime.now().with(LocalTime.of(6,0)));
        String time2 = String.valueOf(LocalDateTime.now().with(LocalTime.of(6,0)).plusDays(1));
        System.out.println(time);
        System.out.println(time2);
        Boolean running = true;
        weather.getData();
        System.out.println(time + "time one");
        System.out.println(time2 + "time two");
        while (running == true) {
//            if (Objects.equals(time, time2)) {
                weather.getData();
                System.out.println("running");
                test.spike();
//            }


            for (int i = 0; i < 20; i++) {
                consoleHelper.animate(" ");
                //simulate a piece of task
                Thread.sleep(400);
            }

        }
    }
}
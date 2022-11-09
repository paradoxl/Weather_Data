package org.example;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


import java.net.URI;
import java.net.URISyntaxException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class parse {


    public void spike() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("/Users/michael.evans/IdeaProjects/Weather/src/main/java/org/example/data.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
//            for (Map.Entry<?, ?> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + "=" + entry.getValue());
//
//            }

            String data = map.get("data").toString();

            String temp = data.substring(data.indexOf("value")+6, data.length() -6);
            System.out.println(temp);


         final String ACCOUNT_SID = "ACd3bcadd06e50f84a2cbbeff5bab5bf26";
         final String AUTH_TOKEN = "e56d0287ceb2cbced5b73f91dac8a0b9";


            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(new PhoneNumber("+19797773910"),
                    new PhoneNumber("+19789042343"),
                    "the current temp outside is " + temp).create();
            int temperature = Integer.parseInt(temp);

            if(temperature < 45 ){

                Message message2 = Message.creator(new PhoneNumber("+19797773910"),
                        new PhoneNumber("+19789042343"),
                        "Don't go out without your snow shoes").create();
            }
            else{
                Message message3 = Message.creator(new PhoneNumber("+19797773910"),
                        new PhoneNumber("+19789042343"),
                        "Temps good for the summers").create();
            }
            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

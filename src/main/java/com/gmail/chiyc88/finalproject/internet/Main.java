package com.gmail.chiyc88.finalproject.internet;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.mcsrvstat.us/2/playfuni.net"); //Ping my own Minecraft severer via api

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            scanner.close();

            JsonObject convertedObject = new Gson().fromJson(inline, JsonObject.class);
            String realIp = convertedObject.get("ip").getAsString();
            JsonObject players = convertedObject.get("players").getAsJsonObject();
            System.out.println(">> PlayfunI Network <<");
            System.out.println("IP address: " + realIp);
            System.out.println("Players: " + players);


//            JsonArray players = convertedObject.get("players").getAsJsonArray();
//            System.out.println(players.get(0).getAsInt());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
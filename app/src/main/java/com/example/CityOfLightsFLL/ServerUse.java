package com.example.CityOfLightsFLL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerUse {
    public static void GetProblems() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            try {
                URL url = new URL("https://sityoflightsfllserver.herokuapp.com/");
                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                httpConnection.setRequestMethod("POST");

                httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpConnection.setRequestProperty("Accept", "application/json");
                httpConnection.setDoOutput(true);

                JSONObject requestJSON = new JSONObject();
                requestJSON.put("command", "problems");

                byte[] bytesToSend = requestJSON.toString().getBytes(StandardCharsets.UTF_8);
                httpConnection.getOutputStream().write(bytesToSend);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpConnection.getInputStream()));
                String input = in.readLine();

                StringBuilder strBld = new StringBuilder();

                while (input != null) {
                    strBld.append(input);
                    input = in.readLine();
                }
                JSONObject responseJSON = new JSONObject(strBld.toString());
                String data = responseJSON.getString("data");
                System.out.println(data);
                if (data != null) {
                    MainActivity.data = data;}
                else {
                    MainActivity.data = "None";
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
});}}

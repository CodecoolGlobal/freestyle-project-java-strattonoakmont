package com.codecool.httprequest;

import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";

    private static final String API_KEY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";

    public static void main(String[] args) {

        StringBuffer response;
        JSONObject JSONresponse;
        response = sendGET();
        JSONresponse = JSONParse(response);

        System.out.println("GET DONE");
    }

    private static StringBuffer sendGET() {

        StringBuffer response = null;

        try {
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", API_KEY);
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

            } else {
                System.out.println("GET request not worked");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static JSONObject JSONParse(StringBuffer response) {

        JSONObject JSONresponse = null;

        try {
            JSONresponse = new JSONObject(response.toString());
            System.out.println(JSONresponse.getString("Message"));
        } catch (JSONException e) {
            System.out.println("error" + e);
        }

        return JSONresponse;
    }
}

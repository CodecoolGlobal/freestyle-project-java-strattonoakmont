package com.codecool.currency;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Currency {

    public static final String URL_CRYPTOCURRENCY = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    public static final String API_KEY_CRYPTOCURRENCY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";

    public Currency() {
    }
    
    public List<Map<String, Object>> getCurrency(String url, String api_key) {

        StringBuffer cryptoResponse = sendGET(url, api_key);
        JSONObject cryptoJSON = parseJSON(cryptoResponse);
        return getListOfCurrencies(cryptoJSON);
    }

    private StringBuffer sendGET(String url, String api_key) {

        StringBuffer response = null;

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", api_key);
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

            } else {
                System.out.println("GET request not worked");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static JSONObject parseJSON(StringBuffer response) {

        JSONObject JSONresponse = null;

        try {
            JSONresponse = new JSONObject(response.toString());
            // System.out.println(JSONresponse.getJSONArray("Data").getJSONObject(0));
        } catch (JSONException e) {
            System.out.println("error" + e);
        }

        return JSONresponse;
    }

    private static List<Map<String, Object>> getListOfCurrencies(JSONObject jsonResponse) {

        List<Map<String, Object>> listOfCryptos = null;

        try {
            JSONArray jsonArray = jsonResponse.getJSONArray("Data");
            listOfCryptos = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getJSONObject("CoinInfo").getString("Id");
                String fullName = item.getJSONObject("CoinInfo").getString("FullName");
                String name = item.getJSONObject("CoinInfo").getString("Name");
                String price = item.getJSONObject("DISPLAY").getJSONObject("USD").getString("PRICE");
                String volume24HourUSD = item.getJSONObject("DISPLAY").getJSONObject("USD").getString("VOLUME24HOURTO");
                String totalVolume24HourUSD = item.getJSONObject("DISPLAY").getJSONObject("USD")
                        .getString("TOTALVOLUME24HTO");
                String marketCap = item.getJSONObject("DISPLAY").getJSONObject("USD").getString("MKTCAP");
                String changePctDay = item.getJSONObject("DISPLAY").getJSONObject("USD").getString("CHANGEPCTDAY");
                String symbol = item.getJSONObject("DISPLAY").getJSONObject("USD").getString("FROMSYMBOL");
                Double rawPrice = item.getJSONObject("RAW").getJSONObject("USD").getDouble("PRICE");
                Long lastUpdate = item.getJSONObject("RAW").getJSONObject("USD").getLong("LASTUPDATE");

                HashMap<String, Object> myHashMap = new HashMap<String, Object>();
                myHashMap.put("id", id);
                myHashMap.put("fullName", fullName);
                myHashMap.put("name", name);
                myHashMap.put("price", price);
                myHashMap.put("volume24HourUSD", volume24HourUSD);
                myHashMap.put("totalVolume24HourUSD", totalVolume24HourUSD);
                myHashMap.put("marketCap", marketCap);
                myHashMap.put("changePctDay", changePctDay);
                myHashMap.put("symbol", symbol);
                myHashMap.put("rawPrice", rawPrice);
                myHashMap.put("lastUpdate", lastUpdate);

                listOfCryptos.add(myHashMap);
            }

        } catch (JSONException e) {
            System.out.println(e);
        }

        return listOfCryptos;
    }
}

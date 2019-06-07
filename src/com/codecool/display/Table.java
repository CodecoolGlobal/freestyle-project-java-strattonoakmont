package com.codecool.display;

import com.codecool.selecter.DataSelecter.*;
import java.util.*;

public class Table {

    public static void printSimpleTable(List<Map<String, Object>> simpleListCrypto) {
        int fullNameLength = 0;
        int marketCapLength = 0;
        String headerFullName = "Top Ten Cryptocurrencies";
        String headerMarketCap = "Market Cap";

        for (Map<String, Object> crypto : simpleListCrypto) {
            if (crypto.get("fullName").toString().length() > fullNameLength) {
                fullNameLength = crypto.get("fullName").toString().length();
            }
            if (crypto.get("marketCap").toString().length() > marketCapLength) {
                marketCapLength = crypto.get("marketCap").toString().length();
            }
        }

        fullNameLength = fullNameLength > headerFullName.length() ? fullNameLength : headerFullName.length();
        marketCapLength = marketCapLength > headerMarketCap.length() ? marketCapLength : headerMarketCap.length();

        // System.out.print("\033[H\033[2J");
        System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(marketCapLength) + "--+");
        System.out.println("|  " + headerFullName + "  |  " + headerMarketCap + "  |");
        System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(marketCapLength) + "--+");

        Integer counter = 1;

        for (Map<String, Object> crypto : simpleListCrypto) {
            System.out.printf("|   %" + fullNameLength * (-1) + "s |  %" + marketCapLength + "s  |",
            (counter.toString()) + ". " + crypto.get("fullName"), crypto.get("marketCap"));
            System.out.println("\n|--" + "-".repeat(fullNameLength) + "-----" + "-".repeat(marketCapLength) + "--|");
            counter++;

        }

        System.out.println("Choose a Cryptocurrency number to show detailed view\nOr press 0 to go Back");

    }

    public static void printDetailedTable(List<Map<String, Object>> detailedListCrypto, int order) {

        Map<String, Object> crypto = new HashMap<String, Object>();
        crypto = detailedListCrypto.get(order);

        int valueMaxLength = 0;
        int headerMaxLength = "Total direct coin - all markets".length();

        for (Object value : detailedListCrypto.get(order).values()) {
            if (value.toString().length() > valueMaxLength) {
                valueMaxLength = value.toString().length();
            }
        }

        LinkedHashMap<String, String> cryptoMap = new LinkedHashMap<String, String>();
            cryptoMap.put("Cryptocurrency name", crypto.get("fullName").toString());
            cryptoMap.put("Abbreviation", crypto.get("name").toString());
            cryptoMap.put("Symbol", crypto.get("symbol").toString());
            cryptoMap.put("Price", crypto.get("price").toString());
            cryptoMap.put("Total direct coin - USD volume", crypto.get("volume24HourUSD").toString());
            cryptoMap.put("Total direct coin - all markets", crypto.get("totalVolume24HourUSD").toString());
            cryptoMap.put("Market Cap", crypto.get("marketCap").toString());
            cryptoMap.put("Changed in last 24 hours", crypto.get("changePctDay").toString());
            cryptoMap.put("Last Updated", crypto.get("lastUpdate").toString());
            

        String topLine = "  +--" + "-".repeat(headerMaxLength) + "--+--" + "-".repeat(valueMaxLength) + "--+";
        String line = "  |--" + "-".repeat(headerMaxLength) + "-----" + "-".repeat(valueMaxLength) + "--|";

        System.out.print("\033[H\033[2J");
        System.out.println(topLine);
        for (String key : cryptoMap.keySet()) {
            System.out.printf("  |   %" + headerMaxLength * (-1) + "s |  %" + valueMaxLength + "s  |\n", key, cryptoMap.get(key));
            System.out.println(line);
        }
    }

    public static void printConvertedTable(List<Map<String, Object>> convertListCrypto) {
        int fullNameLength = 0;
        int priceLength = 0;
        int hufLength = 0;
        String headerFullName = "Top Ten Cryptocurrencies";
        String headerPriceUSD = "Price USD";
        String headerPriceHUF = "Price HUF";

        for (Map<String, Object> crypto : convertListCrypto) {
            if (crypto.get("fullName").toString().length() > fullNameLength) {
                fullNameLength = crypto.get("fullName").toString().length();
            }
            if (crypto.get("price").toString().length() > priceLength) {
                priceLength = crypto.get("price").toString().length();
            }
            if (crypto.get("rawPrice").toString().length() > hufLength) {
                hufLength = crypto.get("rawPrice").toString().length();
            }
        }

        fullNameLength = fullNameLength > headerFullName.length() ? fullNameLength : headerFullName.length();
        priceLength = priceLength > headerPriceUSD.length() ? priceLength : headerPriceUSD.length();
        hufLength = hufLength > headerPriceHUF.length() ? hufLength : headerPriceHUF.length();

        System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(priceLength) + "--+--"
                + "-".repeat(hufLength) + "--+");
        System.out.println("|  " + headerFullName + "  |  " + headerPriceUSD + "  |  " + headerPriceHUF + "  |");
        System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(priceLength) + "--+--"
                + "-".repeat(hufLength) + "--+");

        for (Map<String, Object> crypto : convertListCrypto) {
            System.out.printf("|   %" + fullNameLength * (-1) + "s |  %" + priceLength + "s |  %" + hufLength + "s   |",
                    crypto.get("fullName"), crypto.get("price"), crypto.get("rawPrice"));
            System.out.println("\n|--" + "-".repeat(fullNameLength) + "-----" + "-".repeat(priceLength) + "-----"
                    + "-".repeat(hufLength) + "--|");
        }

    }
}

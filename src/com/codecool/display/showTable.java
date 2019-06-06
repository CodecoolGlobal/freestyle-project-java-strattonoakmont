package com.codecool.display;

import com.codecool.selecter.DataSelecter.*;
import java.util.*;

public class showTable {

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
		System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(marketCapLength) + "--+");
		System.out.println("|  " + headerFullName + "  |  " + headerMarketCap + "  |");
		System.out.println("+--" + "-".repeat(fullNameLength) + "--+--" + "-".repeat(marketCapLength) + "--+");

		for (Map<String, Object> crypto : simpleListCrypto){
			System.out.printf("|   %" + fullNameLength*(-1) + "s |  %" + marketCapLength + "s  |", crypto.get("fullName"), crypto.get("marketCap"));
            // if ((boolean) crypto.get("select") == true) {
            //     System.out.print(" <--");
            // }
            System.out.println("\n|--" + "-".repeat(fullNameLength) + "-----" + "-".repeat(marketCapLength) + "--|");

		}

	}

	public static void printDetailedTable(List<Map<String, Object>> detailedListCrypto, int order) {
		int fullNameLength = 0;
		int totalVolume24HourUSDLength = 0;
		int symbolLength = 0;
		int priceLength = 0;
		int lastUpdateLength = 0;
		int nameLength = 0;
		int changePctDayLength = 0;
		int volume24HourUSDLength = 0;
		int marketCapLength = 0;
		int valueMaxLength = 0;
		String headerFullName = "Cryptocurrency name";
		String headerName = "Abbreviation";
		String headerSymbol = "Symbol";
		String headerPrice = "Price";
		String headerVolume24HourUSD = "Total direct coin - USD volume";
		String headerTotalVolume24HourUSD = "Total direct coin - all markets";
		String headerMarketCap = "Market Cap";
		String headerChangePctDay = "Changed in last 24 hours";
		String headerLastUpdate = "Last Updated";

		for (Map<String, Object> crypto : detailedListCrypto) {
			if (crypto.get("fullName").toString().length() > fullNameLength) {
				fullNameLength = crypto.get("fullName").toString().length();
			} if (crypto.get("totalVolume24HourUSD").toString().length() > totalVolume24HourUSDLength) {
				totalVolume24HourUSDLength = crypto.get("totalVolume24HourUSD").toString().length();
			} if (crypto.get("symbol").toString().length() > symbolLength) {
				symbolLength = crypto.get("symbol").toString().length();
			} if (crypto.get("price").toString().length() > priceLength) {
				priceLength = crypto.get("price").toString().length();
			} if (crypto.get("lastUpdate").toString().length() > lastUpdateLength) {
				lastUpdateLength = crypto.get("lastUpdate").toString().length();
			} if (crypto.get("name").toString().length() > nameLength) {
				nameLength = crypto.get("name").toString().length();
			} if (crypto.get("changePctDay").toString().length() > changePctDayLength) {
				changePctDayLength = crypto.get("changePctDay").toString().length();
			} if (crypto.get("volume24HourUSD").toString().length() > volume24HourUSDLength) {
				volume24HourUSDLength = crypto.get("volume24HourUSD").toString().length();
			} if (crypto.get("marketCap").toString().length() > marketCapLength) {
				marketCapLength = crypto.get("marketCap").toString().length();
			}
		}

		for (Map<String, Object> crypto : detailedListCrypto) {
			if (crypto.get("fullName").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("fullName").toString().length();
			} if (crypto.get("totalVolume24HourUSD").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("totalVolume24HourUSD").toString().length();
			} if (crypto.get("symbol").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("symbol").toString().length();
			} if (crypto.get("price").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("price").toString().length();
			} if (crypto.get("lastUpdate").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("lastUpdate").toString().length();
			} if (crypto.get("name").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("name").toString().length();
			} if (crypto.get("changePctDay").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("changePctDay").toString().length();
			} if (crypto.get("volume24HourUSD").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("volume24HourUSD").toString().length();
			} if (crypto.get("marketCap").toString().length() > valueMaxLength) {
				valueMaxLength = crypto.get("marketCap").toString().length();
			}
		}


		//fullNameLength = fullNameLength > headerFullName.length() ? fullNameLength : headerFullName.length();
		//nameLength = nameLength > headerName.length() ? nameLength : headerName.length();
		//symbolLength = symbolLength > headerSymbol.length() ? symbolLength : headerSymbol.length();
		//priceLength = priceLength > headerPrice.length() ? priceLength : headerPrice.length();
		//volume24HourUSDLength = volume24HourUSDLength > headerVolume24HourUSD.length() ? volume24HourUSDLength : 	headerVolume24HourUSD.length();
		//totalVolume24HourUSDLength = totalVolume24HourUSDLength > headerTotalVolume24HourUSD.length() ? totalVolume24HourUSDLength : headerTotalVolume24HourUSD.length();
		//marketCapLength = marketCapLength > headerMarketCap.length() ? marketCapLength : headerMarketCap.length();
		//changePctDayLength = changePctDayLength > headerChangePctDay.length() ? changePctDayLength : headerChangePctDay.length();
		//lastUpdateLength = lastUpdateLength > headerLastUpdate.length() ? lastUpdateLength : headerLastUpdate.length();

		System.out.println("+--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "--+--" + "-".repeat(valueMaxLength) + "--+");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerFullName, detailedListCrypto.get(order).get("fullName"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerName, detailedListCrypto.get(order).get("name"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerSymbol, detailedListCrypto.get(order).get("symbol"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerPrice, detailedListCrypto.get(order).get("price"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerVolume24HourUSD, detailedListCrypto.get(order).get("volume24HourUSD"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerTotalVolume24HourUSD, detailedListCrypto.get(order).get("totalVolume24HourUSD"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerMarketCap, detailedListCrypto.get(order).get("marketCap"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerChangePctDay, detailedListCrypto.get(order).get("changePctDay"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
		System.out.printf("|   %" + headerTotalVolume24HourUSD.length()*(-1) + "s |  %" + valueMaxLength + "s  |\n", headerLastUpdate, detailedListCrypto.get(order).get("lastUpdate"));
		System.out.println("|--" + "-".repeat(headerTotalVolume24HourUSD.length()) + "-----" + "-".repeat(valueMaxLength) + "--|");
	}
}
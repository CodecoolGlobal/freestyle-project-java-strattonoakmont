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
			System.out.printf("|   %" + fullNameLength*(-1) + "s |  %" + marketCapLength + "s  |\n", crypto.get("fullName"), crypto.get("marketCap"));
			System.out.println("|--" + "-".repeat(fullNameLength) + "-----" + "-".repeat(marketCapLength) + "--|");

		}

	}

	public static void printDetailedTable(List<Map<String, Object>> detailedListCrypto) {
		int fullNameLength = 0;
		int totalVolume24HourUSDLength = 0;
		int symbolLength = 0;
		int priceLength = 0;
		int lastUpdateLength = 0;
		int nameLength = 0;
		int changePctDayLength = 0;
		int volume24HourUSDLength = 0;
		int marketCapLength = 0;

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
	}
}

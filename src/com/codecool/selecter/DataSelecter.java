package com.codecool.selecter;

import java.util.*;
import java.sql.Timestamp;
import java.lang.*;

public class DataSelecter {

	public static List<Map<String, Object>> simple (List<Map<String, Object>> listOfCryptos) {

		List<Map<String, Object>> simpleListCrypto = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> crypto : listOfCryptos) {
			HashMap<String,Object> tempHashMap = new HashMap<String,Object>();
			tempHashMap.put("fullName", crypto.get("fullName"));
			tempHashMap.put("marketCap", crypto.get("marketCap"));
			simpleListCrypto.add(tempHashMap);
		}
		// System.out.print(simpleListCrypto);

		return simpleListCrypto;
	}

	public static List<Map<String, Object>> detailed (List<Map<String, Object>> listOfCryptos) {

		List<Map<String, Object>> detailedListCrypto = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> crypto : listOfCryptos) {
			HashMap<String,Object> tempHashMap = new HashMap<String,Object>();
			tempHashMap.put("fullName", crypto.get("fullName"));
			tempHashMap.put("totalVolume24HourUSD", crypto.get("totalVolume24HourUSD"));
			tempHashMap.put("symbol", crypto.get("symbol"));
			tempHashMap.put("select", crypto.get("select"));
			tempHashMap.put("price", crypto.get("price"));
			long lastUpdate = (Long) crypto.get("lastUpdate");
			Date lastUpdateDate = new java.util.Date(lastUpdate * 1000);
			tempHashMap.put("lastUpdate", lastUpdateDate);
			tempHashMap.put("name", crypto.get("name"));
			tempHashMap.put("changePctDay", crypto.get("changePctDay"));
			tempHashMap.put("rawPrice", crypto.get("rawPrice"));
			tempHashMap.put("volume24HourUSD", crypto.get("volume24HourUSD"));
			tempHashMap.put("marketCap", crypto.get("marketCap"));
			detailedListCrypto.add(tempHashMap);
		}
		// System.out.print(detailedListCrypto);

		return detailedListCrypto;
	}


}

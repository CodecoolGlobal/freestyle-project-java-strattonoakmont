package com.codecool.selecter;

import java.util.*;

public class DataSelecter {

	public static List<Map<String, Object>> simple (List<Map<String, Object>> listOfCryptos) {

        List<Map<String, Object>> simpleListCrypto = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> crypto : listOfCryptos) {
			HashMap<String,Object> tempHashMap = new HashMap<String,Object>();
			tempHashMap.put("fullName", crypto.get("fullName"));
            tempHashMap.put("marketCap", crypto.get("marketCap"));
            tempHashMap.put("select", false);
			simpleListCrypto.add(tempHashMap);
        }
        simpleListCrypto.get(0).replace("select", true);
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

	public static List<Map<String, Object>> converted (List<Map<String, Object>> listOfCryptos) {

        List<Map<String, Object>> convertListCrypto = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> crypto : listOfCryptos) {
			HashMap<String,Object> tempHashMap = new HashMap<String,Object>();
			tempHashMap.put("fullName", crypto.get("fullName"));
            		tempHashMap.put("price", crypto.get("price"));
			Double huf = (Double) crypto.get("rawPrice");
            		tempHashMap.put("rawPrice", huf * 284);
			convertListCrypto.add(tempHashMap);
        	}
		return convertListCrypto;
	}


}

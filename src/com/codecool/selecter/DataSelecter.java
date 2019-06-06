package com.codecool.selecter;

import java.util.*;

public class DataSelecter {

	public static List<Map<String, Object>> simple (List<Map<String, Object>> listOfCryptos) {
		for (Map<String, Object> map : listOfCryptos) {
			System.out.print(map);
		}
		return listOfCryptos;
	}
}

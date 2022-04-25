package com.openBrowser;

import java.util.HashMap;
import java.util.Hashtable;

public class MapClass {

	public static void main(String[] args) {
		
		//HashMap Example
		//I can print a null value (only 1)
		//I cannot do multithreading
		//it is faster
		HashMap<String, Integer> abc = new HashMap<String,Integer>();
		
		abc.put("Alif", 758945894);
		abc.put("Marco", 546565656);
		abc.put("Esteph", 645654645);
		abc.put("Paul", 768787833);
		abc.put("Kam", 979638745);
		abc.put(null, 979638745);
		
		System.out.println(abc.get("Alif"));
		
		
		//Hashtable example
		////I can't print a null value
		//I can use multithredding
		//It is slower
		Hashtable<String, Integer> xyz = new Hashtable<String,Integer>();
		
		xyz.put("Ben", 758945894);
		xyz.put("Alex", 546565656);
		xyz.put("Mike", 645654645);
		xyz.put("Dave", 768787833);
		xyz.put("Deep", 979638745);
	}

}

package com.zy.constant;

public class StringUtil {
	
	public static boolean compareStrings(String dataString,String inputString){
		
		if(dataString.equals(inputString))
			return true;
		if(inputString.contains(dataString))
			return true;

		return false;
	}
	
	public static boolean isEmpty(String inputString){
		if(inputString == null)
			return true;
		if(inputString.equals(""))
			return true;
		return false;
	}
}

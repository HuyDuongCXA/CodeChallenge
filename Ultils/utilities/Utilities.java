package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

	public static String generateTimeStamp() {
		long a = System.currentTimeMillis() / 1000L;
		String b = String.valueOf(a);
		return b;
	}
	
	public static String generateRandomEmail() {
		return "abc" + generateTimeStamp() + "@abc.com" ;
	}
	
	public static String generateRandomPhoneNumber() {
		return generateTimeStamp();
	}
	
	public static String getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return new SimpleDateFormat("MMMM").format(cal.getTime());
	}
	
	public static String getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return new SimpleDateFormat("YYYY").format(cal.getTime());
	}
	
	public static String generateRandomIdCard() {
		return generateTimeStamp();
	}
	
	public static String generateRandomUen() {
		String randomUen = generateTimeStamp();
		int length = randomUen.length();
		int valid = 9;
		
		if(length>valid) {
			randomUen = randomUen.substring(length-valid);
		}
		return randomUen +"a";
	}
	
}

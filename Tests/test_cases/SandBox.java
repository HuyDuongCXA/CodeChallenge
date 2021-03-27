package test_cases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import utilities.Utilities;

public class SandBox {

	public static void main(String[] args) {
		long a = System.currentTimeMillis() / 1000L;
		String b = String.valueOf(a);
		int length = b.length();
		int valid = 9;
		
		if(length>valid) {
			b = b.substring(length-valid);
		}
		
		String c = b +"a";
		System.out.println(c);
		System.out.println(length);
	}

}

package test_cases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utilities.Utilities;

public class SandBox {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		String a = new SimpleDateFormat("DDDD,MMMM,YYYY").format(cal.getTime());
		System.out.println(a);
	}

}
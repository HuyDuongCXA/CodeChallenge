package test_cases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Utilities;

public class SandBox {
	private static Logger logger = LogManager.getLogger(SandBox.class);
	public static void main(String[] args) {
		System.out.println("start");
		logger.trace("trace test logger");
		logger.info("info test logger");
		logger.error("error test logger");
		logger.warn("warn test logger");
		logger.fatal("fatal test logger");
		System.out.println("end");

	}

}

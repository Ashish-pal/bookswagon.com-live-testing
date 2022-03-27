package utilities;

import org.apache.log4j.Logger;

public class Log4j {

	public static Logger showlogs = Logger.getLogger(Log4j.class.getName());

	public static void startTestCase(String TestName) {
		showlogs.info(TestName);
	}

	public static void endTestCase(String TestName) {
		showlogs.info(TestName);
	}

	public static void info(String message) {
		showlogs.info(message);
	}

	public static void warn(String message) {
		showlogs.warn(message);
	}

	public static void error(String message) {
		showlogs.error(message);
	}

	public static void fatal(String message) {
		showlogs.fatal(message);
	}

	public static void debug(String message) {
		showlogs.debug(message);
	}
}

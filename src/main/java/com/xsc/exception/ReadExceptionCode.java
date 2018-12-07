package com.xsc.exception;

import java.io.InputStream;
import java.util.Properties;

public class ReadExceptionCode {

	public String ReadProperties(String exCode) {
		String param = "";
		ClassLoader classLoader = ReadExceptionCode.class.getClassLoader(); 
		Properties prop = new Properties();
		InputStream stream = classLoader.getResourceAsStream("errMsg.properties");
		try {
			prop.load(stream);
		    param = prop.getProperty( exCode ).trim();

		} catch (Exception e) {
			throw new FileException(e,ExceptionCode.READ_FILE_FAILED);
		}
		return param;
	}
}

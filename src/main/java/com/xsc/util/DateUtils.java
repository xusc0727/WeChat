package com.xsc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author xusc
 *
 */
public class DateUtils {

	public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT_NOTIME = "yyyy-MM-dd";

	/** yyyy-MM-dd HH:mm:ss */
	public static final String	PATNER_DEFAULT			= "yyyy-MM-dd HH:mm:ss";
	/** HH:mm:ss */
	public static final String	PATNER_ACTIVITY			= "HH:mm:ss";
	/** yyyyMMddHHmmss */
	public static final String	PATNER_NO_MILLSECOND	= "yyyyMMddHHmmss";
	/** yyyyMMddHHmmssSSS */
	public static final String	PATNER_FULL				= "yyyyMMddHHmmssSSS";
	/** yyyy-MM-dd */
	public static final String	PATNER_ISO9985			= "yyyy-MM-dd";
	/** yyyyMMdd */
	public static final String	PATNER_ISO9985_2		= "yyyyMMdd";
	/** yyyy-MM-dd HH:mm */
	public static final String	PATNER_DEFAULT_NOMIN	= "yyyy-MM-dd HH:mm";

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getFormatTime(Date date, String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.format(date).toString();
		} catch (Exception e) {
			return "";
		}
	}

	public static Date getFormatDate(String date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getFormatDate(String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 偏移时间（分钟）
	 * 
	 * @param date
	 *            时间
	 * @param offset
	 *            偏移量，负数代表往前，正数代表往后
	 * @return
	 */
	public static Date offSetMin(Date date, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, offset);
		return cal.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param field
	 * @param offset
	 * @return
	 */
	public static Date offSet(Date date, int field, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, offset);
		return cal.getTime();
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String format( Date date, String formatter )
	{
		SimpleDateFormat formatTime = new SimpleDateFormat( formatter );
		return formatTime.format( date );
	}
	
	/**
	 * 比较两个时间的早晚
	 * time1早于time2，返回true
	 * @param time1
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public static boolean compare(String time1,String time2) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date a = sdf.parse(time1);
		Date b = sdf.parse(time2);
		if(a.getTime()-b.getTime()<0){
			return true;
		}else{
			return false;
		}
	}
}

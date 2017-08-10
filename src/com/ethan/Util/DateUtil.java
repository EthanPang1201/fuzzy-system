package com.ethan.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @Title: getNowDate
	 * @Description: 获取当前时间按字符串输出
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String getNowDate() {
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * 
	 * @Title: dateToStamp
	 * @Description: 获得当前时间的时间戳
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String dateToStamp() {
		Date currentTime = new Date();
        long ts = currentTime.getTime();
        return String.valueOf(ts);
    }
	
}

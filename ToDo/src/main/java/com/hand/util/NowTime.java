package com.hand.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class NowTime {

	/**
	 * 
	 * 获取当前的时间 格式是yyyy-mm-dd hh:mm:ss
	 * 
	 * @return Date
	 * 
	 */
	public static Date getNowTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String timeString = simpleDateFormat.format(new Date());
		Date date = null;
		try {
			date = simpleDateFormat.parse(timeString);
		} catch (ParseException e) {
			// TODO 待异常处理
			e.printStackTrace();
		}
		return date;
	}

	/***
	 * 
	 * 將時間變為字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * 
	 * @return timeString
	 *
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = formatter.format(date);
		return timeString;
	}
}

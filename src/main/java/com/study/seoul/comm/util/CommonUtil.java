package com.study.seoul.comm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	
	public static String getCurrentDateAndTime(String pattern) {
		String rtn = "";
		Date now = new Date();
		
		SimpleDateFormat fm = new SimpleDateFormat(pattern);
		
		rtn = fm.format(now);
		return rtn;
	}
	
		
}

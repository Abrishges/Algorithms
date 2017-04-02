/**
 * 
 */
package com.Algorithm.graphs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author aberehamwodajie
 *
 * Jan 26, 2017
 */
public class Timetest {
	

		
		private  static String format = "dd/MM/yyyy HH:mm:ss";
		private static  long epoFinal = 0; 

		public static void main(String[] args) { 
		// ==================================================================================
		/* Get the current epoch time */
		long epoch = System.currentTimeMillis()/1000;
		
		System.out.println("Current epoch time: " + epoch);

		// ==================================================================================
		/* Convert from epoch to human readable date */
		String currenttime = new java.text.SimpleDateFormat(format).format(new java.util.Date (epoch*1000));
		
		System.out.println("current time in readable format: " + currenttime);

		// ==================================================================================
		/* Substract 30.44 ddays from current human readable Date */
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Timetest de = new Timetest();
		Date date = de.formatDate(currenttime, sdf);
		String beforDate = de.substractTimeWithFormat(date, 30.44*24, sdf);

		// ==================================================================================
		/* Now convert this beforDate into epoch time */
		try { 
		Date dt = new java.text.SimpleDateFormat(format).parse(beforDate);
		epoFinal = dt.getTime()/1000;

		} catch (ParseException e) {
		e.printStackTrace();
		}

		}

		public Date formatDate(String dateStr, SimpleDateFormat sdf) {
		Date date = null;
		try {
		date = sdf.parse(dateStr);
		} catch (ParseException e) {
		e.printStackTrace();
		}
		return date;
		}

		public String substractTimeWithFormat(Date date, double time, SimpleDateFormat sdf) {
		long milliSeconds = (long) (time * 60 * 60 * 1000);
		long resultTime = date.getTime() - milliSeconds;
		date = new Date(resultTime);
		return sdf.format(date);
		}
	
}

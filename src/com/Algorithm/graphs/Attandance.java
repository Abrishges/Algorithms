/**
 * 
 */
package com.Algorithm.graphs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author aberehamwodajie
 *
 * Jan 26, 2017
 */
public class Attandance {
	
	
	private  static String format = "dd/MM/yyyy";
	private  static String currenttime  = "01/25/2017";
	
	public static void main(String [] args) {
		
	 currenttime  = "01/25/2017";
	SimpleDateFormat sdf = new SimpleDateFormat(format);
	Timetest de = new Timetest();
	Date date = de.formatDate(currenttime, sdf);
	
	long epoch = date.getTime();
    System.out.println(epoch);
    
    Scanner in = new Scanner(System.in);
	
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

}

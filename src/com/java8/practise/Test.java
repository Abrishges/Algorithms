package com.java8.practise;

import java.io.BufferedWriter;
import java.text.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String str = "07:05:45PM";//scan.nextLine();
        
        int h1 = (int)str.charAt(1) - '0';
        int h2 = (int)str.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10);
        
        String type = null;
        if (str != null && str.length() > 2) {
        	type = str.substring(str.length() - 2);
        }
        
        if(type.equalsIgnoreCase("AM")) {
        	System.out.println(type);
        	if(hh == 12) {
        		str = "00"+str.substring(2,8);
        	} else {
        		str = str.substring(0,8);
        	}
        } 

        if(type.equalsIgnoreCase("PM")) {
        	if(hh == 12) {
        		  str = str.substring(0,8);
        		} else {
        			 hh = hh + 12;
        			str = hh + str.substring(2,8);
        	}       	
        } 
        
       System.out.println(str);
	}
	
	   static String timeConversion(String s) {
	       DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
	       DateFormat simpleDate = new SimpleDateFormat("hh:mm:ss");
	       
	       Date date = null;
		try {
			date = df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String output = simpleDate.format(date);
	      return output;
	    }

}

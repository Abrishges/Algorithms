package com.Algorithm.sorting;
/*
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer num to its English words representation.
 * Input: num = 123
Output: "One Hundred Twenty Three"
 */
public class NumberToWords {

	public static void main(String[] args) {
		
		NumberToWords nw = new NumberToWords();
		System.out.println(nw.numberToWords(19));

	}
	
	  
	  public String numberToWords(int num) {
		  
		  if (num == 0) return "Zero";
		  int bill = num /1000000000;
		  int mill = (num - bill * 1000000000)/1000000;
		  int thou = (num - bill * 1000000000 - mill * 1000000)/1000;
		  int theRest = num - bill * 1000000000 - mill * 1000000 - thou * 1000;
		  
		  String result = "";

		  if (bill != 0) {
			  result = threeDigit(bill) + " Billion";
		  }
		  
		  if (mill != 0) {
			   if (!result.isEmpty()) {
				   result += " ";
			   }
		 	result += threeDigit(mill) + " Million";
		  }
		  
		  if (thou != 0) {
			   if (!result.isEmpty()) {
				   result += " ";
			   }
			  result += threeDigit(thou) + " Thousand";
		  }

		  if (theRest != 0) {
			   if (!result.isEmpty()) {
				   result += " ";
			   }
			  result += threeDigit(theRest);
		  }
		  
		  return result;
	  }
	  
	  public String threeDigit(int num) {
		  int hand = num/100; 
		  int theRest = num - hand * 100;
		  
		  String result = "";
		  if (hand != 0) {
			  result = once(hand) + " Hundred";
		  }
		  
		  if (theRest != 0) {	  
			  if (theRest >= 11 && theRest <= 19) {
				   if (!result.isEmpty()) {
					   result += " ";
				   }
				  result += underTwenty(theRest);
			  } else {
				  
				  int ten = theRest/10;
				  int one = theRest - ten * 10;
				  
				  if (one == 0) {
					   if (!result.isEmpty()) {
						   result += " ";
					   }
					  result += tenth(theRest);
				  } else {
					   if (!result.isEmpty()) {
						   result += " ";
					   }
					   
					   if (ten == 0) {
						   result += once(one);
					   } else {
						   result += tenth(ten * 10) + " " + once(one);
					   }
				  }
			  }
		  }
		  
		  return result;
	  }
	  
	public String once(int num) {
		 switch (num) {
			 case 1 : return "One";
			 case 2 : return "Two";
			 case 3 : return "Three";
			 case 4 : return "Four";
			 case 5 : return "Five";
			 case 6 : return "Six";
			 case 7 : return "Seven";
			 case 8 : return "Eight";
			 case 9 : return "Nine";			 
		 }
		 return "";
	}
	
	public String underTwenty(int num) {
		
		switch (num) {
			case 10 : return "Ten";
			case 11 : return "Eleven";
			case 12 : return "Twelve";
			case 13 : return "Thirteen";
			case 14 : return "Fourteen";
			case 15 : return "Fifteen";
			case 16 : return "Sixteen";
			case 17: return "Seventeen";
			case 18 : return "Eighteen";
			case 19 : return "Nineteen";
		}
		return "";
	}

  public String tenth(int num) {
	  
	  switch (num) {
	      case 10  :return "Ten";
		  case 20 : return "Twenty";
		  case 30 : return "Thirty";
		  case 40 : return "Forty";
		  case 50 : return "Fifty";
		  case 60 : return "Sixty";
		  case 70 : return "Seventy";
		  case 80 : return "Eighty";
		  case 90 : return "Ninety";	  
	  }  
	  return "";
  }
}

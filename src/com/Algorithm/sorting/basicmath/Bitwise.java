package com.Algorithm.sorting.basicmath;

/*
 * https://leetcode.com/problems/single-number-ii/
 */
public class Bitwise {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int x = 12;
        int y = 25;
        
        /*
         * 12 = 00001100 (In Binary)
           25 = 00011001 (In Binary)

			Bitwise OR Operation of 12 and 25
			   00001100
			 | 00011001
			____________
   			   00011101 = 29 (In Decimal)
         */
        int or = x | y; 
        System.out.printf("bitwise OR: %d", or);
        
        /*
         *  12 = 00001100 (In Binary)
			25 = 00011001 (In Binary)
			
			// Bitwise AND Operation of 12 and 25
			   00001100
			 & 00011001
			____________
			   00001000 = 8 (In Decimal)
         */
        int and = x & y;
        System.out.printf("\nBitwise And: %d", and);
        
        /*
         *  12 = 00001100 (In Binary)
			25 = 00011001 (In Binary)
			
			// Bitwise XOR Operation of 12 and 25
			   00001100
			 ^ 00011001
			____________
			   00010101 = 21 (In Decimal)
         */
        int xor = x ^ y;
		System.out.printf("\nBitwise xor: %d", xor);
		
		/*
		 * Complement
		 * It changes binary digits 1 to 0 and 0 to 1.
		 * bitwise complement of 35
		 * It is important to note that the bitwise complement of any integer N is equal to - (N + 1). For example,
         * Consider an integer 35. As per the rule, the bitwise complement of 35 should be -(35 + 1) = -36. 
         * Now let's see if we get the correct answer or not.
         * 
         *  35 = 00100011 (In Binary)

			// using bitwise complement operator
			~ 00100011
			__________
			  11011100
		 *  In binary arithmetic, we can calculate the binary negative of an integer using 2's complement. 1's complement changes 0 to 1 and 1 to 0.
		 *  And, if we add 1 to the result of the 1's complement, we get the 2's complement of the original number. For example,
		 *  In the above example, we get that the bitwise complement of 00100011 (35) is 11011100. Here, if we convert the result into decimal we get 220.
           However, it is important to note that we cannot directly convert the result into decimal and get the desired output. This is because the binary 
           result 11011100 is also equivalent to -36.
		 */
		
		/* 
		 * 2's Complement
			In binary arithmetic, we can calculate the binary negative of an integer using 2's complement.
			1's complement changes 0 to 1 and 1 to 0. And, if we add 1 to the result of the 1's complement,
			 we get the 2's complement of the original number. For example,
		 * // compute the 2's complement of 36
			36 = 00100100 (In Binary)
			
			1's complement = 11011011
			
			2's complement:
			 11011011
			    +   1
			_________
			 11011100
		 * Here, we can see the 2's complement of 36 (i.e. -36) is 11011100. This value is equivalent to the bitwise complement of 35.
           Hence, we can say that the bitwise complement of 35 is -(35 + 1) = -36
		 */
		
		int number = 35, result;

	    // bitwise complement of 35
	    result = ~number;
	    System.out.printf("\nBitwise complement of 35: %d", result); 
	    
	    int number2 = 2;
	    
	    // 2 bit left shift operation 
	    int shiftLeft = number2 << 2;
	    System.out.printf("\nShift left 2 : %d", shiftLeft);    // prints 8
	    
	    int number3 = 8;
	    // 2 bit left shift operation 
	    int shiftRight = number3 >> 2;
	    System.out.printf("\nShift right 8 : %d", shiftRight);    // prints 8
	    
	    int number4 = 8;
	    int number5 = -8;
	    System.out.println();
	    // 2 bit signed right shift
	    System.out.println(number4 >> 2);    // prints 2
	    System.out.println(number5 >> 2);    // prints -2
	}

}

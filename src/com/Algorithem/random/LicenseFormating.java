package com.Algorithem.random;

public class LicenseFormating {

	public static void main(String[] args) {

		String str = "---";
		int k = 3;

		System.out.println(licenseKeyFormatting(str, k));
	}

	public static String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
                 
 			if (s.charAt(i) != '-') {
				sb.append(Character.toUpperCase(s.charAt(i)));
				j++;
                
                if (j % k == 0 && i != 0) {
				   sb.append('-');
				   j = 0;
			    }
			}
        }
        
        sb.reverse();
        if (sb.length() > 0 && sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
	}
}

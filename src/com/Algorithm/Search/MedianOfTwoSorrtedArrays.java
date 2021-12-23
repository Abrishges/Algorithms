package com.Algorithm.Search;

public class MedianOfTwoSorrtedArrays {
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
	        if (nums2.length < nums1.length) {
	             return findMedianSortedArrays(nums2, nums1);
	        }
	       
		if (nums1.length == 0) {
			   
			   if (nums2.length % 2 == 0) {
				   return ((double)(nums2[nums2.length/2] + nums2[nums2.length/2 - 1]))/2;
			   }
			   return (double) nums2[nums2.length/2];
		   }
		 
	   if (nums2.length == 0) {
			   
			   if (nums1.length % 2 == 0) {
				   return ((double)(nums1[nums1.length/2] + nums1[nums1.length/2 - 1]))/2;
			   }
			   return (double) nums1[nums1.length/2];
		}
	   
	        if (nums2.length < nums1.length) {
	             findMedianSortedArrays(nums2, nums1);
	        }
	        
	        int n = nums1.length;
	        int m = nums2.length; 
	        int low = 0;
	        int high = n; 
	        
	        while (low <= high) {
	            
	            int partNums1 = (low + high)/2;
	            int partNums2 = ((n + m + 1)/2 - partNums1);
	             
	            int partLeftNums1Max = partNums1 == 0 ? Integer.MIN_VALUE : nums1[partNums1 - 1];
	            int partRightNums1Min = partNums1 == n ? Integer.MAX_VALUE : nums1[partNums1];
	                
	            int partLeftNums2Max = partNums2 == 0 ? Integer.MIN_VALUE : nums2[partNums2 - 1];
	            int partRightNums2Min = partNums2 == m ? Integer.MAX_VALUE : nums2[partNums2];  
	            
	            if (partLeftNums1Max <= partRightNums2Min && partLeftNums2Max <= partRightNums1Min ) {
	                
	               if ((n + m) % 2 == 0) {
	            	   
	                 return ((double)(Math.max(partLeftNums1Max, partLeftNums2Max) + Math.min(partRightNums1Min, partRightNums2Min)))/2;
	                } else {
	                   return (double)( Math.max(partLeftNums1Max, partLeftNums2Max));
	               }
	            } else if (partLeftNums1Max > partRightNums2Min){
	                   //move nums1 to left 
	                    high = partNums1 - 1;
	            } else {
	                 // move nums1 to right 
	                  low = partNums1 + 1; 
	            } 
	    }
	     return 0;
	    }

	public static void main(String[] args) {
		
		MedianOfTwoSorrtedArrays bs = new MedianOfTwoSorrtedArrays();
		int [] nums1 = {1, 2, 3, 5, 6};
		int [] nums2 = {4};
		
		double x = bs.findMedianSortedArrays(nums1, nums2);
         System.out.println(x);
	}

}

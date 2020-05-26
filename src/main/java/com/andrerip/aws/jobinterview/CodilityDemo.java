package com.andrerip.aws.jobinterview;

import java.util.Arrays;

public class CodilityDemo {
	
	public static void main(String[] args) {
		int[] a = new int[] {9000};
		System.out.println(Arrays.toString(a));
		
		new CodilityDemo().solution(a);
		
	}

    public int solution(int[] A) {
    	
    	int[] array = Arrays.stream(A)
    		.sorted()
    		.distinct()
    		.filter((i) -> i > 0 && i < 100000)
    		.toArray();
    	
    	System.out.println(Arrays.toString(array));
    	
    	int firstMissingInt = returnFirstMissingInt(array);
    	System.out.println(firstMissingInt);
    	
    	return firstMissingInt;
    	
    }
    
    public int returnFirstMissingInt(int[] a) {
    	
    	if(a.length == 0 || a[0] > 1) {
    		return 1;
    	}
    	
    	for(int i=0; i<=a.length-2; i++) {
    		if(a[i]+1 != a[i+1]) {
    			return a[i]+1;
    		}
    	}
    	
    	// return the next int when none was found
    	return a[a.length-1]+1;
    }

}

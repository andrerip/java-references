package com.andrerip.aws.jobinterview;

public class Solution1 {

	public static void main(String[] args) {
		
		int size = new Solution1().solution(
				new int[] {1, 12, 42, 70, 36, -4, 43, 15},
				new int[] {5, 15, 44, 72, 36, 2, 69, 24});
		
		System.out.println(size);
	}
	
    public int solution(int[] A, int[] B) {

    	int size=0;
    	
    	// TODO: split the arrays, not passing the hole arrays to the methods...
    	
    	for(int i=0; i<A.length; i++) {
        	// If overlaps, get the union
        	if(isOverlap(A, B)) {
        		getUnion(A,B); // TODO: do I really need the return or just add to size?
        		size+=2;
        	} else {
        		size++;
        	}
        	
    	}
    	
    	return size;
    
    }
    
    private boolean isOverlap(int[] A, int[] B) {
    	// L = any number inside the interval
    	int L = A[0]+1;
    	
    	// L needs to be inside B interval
    	if(L>=B[0] && L<=B[1]) {
    		return true;    		
    	} else {
    		return false;
    	}
    }
    
    private int[] getUnion(int[] A, int[] B) {
    	
    	// when Overlap:
    	// (min(A[0],B[0]), max(A[1],B[1]) )
    	
    	int unionA = Math.min(A[0], B[0]);
    	int unionB = Math.max(A[1], B[1]);
    	
    	return new int[] {unionA, unionB};
    	
    }

}

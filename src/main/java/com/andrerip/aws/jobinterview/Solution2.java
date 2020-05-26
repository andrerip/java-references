package com.andrerip.aws.jobinterview;

public class Solution2 {
	
	private String letterX;
	private String letterY;
	private static int maxRep = 2;
	
	public static void main(String[] args) {
		
		String solution = new Solution2().solution(5, 3);
		System.out.println(solution);
	}
	
    public String solution(int A, int B) {
    	
    	int x=0;
    	int y=0;
    	
    	// Which letter to start printing
    	// where x holds the first and y the second
    	if(A >= B) {
    		x=A;
    		letterX="a";
    		y=B;
    		letterY="b";
    		
    	} else {
    		x=B;
    		letterX="b";
    		y=A;
    		letterY="a";
    	}
    	
    	return printLetters(x, y);
    	
    }

	private String printLetters(int x, int y) {
		String print = "";
    	int repX = 0;
    	int repY = 0;
    	int missingX=x;
    	int missingY=y;
    	
    	for(int i=0; i<=x; i++) {
    		
    		if(missingX>0 && repX<maxRep && repY==0) {
    			print += letterX;
    			missingX--;
    			repX++;
    			if(repX==maxRep || missingX==0) {
    				repX=0;
    			} else {
    				continue;
    			}
    		}
    		
    		if(missingY>0 && repY<maxRep && repX==0) {
    			print += letterY;
    			missingY--;
    			repY++;
    			if(repY==maxRep || missingY==0) {
    				repY=0;
    			} else {
    				continue;
    			}
    		}
    	}
		return print;
	}

}

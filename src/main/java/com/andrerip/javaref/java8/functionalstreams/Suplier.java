package com.andrerip.javaref.java8.functionalstreams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

class Suplier {
	
	static AtomicInteger atomicInteger;
	
    public static Supplier<Integer> getInfiniteRange() {
    	if(atomicInteger==null) {
    		atomicInteger = new AtomicInteger();
    	}
    	return () -> atomicInteger.getAndIncrement();
    }
    
    public static void main(String[] args) {
    	Supplier<Integer> sup1 = getInfiniteRange();
    	Supplier<Integer> sup2 = getInfiniteRange();
    	 
    	for(int i = 0; i < 5; i++) {
    	    System.out.print(sup1.get() + " " + sup2.get() + " ");
    	}
	}
}
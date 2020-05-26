package com.andrerip.javaref.java8;


import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

import javax.swing.JButton;

public class TesteLambda {

//	public static void main(String[] args) {
//		Function<Integer, Integer> subtrai = x -> x-1;
//		Integer apply = subtrai.apply(5);
//		System.out.println(apply);
		
//		int constant = 100;
//		Function<Integer, Integer> adder = x -> x + constant;
//		 
//		System.out.println(adder.apply(200));
//		System.out.println(adder.apply(300));
//		
//		
//		Runnable runnable = () -> {
//			System.out.println("Olá");
//		};
//		Thread thread = new Thread(runnable);
//		
//		
//		Comparator<String> comparator = (x,y) -> x.compareTo(y);
//		
//		ActionListener listener = x -> {
//			System.out.println(x);
//		};
		
//	}
	
//	public static void main(String[] args) {
//		
//		Function<Long, Long> nextEven = x -> x%2==0 ? x+2 : x+1;
//		
//		Long nextEvenNumber = nextEven.apply(2L);
//		System.out.println(nextEvenNumber);
//		
//	}
	
	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "cde";
		
		String s3 = s1.toUpperCase()+s2.toUpperCase();
		System.out.println(s3);
		
		
	}

}

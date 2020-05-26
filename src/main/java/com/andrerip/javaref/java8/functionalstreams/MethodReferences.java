package com.andrerip.javaref.java8.functionalstreams;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

	public static void main(String[] args) {
		
		/*
		 * The Consumer is a functional interface with a single abstract method accept
		 * which takes a value of type T and returns nothing.
		 */
		Consumer<String> printer = str -> System.out.println(str);
		// OR
		Consumer<String> printer1 = System.out::println;
		
		
		/*
		 * There are four kinds of method references:
		 * 
		 * reference to a static method; 
		 * reference to an instance method of an existing object; 
		 * reference to an instance method of an object of a particular type;
		 * reference to a constructor.
		 */
		
//		1) Reference to a static method
		Function<Double, Double> sqrt = Math::sqrt;
		System.out.println(sqrt.apply(9d));
		
//		2) Reference to an instance (non-static) method of an existing object
		/*
		 * Supplier<String> is a functional interface with the single abstract method
		 * get which takes no arguments and returns a result of the String type.
		 */
		Scanner scanner = new Scanner(System.in); // IO scanner
		Supplier<String> lineReader = scanner::nextLine; // method reference
		
//		3) Reference to an instance method of an object of a particular type
		Function<Long, Double> converter = Long::doubleValue;
		converter.apply(100L); // the result is 100.0d
		converter.apply(200L); // the result is 200.0d
		
//		4) Reference to a constructor
		Supplier<String> generator = String::new;
		// better than the lambda expression:
		Supplier<String> generator1 = () -> new String();
		
		
	}

}

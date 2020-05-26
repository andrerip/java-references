package com.andrerip.javaref.java8.functionalstreams;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfaces {
	
	public static void acceptFunctionalInterface(Function<Integer, Integer> f) {
		   System.out.println(f.apply(10));
		}

	public static void main(String[] args) {

		// Anonymous class
		Function<Long, Long> square1 = new Function<Long, Long>() {
		    @Override
		    public Long apply(Long val) {
		        return val * val;
		    }
		};
		long val1 = square1.apply(10L); // the result is 100L
		
		// O mesmo de cima usando Lambda expressions...
		Function<Long, Long> square2 = val -> val * val; // the lambda expression
		long val2 = square2.apply(10L); // the result is 100L
		
		// --------------------------- Other ways ---------------------
		
		// a simple way to write a lambda expression with two parameters
		BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
		 
		// if it has only one argument "()" are optional
		Function<Integer, Integer> identity1 = x -> x;
		 
		// it's valid too
		Function<Integer, Integer> identity2 = (x) -> x;
		 
		// without type inference
		Function<Integer, Integer> mult = (Integer x) -> x * 2;
		 
		// with multiple statements
		Function<Integer, Integer> adder = (x) -> {
		    x += 5;
		    x += 10;
		    return x;
		};
		
		// ------------------------Passing lambda expressions to methods ------------
		/*
		 * Inside the method acceptFunctionalInterface, the given function will be
		 * invoked. In enterprise programming, it is often called the callback.
		 * According to Wikipedia:
		 * "a callback is a piece of executable code that is passed as an argument to other code, 
		 * which is expected to call back (execute) the argument at some convenient time."
		 */
		// it returns the next value
		Function<Integer, Integer> f = (x) -> x + 1;
		 
		acceptFunctionalInterface(f); // it prints 11
		 
		// or even without a reference
		acceptFunctionalInterface(x -> x + 1); // the result is the same: 11
		
		
		// ---------------------  Usage of Closures -----------------------------
		/*
		 * In the body of a lambda expression, it's possible to capture values from a
		 * context where the lambda is defined. This technique is called closure.
		 */
		final String hello = "Hello, ";
		Function<String, String> helloFunction = (name) -> hello + name;
		 
		System.out.println(helloFunction.apply("John"));
		System.out.println(helloFunction.apply("Anastasia"));
		
		
		int constant = 100;
		Function<Integer, Integer> adder1 = x -> x + constant;
		 
		System.out.println(adder1.apply(200));
		System.out.println(adder1.apply(300));
		
		
	}

}

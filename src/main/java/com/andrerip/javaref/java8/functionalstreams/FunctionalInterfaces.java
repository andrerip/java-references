package com.andrerip.javaref.java8.functionalstreams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

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
		
		
		// ----------------------- Kind of functional interfaces ----------------------
		/*
		 * - functions accept arguments and produce results. 
		 * - operators produce results of the same type as their arguments (a special case of function). 
		 * - predicates return boolean values and accept any arguments (boolean-valued function).
		 * - suppliers return values and accept nothing. 
		 * - consumers accept arguments and return no result.
		 */
		
		/*
		 * Some examples:
		 * 
		 * Function<T, R> accepts a value of type T and produces a result of type R.
		 * 
		 * BiFunction<T, U, R> accepts two values of T and U types and produces a result of type R. 
		 * 
		 * LongFunction<R> accepts a long value and produces a result of type R. 
		 * 
		 * IntToDoubleFunction accepts an integer value and produces a double value.
		 * 
		 * IntPredicate accepts an integer value and returns boolean value. 
		 * 
		 * Supplier<T> returns a value of type T. 
		 * 
		 * BiConsumer<T, U> accepts two values of T and U types. 
		 * 
		 * and others...
		 */
		
//		1) Functions
		// String to Integer function
		Function<String, Integer> converter = Integer::parseInt;
		converter.apply("1000"); // the result is 1000 (Integer)
		 
		// String to int function
		ToIntFunction<String> anotherConverter = Integer::parseInt;
		anotherConverter.applyAsInt("2000"); // the result is 2000 (int)
		 
		// (Integer, Integer) to Integer function
		BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
		sumFunction.apply(2, 3); // it returns 5 (Integer)
		
		//	there are no standard functions that take more than two arguments.
		
		
//		2) Operators
		// int to int operator
		IntUnaryOperator intMultiplier = val -> 100 * val;
		intMultiplier.applyAsInt(10); // the result is 1000 (int)
		 
		// Long to Long multiplier
		UnaryOperator<Long> longMultiplier = val -> 100_000 * val;
		longMultiplier.apply(2L); // the result is 200_000L (Long)
		        
		// (String, String) to String operator
		BinaryOperator<String> appender = (str1, str2) -> str1 + str2;
		appender.apply("str1", "str2"); // the result is "str1str2"
		
		/*
		 * Also, there are other operators: IntUnaryOperator, LongUnaryOperator,
		 * DoubleUnaryOperator, IntBinaryOperator, LongBinaryOperator,
		 * DoubleBinaryOperator.
		 * 
		 * Any operator takes and returns values of the same type.
		 */
		
		
//		3) Predicates
		// int to boolean predicate
		IntPredicate isEven = val -> val % 2 == 0;
		isEven.test(10); // the result is true (boolean)
		 
		// Character to boolean predicate
		Predicate<Character> isDigit = Character::isDigit;
		isDigit.test('h'); // the result is false (boolean)
		
		/*
		 * Also, there are other predicates: LongPredicate, DoublePredicate,
		 * BiPredicate<T, U>.
		 * 
		 * Any predicate always returns the value of the boolean type (primitive).
		 */
		
		
//		4) Suppliers
		Supplier<String> stringSupplier = () -> "Hello";
		stringSupplier.get(); // the result is "Hello" (String)
		 
		BooleanSupplier booleanSupplier = () -> true;
		booleanSupplier.getAsBoolean(); // the result is true (boolean)
		 
		IntSupplier intSupplier = () -> 33;
		intSupplier.getAsInt(); // the result is 33 (int)
		
		/*
		 * Also, there are other suppliers: LongSupplier, DoubleSupplier.
		 * 
		 * Any supplier always doesn't take any arguments and returns a value.
		 */		
		
		
//		5) Consumers
		// it prints a given string
		Consumer<String> printer = System.out::println;
		printer.accept("!!!"); // It prints "!!!"
		
		/*
		 * Also, there are other consumers: IntConsumer, LongConsumer, DoubleConsumer,
		 * BiConsumer<T, U>, ObjIntConsumer<T>, ObjLongConsumer<T>,
		 * ObjDoubleConsumer<T>.
		 * 
		 * Any consumer doesn't return a value.
		 */		
		
		
		
	}

}

package com.andrerip.javaref.java8.functionalstreams;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class SteamsAPI {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

//		All classes related to streams are located in the java.util.stream package.
		
		/*
		 * There are several stream classes in Java: Stream<T>, IntStream, LongStream
		 * and DoubleStream. While generic stream works with reference types, three
		 * other streams work with corresponding primitive types. Further, we will
		 * consider what and when is better to use.
		 */
		
		// the list values is filled with some elements
		List<Integer> values = new ArrayList<>();
		values.add(100);
		values.add(8);
		values.add(11);
		
		List<Integer> filteredValues = new ArrayList<>();
		for (Integer val : values) {
		    if (val >= 10) {
		        filteredValues.add(val);
		    }
		}
		System.out.println(filteredValues);
		
//		The same functionality with Stream API is shown below.
		// the list values is filled with some elements
		List<Integer> filteredValues1 = values.stream()
		        .filter(val -> val >= 10)
		        .collect(Collectors.toList());
		System.out.println(filteredValues1);
		
		/*
		 * when we apply method filter to a stream, nothing is evaluated. Only terminal
		 * operations begin evaluations (for example, collect). Because of it, streams
		 * are called lazy.
		 */
		
		
		// --------------------- Creating Streams ---------------------------------------------------------
		/*There are a lot of ways to create a stream in Java including from a list, a set, a string, an array and so on.*/

//		1) The most common way to take a stream is to create it from a collection. Any collection has a method stream() for this purpose.
		List<Integer> famousNumbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
		Stream<Integer> numbersStream = famousNumbers.stream();
		 
		Set<String> usefulConcepts = new HashSet<>(Arrays.asList("functions", "lazy", "immutability"));
		Stream<String> conceptsStream = usefulConcepts.stream();
		
//		2) From an array
		Stream<Double> doubleStream = Arrays.stream(new Double[]{ 1.01, 1d, 0.99, 1.02, 1d, 0.99 });
		
//		3) From a string
		IntStream stream = "aibohphobia".chars(); // It returns IntStream!
		
//		4) From values
		LongStream longStream = LongStream.of(111_111_111L, 333_333_333L);
		
//		5) From other streams
		Stream<BigInteger> concatedStream = Stream.concat(Stream.empty(), Stream.empty());
		
//		6) Use Stream.generate()
		Stream<User> userStream = Stream.generate(User::new);
		DoubleStream randomStream = DoubleStream.generate(Math::random);
		
//		7) Use Stream.iterate()
		IntStream oddNumbersStream = IntStream.iterate(1, x -> x + 2);
		
//		8) Use Stream.range() or Stream.rangeClosed(). Method rangeClosed() includes an upper bound.
		LongStream rangedStream = LongStream.rangeClosed(100_000, 1_000_000);
		
//		There are also other ways to create a stream: from a file, from I/O stream and so on.
		
		
		// ----------------------------- Groups of stream operations ---------------------------------------------
/*		All stream operations are divided into two groups:

		Intermediate operations that are always lazy and returns a new stream, such as filter, map, limit, sorted, ...
		Terminal operations that returns a result or produce a side-effect, such as min, max, count, reduce, collect, ...
		Let's consider some common used operations.

		Intermediate operations

		- filter returns a stream including the elements that match a predicate
		- map returns a stream consisting of the elements that were obtained by applying a function (transforms each element)
		- limit returns a stream consisting of first N elements of this stream
		- distinct returns a stream that has only unique elements according to method equals
		- sorted returns a stream consisting of the elements sorted according to the natural order or a given comparator
		- flatMap allows to replace a value with a stream and concatenates all streams together
		
		Terminal operations

		- collect(toList) returns a list from the values in a stream, in general cases collect is a more complex operation
		- toArray returns an array from the values in a stream
		- max / min returns maximum / minimum element of the stream according to the given comparator
		- count returns the count of elements in the stream
		- forEach performs an operation for each element of the stream (be careful with side-effects!)
		- reduce combines values from the stream into a single value (aggregate value)
		- anyMatch returns true if at least one element matches a predicate (see also: allMatch, noneMatch)
		
		Remember: an intermediate operation always returns another stream, when a terminal operation returns a primitive type or 
		an object (even collection) or nothing (void). As soon as you call any terminal operation, the stream is closed. 
		If you try to use closed stream again,  java.lang.IllegalStateException is thrown.
*/
		Stream<Integer> stream1 = IntStream.range(1, 5).boxed();
		System.out.println(stream1.count()); // 4, calculates count and closes the stream
		List<Integer> list = stream1.collect(Collectors.toList()); // java.lang.IllegalStateException: stream has already been operated upon or closed
		
/*		Such operations (methods) as filter, map, reduce, forEach, anyMatch and some others are called higher-order functions because they accept other functions as their arguments.

		Example 1. Let's assume we have a list of words. We'd like to count the number of unique words in the list (ignoring the case). Let's do it with streams.
*/
		List<String> words = Arrays.asList("Java", "CLOSURE", "Function", "Lambda", "closure", "java"); 
		long countOfUniqueWords = words.stream()
		        .map(String::toUpperCase) // transform each word to the upper case (method reference)
		        .distinct() // intermediate operation: keep only unique words
		        .count();   // terminal operation: count of unique words
		
/*		Do not forget, only the count operation starts the evaluation process! The result is 4.

		Example 2. Let's create a stream from the list of integer numbers in the range [1, 10) and output each number in the standard output.
*/
		IntStream.range(1, 10).forEach(System.out::print);
		
		/*
		 * 1) creating an integer stream (a special type of stream) with values in the
		 * range [1, 10), i.e. 10 is excluded; 2) output each number in the same line.
		 * 
		 * This code outputs:
		 * 
		 * 123456789 As you see, Stream API makes data processing easier and our code
		 * more clear.
		 */
		
		
		// ---------------------- Classes of streams ------------------------------------------------------------------
/*		Stream<T> represents a sequence of elements of type T, but there are several other classes of streams: IntStream, LongStream and DoubleStream. They are primitive specializations of Stream<T>.

		These streams have some features:

		Their methods accept primitive-specialized functions. For example, IntStream.filter() accept IntPredicate, but not Predicate<Integer>.
		They have additional methods. For example, average() and summaryStatistics(). Also, IntStream and LongStream have two methods range() and rangeClosed() for generating streams from integer ranges.
		Using of primitive specialized functions and streams have the performance benefits because it allows to avoid boxing and unboxing operations and not only.
		Finally, we'd like to calculate the number of elements, max, min and the average value in a stream. Let's use IntStream to do it!*/

		IntSummaryStatistics stat = IntStream.rangeClosed(1, 55_555).summaryStatistics();
		 
		System.out.println(String.format("Count: %d, Min: %d, Max: %d, Avg: %.1f",
		        stat.getCount(), stat.getMin(), stat.getMax(), stat.getAverage()));
		
		/*		The result is shown below. You can't do the same with Stream<Integer>.

		Count: 55555, Min: 1, Max: 55555, Avg: 27778.0
		It should be noted:

		to transform a stream of primitives into generalized stream there is boxed method (IntStream => Stream<Integer>)
		to transform a generalized stream into a stream of primitives there are special types of map function: mapToInt, mapToLong, mapToDouble.
		some methods, including min and max, return an object of an Optional type instead of a plain value. This class can be regarded as a container of a plain value that protects code from NullPointerException. Method get can be used to obtain a plain value if it is present, or null in case of absence.
		Pay attention there is no CharStream in Java.*/
		
	}

}

package program;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
	
	public static void main (String[] args) {
		
		List<Integer> list = Arrays.asList(3, 4, 5, 6, 7, 8);
		
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 1);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		Stream<BigInteger> st4 = Stream.iterate(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, p -> new BigInteger[] {p[1], p[0].add(p[1])}).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(99999).toArray()));
	}
}

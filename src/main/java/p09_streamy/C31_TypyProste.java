package p09_streamy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class C31_TypyProste {

	public static void main(String[] args) {
		DoubleStream losowe = DoubleStream.generate(Math::random);
		
		losowe.limit(100).forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		Random random = new Random();
		double sumaLosowych1 = random.doubles().limit(10).sum();
		System.out.println(sumaLosowych1);
		
		random.ints(10, 100, 200).forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		LongStream potegi = LongStream.iterate(1, x -> x*2);
		potegi.limit(65).forEach(x -> System.out.println(x));
		System.out.println();
		
		IntStream.range(0, 10).forEach(x -> System.out.print(x + ", "));
		System.out.println();
		IntStream.rangeClosed(0, 10).forEach(x -> System.out.print(x + ", "));
		
		IntStream str_int = IntStream.rangeClosed(0, 10);

		// tłumaczenie między strumieniem intów a strumieniem Integerów:
		Stream<Integer> str_Integer = str_int.boxed();
		IntStream str_int2 = str_Integer.mapToInt(Integer::intValue);
		// IntStream str_int3 = str_Integer.mapToInt(x -> x);
		
		List<Integer> liczby = IntStream.range(0, 100)
				.map(i -> i*i)
				.boxed()   // zmienia IntStream na Stream<Integer>
				.collect(Collectors.toList());	
					
		System.out.println(liczby);

	}

}

package p10_parallel_i_spliterator;

import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestStrumienNieparzystych {

	public static void main(String[] args) {
		Consumer<Integer> akcja = i -> System.out.print(i + ", ");

		SpliteratorLiczbyNieparzyste spl1 = new SpliteratorLiczbyNieparzyste(100);		
		Stream<Integer> str1 = StreamSupport.stream(spl1, false);
		str1.forEach(akcja);
		System.out.println();
		System.out.println();
		
		SpliteratorLiczbyNieparzyste spl2 = new SpliteratorLiczbyNieparzyste(100);		
		Stream<Integer> str2 = StreamSupport.stream(spl2, true);
		str2.forEach(akcja);
		System.out.println();
		System.out.println();
		
		SpliteratorLiczbyNieparzyste spl3 = new SpliteratorLiczbyNieparzyste(50);		
		Stream<Integer> str3 = StreamSupport.stream(spl3, false);
		int suma3 = str3.mapToInt(x -> x).sum();
		System.out.println(suma3);
		
		SpliteratorLiczbyNieparzyste spl4 = new SpliteratorLiczbyNieparzyste(50);		
		Stream<Integer> str4 = StreamSupport.stream(spl4, true);
		int suma4 = str4.mapToInt(x -> x).sum();
		System.out.println(suma4);

	}

}

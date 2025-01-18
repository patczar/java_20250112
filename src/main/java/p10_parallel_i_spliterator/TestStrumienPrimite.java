package p10_parallel_i_spliterator;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class TestStrumienPrimite {

	public static void main(String[] args) {
		IntConsumer akcja = i -> System.out.print(i + ", ");

		SpliteratorPrimitive spl1 = new SpliteratorPrimitive(100);		
		IntStream str1 = StreamSupport.intStream(spl1, false);
		str1.forEach(akcja);
		System.out.println();
	}

}

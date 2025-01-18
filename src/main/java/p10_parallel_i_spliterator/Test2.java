package p10_parallel_i_spliterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test2 {

	// Spliterator sztucznie spowolniony, Stream<Integer>, widać zysk z parallel
	public static void main(String[] args) {
		Spliterator<Integer> spl1 = new SpliteratorPowolny(10000000);		
		Stream<Integer> str1 = StreamSupport.stream(spl1, false);
		
		MierzenieCzasu.uruchom(() -> str1.mapToLong(x->x).sum());
		
		Spliterator<Integer> spl2 = new SpliteratorPowolny(10000000);		
		Stream<Integer> str2 = StreamSupport.stream(spl2, true);
		
		MierzenieCzasu.uruchom(() -> str2.mapToLong(x->x).sum());

	}

}

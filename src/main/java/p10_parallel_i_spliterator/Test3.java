package p10_parallel_i_spliterator;

import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class Test3 {

	public static void main(String[] args) {
		// IntStream bez żadnego boxingnu - działa najszybciej
		
		SpliteratorPrimitive spl1 = new SpliteratorPrimitive(10000000);		
		IntStream str1 = StreamSupport.intStream(spl1, false);
		
		MierzenieCzasu.uruchom(() -> str1.sum());
		
		SpliteratorPrimitive spl2 = new SpliteratorPrimitive(10000000);		
		IntStream str2 = StreamSupport.intStream(spl2, true);
		
		MierzenieCzasu.uruchom(() -> str2.sum());
	}

}

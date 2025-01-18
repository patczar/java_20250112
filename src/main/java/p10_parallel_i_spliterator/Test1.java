package p10_parallel_i_spliterator;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test1 {

	// Stream<Integer> bez spowalniania. Niepotrzebny narzut na boxing
	public static void main(String[] args) {
		SpliteratorLiczbyNieparzyste spl1 = new SpliteratorLiczbyNieparzyste(10000000);		
		Stream<Integer> str1 = StreamSupport.stream(spl1, false);
		
		MierzenieCzasu.uruchom(() -> str1.mapToInt(x->x).sum());

		SpliteratorLiczbyNieparzyste spl2 = new SpliteratorLiczbyNieparzyste(10000000);		
		Stream<Integer> str2 = StreamSupport.stream(spl2, true);
		
		MierzenieCzasu.uruchom(() -> str2.mapToInt(x->x).sum());
		System.out.println();
	}
}

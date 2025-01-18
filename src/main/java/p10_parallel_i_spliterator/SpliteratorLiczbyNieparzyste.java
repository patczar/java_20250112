package p10_parallel_i_spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorLiczbyNieparzyste implements Spliterator<Integer> {
	private int max;
	private int min;

	// domyślnie 100 liczb
	public SpliteratorLiczbyNieparzyste() {
		this(100);
	}
	public SpliteratorLiczbyNieparzyste(int ile) {
		this(0, ile);
	}

	private SpliteratorLiczbyNieparzyste(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	private int next() {
		return 1 + 2 * min++;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Integer> action) {
		if(min < max) {
			action.accept(this.next());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public SpliteratorLiczbyNieparzyste trySplit() {
		int middle = (max + min) / 2;
		
		SpliteratorLiczbyNieparzyste nowy = new SpliteratorLiczbyNieparzyste(min, middle);
		min = middle;
		return nowy;
	}

	@Override
	public long estimateSize() {
		return max - min;
	}

	@Override
	public int characteristics() {
		return ORDERED | DISTINCT | SIZED | SUBSIZED | NONNULL;
	}
	
}

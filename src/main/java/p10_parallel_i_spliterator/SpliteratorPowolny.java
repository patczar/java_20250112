package p10_parallel_i_spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorPowolny implements Spliterator<Integer> {
	private int max;
	private int min;
	private int niepotrzebne;
	private final int SPOWOLNIENIE = 10000;

	// domyślnie 100 liczb
	public SpliteratorPowolny() {
		this(100);
	}
	public SpliteratorPowolny(int ile) {
		this(0, ile);
	}

	private SpliteratorPowolny(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	private int next() {
		for(int i=0; i<SPOWOLNIENIE; i++) {
			niepotrzebne++;
		}
		return 1 + 2 * min++;
	}

	private boolean hasNext() {
		return min < max;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Integer> action) {
		action.accept(this.next());
		return hasNext();
	}

	@Override
	public SpliteratorPowolny trySplit() {
		int middle = (max + min) / 2;
		
		SpliteratorPowolny nowy = new SpliteratorPowolny(min, middle);
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

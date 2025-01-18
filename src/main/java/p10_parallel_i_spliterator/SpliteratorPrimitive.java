package p10_parallel_i_spliterator;

import java.util.Spliterator;
import java.util.function.IntConsumer;

public class SpliteratorPrimitive implements Spliterator.OfInt {
	private int max;
	private int min;

	// domyślnie 100 liczb
	public SpliteratorPrimitive() {
		this(100);
	}
	public SpliteratorPrimitive(int ile) {
		this(0, ile);
	}

	private SpliteratorPrimitive(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	private int next() {
		return 1 + 2 * min++;
	}

	private boolean hasNext() {
		return min < max;
	}

	@Override
	public boolean tryAdvance(IntConsumer action) {
		action.accept(this.next());
		return hasNext();
	}

	@Override
	public SpliteratorPrimitive trySplit() {
		int middle = (max + min) / 2;
		
		SpliteratorPrimitive nowy = new SpliteratorPrimitive(min, middle);
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

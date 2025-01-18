package p10_parallel_i_spliterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

// Morał: LinkedList nie dzieli się na fragmenty, więc operacje nie będą zrównoleglane
public class LinkedListSplit {

	public static void main(String[] args) {
		List<String> lista = new LinkedList<>();		
		lista.add("aaa");
		lista.add("bbb");
		lista.add("ccc");
		lista.add("ddd");
		lista.add("eee");
		lista.add("fff");
		lista.add("ggg");
		lista.add("hhh");
		lista.add("iii");
		lista.add("jjj");
		
		System.out.println(lista);
		
		Consumer<String> akcja = s -> System.out.println("* " + s);
		
		System.out.println("Pętla tryAdvance:");
		Spliterator<String> spliterator1 = lista.spliterator();
		while(spliterator1.tryAdvance(akcja));
		System.out.println();

		System.out.println("forEachRemaining:");
		Spliterator<String> spliterator2 = lista.spliterator();
		spliterator2.forEachRemaining(akcja);
		System.out.println();

		System.out.println("trySplit 2 poziomy:");
		Spliterator<String> spliterator3 = lista.spliterator();
		System.out.println("estimate size: " + spliterator3.estimateSize());
		
		Spliterator<String> spliterator3a = spliterator3.trySplit();
		
		System.out.println("Oryginalny:");
		spliterator3.forEachRemaining(akcja);

		System.out.println("wynik pierwszego split:");
		spliterator3a.forEachRemaining(akcja);

		System.out.println();

		
		System.out.println("trySplit 3 poziomy:");
		Spliterator<String> spliterator4 = lista.spliterator();
		System.out.println("estimate size: " + spliterator4.estimateSize());
		
		Spliterator<String> spliterator4a = spliterator4.trySplit();
		Spliterator<String> spliterator4b = spliterator4.trySplit();
		System.out.println("4a " + spliterator4a);
		System.out.println("4b " + spliterator4b);  // null
		
		System.out.println("Oryginalny:");
		spliterator4.forEachRemaining(akcja);

		System.out.println("wynik pierwszego split:");
		spliterator4a.forEachRemaining(akcja);

// NPE
//		System.out.println("wynik drugiego split:");
//		spliterator4b.forEachRemaining(akcja);

		System.out.println();

	}

}

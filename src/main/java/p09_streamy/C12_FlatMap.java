package p09_streamy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C12_FlatMap {
	
	static List<Integer> generuj(int ilosc) {
		List<Integer> lista = new ArrayList<>();
		for(int i = 1; i <= ilosc; i++) {
			lista.add(i);
		}
		return lista;
	}
	
	static Stream<Integer> generujStrumien(int ilosc) {
		List<Integer> lista = new ArrayList<>();
		for(int i = 1; i <= ilosc; i++) {
			lista.add(i);
		}
		return lista.stream();
	}
	
	static IntStream generujStrumienIntow(int ilosc) {
		List<Integer> lista = new ArrayList<>();
		for(int i = 1; i <= ilosc; i++) {
			lista.add(i);
		}
		return lista.stream().mapToInt(Integer::intValue);
	}
	

	public static void main(String[] args) {
		System.out.println(generuj(1));
		System.out.println(generuj(3));
		System.out.println(generuj(5));
		System.out.println();
		
		System.out.println("Elementy strumienia wejściowego:");
		Stream.of(1, 3, 5)
			.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		System.out.println();

		System.out.println("Zwykłe mapowanie:");
		Stream.of(1, 3, 5)
			.map(C12_FlatMap::generuj)
			.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		
		Stream.of(1, 3, 5)
			.map(x -> C12_FlatMap.generuj(x).stream())
			.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		System.out.println();

		System.out.println("Płaskie mapowanie:");
		Stream.of(1, 3, 5)
			.flatMap(x -> C12_FlatMap.generuj(x).stream())
			.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		System.out.println();

		Stream.of(1, 3, 5)
			.flatMap(C12_FlatMap::generujStrumien)
			.forEach(x -> System.out.print(x + " | "));
		System.out.println();
		System.out.println();
		
		int suma = Stream.of(1, 3, 5)
			.flatMapToInt(C12_FlatMap::generujStrumienIntow)
			.sum();
		System.out.println(suma);
	}

}

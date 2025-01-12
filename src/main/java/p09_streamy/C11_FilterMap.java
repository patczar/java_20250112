package p09_streamy;

import java.util.stream.Stream;

public class C11_FilterMap {

	public static void main(String[] args) {
		String[] imiona = {"Ala", "Ola", "Basia", "Kasia", "Ela", "Ula", "Agnieszka", "Magdalena", "Anna", "Hanna", "Joanna", "Ala", "Agata", "Genowefa", "Grażyna", "Karolina", "Julia", "Zuzanna"};

		Stream.of(imiona)
			.filter(s -> s.length() >= 5)
			.forEach(System.out::println);
		System.out.println();
		
		Stream.of(imiona)
			.map(String::toUpperCase)
			.forEach(System.out::println);
		System.out.println();
		
		Stream.of(imiona)
			.filter(s -> s.startsWith("A"))
			.map(String::length)  // Stream<String> -> Stream<Integer>
			.forEach(System.out::println);
		
		Stream.of(imiona)
			.filter(s -> s.startsWith("A"))
			.mapToInt(String::length)  // Stream<String> -> IntStream
			.forEach(System.out::println);
	}

}

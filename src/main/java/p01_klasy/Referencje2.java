package p01_klasy;

import java.time.LocalDate;

public class Referencje2 {
	
	static void metoda(Konto a, Konto b, int x) {
		System.out.println("Początek metody");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("x: " + x);
		System.out.println();
		
		x += 55;
		a = b;
		b.wplata(48);
		
		System.out.println("Koniec metody");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("x: " + x);
		System.out.println();		
	}

	public static void main(String[] args) {
		Osoba ala = new Osoba("Ala", "Kowalska", LocalDate.of(2000, 2, 3));
		Osoba ola = new Osoba("Ola", "Malinowska", LocalDate.of(2000, 2, 3));
		
		Konto a = new Konto(1, 1000, ala);
		Konto b = new Konto(2, 2000, ola);
		int x = 5000;
		
		System.out.println("Początek main");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("x: " + x);
		System.out.println();
		
		metoda(a, b, x);
		
		System.out.println("Koniec main");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("x: " + x);
	}

}

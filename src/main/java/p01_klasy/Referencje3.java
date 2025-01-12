package p01_klasy;

import java.time.LocalDate;

public class Referencje3 {
	
	static void metoda(Konto a, Konto b, Konto c, int x) {
		System.out.println("Początek metody:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("x: " + x);
		System.out.println();
		
		x += 55;		
		b.wplata(48);
		
		a = new Konto(a.getNumer(), a.getSaldo(), a.getWlasciciel());
		a.wplata(33);
		a.getWlasciciel().setImie("Alicja");
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("x: " + x);
		System.out.println();
	}

	public static void main(String[] args) {
		Osoba ala = new Osoba("Ala", "Kowalska", LocalDate.of(2000, 2, 3));
		Osoba ola = new Osoba("Ola", "Malinowska", LocalDate.of(2000, 2, 3));

		Konto a = new Konto(1, 1000, ala);
		Konto b = new Konto(2, 2000, ola);
		Konto c = b;
		int x = 5000;
		
		System.out.println("Początek main:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("x: " + x);
		System.out.println();
		
		metoda(a, b, c, x);
		
		System.out.println("Koniec main:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("x: " + x);
	}

}

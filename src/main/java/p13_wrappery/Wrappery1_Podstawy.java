package p13_wrappery;

public class Wrappery1_Podstawy {

	public static void main(String[] args) {
		// Dla każdego z 8 typów prostych istnieje odpowiadająca mu klasa ("opakowaniowa"?), tzw. "wrapper".
		// Obiekt klasy wrapper zawiera w sobie wartość danego typu.
		// Wszystkie klasy wrapperów są NIEMUTOWALNE, tzn. wartość w obiekcie nigdy nie ulega zmianie; /na zmienną typu wrapper można wpisać nowy obiekt, ale to nie to samo./
		
		int i = 103;
		
		// Obiekt klasy opakowaniowej na podstawie wartości można utworzyć:
		//  - za pomocą konstruktora (obecnie niezalecane)
		Integer ii1 = new Integer(i);
		//  - za pomocą metody valueOf
		Integer ii2 = Integer.valueOf(i);
		//  - za pomocą automatycznej konwersji (autoboxing, od Javy 5); wewnętrznie jest to realizowane za pomocą valueOf
		Integer ii3 = i;
		
		byte y = 15;
		Byte yy1 = new Byte(y);
		Byte yy2 = Byte.valueOf(y);
		Byte yy3 = y;
		
		short s = 10_000;
		Short ss1 = new Short(s);
		Short ss2 = Short.valueOf(s);
		Short ss3 = s;
		
		long l = 4_000_000L;
		Long ll1 = new Long(l);
		Long ll2 = Long.valueOf(l);
		Long ll3 = l;
		
		float f = 3.14F;
		Float ff1 = new Float(f);
		Float ff2 = Float.valueOf(f);
		Float ff3 = f;
		
		double d = 1.4142;
		Double dd1 = new Double(d);
		Double dd2 = Double.valueOf(d);
		Double dd3 = d;
		
		char c = 'A';
		Character cc1 = new Character(c);
		Character cc2 = Character.valueOf(c);
		Character cc3 = c;
		
		boolean b = true;
		Boolean bb1 = new Boolean(b);
		Boolean bb2 = Boolean.valueOf(b);
		Boolean bb3 = b;
		
		// Dodatkowo istnieje klasa Void, odpowiadająca typowi void.
		// Nie da się utworzyć obiektu tej klasy.
		Void v = null;
	}

}

package p13_wrappery;

public class Wrappery7_Parsowanie {

	public static void main(String[] args) {
		String tekst = "1234";
		
		// typ wyniku int
		int x = Integer.parseInt(tekst);
		System.out.println(2*x);
		
		// typ wyniku Integer
		Integer y = Integer.valueOf(tekst);
		
		// skompiluje się też, ale mnie wydajne:
		int xx = Integer.valueOf(tekst);
		Integer yy = Integer.parseInt(tekst);
		
		double d = Double.parseDouble(tekst);
		System.out.println(d);
	}

}

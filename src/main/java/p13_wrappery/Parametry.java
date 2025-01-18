package p13_wrappery;

import java.util.concurrent.atomic.AtomicInteger;

public class Parametry {

	static void test(int i, Integer j, AtomicInteger k) {
		i += 5;
		j += 6; // to nie zmienia wartości wewnątrz obiektu, tylko tworzy nowy obiekt
		        // tak jakby: j = new Integer(j.intValue() + 6);
		k.addAndGet(7);
		System.out.println("i: " + i + " , j: " + j + " , k: " + k);
	}
	
	public static void main(String[] args) {
		int x = 100;
		Integer y = 200;
		// Integer y = new Integer(200); // zadziała tak samo
		AtomicInteger z = new AtomicInteger(300);
		
		System.out.println("x: " + x + " , y: " + y + " , z: " + z);
		test(x, y, z);
		System.out.println("x: " + x + " , y: " + y + " , z: " + z);
	}

}

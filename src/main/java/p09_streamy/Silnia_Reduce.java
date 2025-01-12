package p09_streamy;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Silnia_Reduce {
	static long silniaFun(int n) {
		return LongStream.rangeClosed(2, n)
				.reduce(1L, (a, i) -> a * i);
	}

	static long silniaKlasyczna(int n) {
		// działa jak taka pętla:
		long a = 1L;
		for(int i = 2; i <= n; i++) {
			a = a * i;
		}
		return a;
	}
	
	static long silniaFun2(int n) {
		return LongStream.rangeClosed(2, n)
				.reduce(1, Math::multiplyExact);
	}

	static BigInteger silniaFunBig(int n) {
		return IntStream.rangeClosed(2, n)
			.mapToObj(BigInteger::valueOf)
			.reduce(BigInteger.ONE, BigInteger::multiply);
	}

	public static void main(String[] args) {
		System.out.println(silniaFun(5));
		System.out.println(silniaFun2(5));
		
		try {
			System.out.println(silniaFun2(21));
		} catch (Exception e) {
			System.out.println("overflow");
		}
		
		System.out.println(silniaFunBig(5));
		System.out.println(silniaFunBig(100));
	}
}

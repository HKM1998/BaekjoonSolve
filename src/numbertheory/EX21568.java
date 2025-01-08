package numbertheory;

import java.util.Scanner;

public class EX21568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		long gcd = gcd(A, B);
		if (C % gcd != 0)
			System.out.println(-1);
		else {
			int mok = (int) (C / gcd);
			long[] ret = excute(A, B);
			System.out.println(ret[0] * mok + " " + ret[1] * mok);
		}

	}

	static long[] excute(long A, long B) {
		long[] ret = new long[2];
		if (B == 0) {
			ret[0] = 1;
			ret[1] = 0;
			return ret;
		}
		long q = A / B;
		long[] v = excute(B, A % B);
		ret[0] = v[1];
		ret[1] = v[0] - v[1] * q;
		return ret;
	}

	static long gcd(long A, long B) {
		if (A % B == 0)
			return B;
		else
			return gcd(B, A % B);
	}
}

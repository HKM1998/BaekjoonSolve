package numbertheory;

import java.util.Scanner;

public class EX1850 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		long oneCount = gcd(A,B);
		System.out.println("1".repeat((int)oneCount));
	}
	
	static long gcd(long A, long B) {
		if(A%B==0) return B;
		else return gcd(B, A%B);
	}
}

package numbertheory;

import java.util.Scanner;

public class EX11689 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong(); //1,000,000,000,000 입력 범위
		long result = N;
		
		for(long i = 2 ; i <= Math.sqrt(N); i++) {
			if(N%i == 0) {
				result = result - (result/i);
			}
			while(N % i == 0)
				N /= i;
		}
		if(N > 1)
			result = result - (result/N);
		System.out.println(result);
	}

}

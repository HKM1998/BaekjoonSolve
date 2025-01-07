package numbertheory;

import java.util.Scanner;

public class EX4355 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = sc.nextInt();
			if(N == 0) break;
			if(N > 1)
				sb.append(disjoint(N) + "\n");
			else
				sb.append(0 + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static long disjoint(int N) {
		long result = N;

		for(long i =2; i*i <= N; i++) {
			if(N % i == 0) {
				result = result - (result/i);
			while(N % i == 0)
				N /= i;
			}
		}
		if(N > 1) {
			result = result - (result/N);
		}
		
		return result;
	}

}

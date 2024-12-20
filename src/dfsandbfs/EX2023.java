package dfsandbfs;

import java.util.Scanner;

public class EX2023 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 N = sc.nextInt();
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	static void DFS(int num, int i) {
		if(i == N) {
			if(isPrime(num))
				System.out.println(num);
			return;
		}
		// 각자리수가 아니라 왼쪽 1자리씩 늘어날때마다 각 값이 소수여야함!
		for(int j = 1; j < 10; j++ ) {
			if (j % 2 == 0) {
				continue;
			}
			if(isPrime(num*10 + j))
				DFS(num*10 + j,i+1);
		}
	}
	
	static boolean isPrime(int num) {
		for(int i = 2; i <= num / 2; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

}

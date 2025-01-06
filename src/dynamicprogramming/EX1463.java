package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX1463 {
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = 0;
		dp[1] = 0;
		int count = 0;

		System.out.println(topdown2(N, count));
	}

	static int topdown1(int N) {
		// 시간 초과
		if (dp[N] == null) {
			if (N % 6 == 0) {
				dp[N] = Math.min(topdown1(N - 1), Math.min(topdown1(N / 3), topdown1(N / 2))) + 1;
			} else if (N % 3 == 0) {
				dp[N] = Math.min(topdown1(N - 1), topdown1(N / 3)) + 1;

			} else if (N % 2 == 0) {
				dp[N] = Math.min(topdown1(N - 1), topdown1(N / 2)) + 1;

			} else {
				dp[N] = topdown1(N - 1) + 1;
			}
		}

		return dp[N];
	}
	
	static int topdown2(int N, int count) {
		if (N < 2) {
			return count;
		}
	    
		/*
		 N으로 각각 2와 3으로 나누면 count는 +1에 각 연산의
		 나머지 값을 더해준 것이 된다.
		 나머지 값은 빼기 1했을 때의 count 값과 같기 때문
		*/
		return Math.min(topdown2(N / 2, count + 1 + (N % 2)), topdown2(N / 3, count + 1 + (N % 3)));
	}
}
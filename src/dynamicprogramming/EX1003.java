package dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class EX1003 {
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws IOException {
		// 시간을 줄일 방법을 못찾아서 검색하였음
		// 다이내믹 프로그래밍에 대한 감을 조금 잡은듯함!
		// 참조 https://st-lab.tistory.com/124
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		for (int i = 0; i < T; i++) {
			Integer[] fibo = fibonacci(Integer.parseInt(br.readLine()));
			bw.write(fibo[0] + " " + fibo[1] + "\n");
		}
		bw.flush();
	}

	static Integer[] fibonacci(int N) {
		// 탐색하지 않은 값에 대해서만 탐색하고
		// 탐색하지 않은 값의 경우 재귀로 이전값도 모두 생성
		// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if(dp[N][0] == null || dp[N][1] == null) {
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
	}
	
	static Integer[] fibonacci2(int N) {
		// 반복문 풀이 
		// 값에 대한 패턴 분석으로 풀이한것 
		// 기본 값(N=0일 때)
		int zero = 1;
		int one = 0;
		int zero_plus_one = 1;
		 
		for (int i = 0; i < N; i++) {
			zero = one;	// 0호출 횟수를 이전의 1호출 횟수로 변경
			one = zero_plus_one;	// 1호출 횟수를 이전의 0과 1호출 횟수의 합으로 변경
			zero_plus_one = zero + one;	// 0과 1 호출의 합 계산
		}
		Integer[] arr = {zero, one};
		return arr;
	}
}

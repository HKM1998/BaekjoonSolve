package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX13977 {

	public static void main(String[] args) throws IOException {
		// 시간 초과로 실패 좀 더 공부해서 재도전 해야지!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long K = Integer.parseInt(st.nextToken());
			
			long result = bino_coef(N,K);
			
			System.out.println(result);
		}
	}

//	static long factorial(long n) {
//		long ans = 1;
//	    for(long i = 2; i < n+1; i++) {
//	        ans = (ans * i);
//	    }
//	    return ans;
//	}
//
//	static long bino_coef_factorial(long n, long k) {
//		
//	    return factorial(n) / factorial(k) / factorial(n-k);
//	}
	static long bino_coef(long n, long k) {
		if(k == 0 || k == n) return 1;
	    return (bino_coef(n -1,k) + bino_coef(n-1, k-1)) % 1000000007;
	}
}

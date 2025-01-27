package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX11053 {
	static int n;
	static int[] arr;
	static int[] dp;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n]; 
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i< n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n ; i ++ ) {
			int now = LIS(i);
			max = max < now ? now : max;
		}
		
		System.out.println(max);
	}
	
	static int LIS(int now) {
		if(dp[now] == 0) {
			dp[now] = 1;
			
			for(int i = now -1 ; i >=0; i--) {
				if(arr[i] < arr[now]) {
					dp[now] = Math.max(dp[now], LIS(i) + 1);
				}
			}
		}
		return dp[now];
	}
}

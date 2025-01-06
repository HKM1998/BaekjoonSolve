package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		
		
		for(int i = N-1; i >= 0; i --) {
			// 교재 확인 전 작성함
			// 왜 나누기, 나머지 생각 못했지...
//			if(K == 0) break;
//			while(arr[i] <= K) {
//				count++;
//				K -= arr[i];
//			}
			if(arr[i] <= K) {
				count += K/arr[i];
				K %= arr[i];
			}
		}
		
		System.out.println(count);
	}

}

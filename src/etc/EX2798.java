package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cardArray = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cardArray[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			for (int j = i+1; j<N;j++) {
				int sum1 = cardArray[i] + cardArray[j];
				for(int k = j+1; k < N; k++) {
					int sum2 = sum1 + cardArray[k];
					if (sum2 > M) continue;
					else if (sum2 > max)
						max = sum2;
				}
			}
			if(max == M)
				break;
		}
		System.out.println(max);
	}

}

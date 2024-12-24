package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int S = Integer.parseInt(st.nextToken());
			int sIndex = 0;
			int eIndex = N - 1;
			int midian = (sIndex + eIndex)/2;
			boolean isFind = false;
			while (sIndex < eIndex) {
				midian = (sIndex + eIndex)/2;
				if(S < A[midian]) {
					eIndex = midian-1;
				}else if(S > A[midian]){
					sIndex = midian+1;
				}else if(S == A[midian]){
					isFind = true;
					break;
				}
			}
			if(isFind) System.out.println(1);
			else System.out.println(0);
		}
	}

}

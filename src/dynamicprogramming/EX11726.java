package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX11726 {
	static int[] arr = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr[0] = arr[1] = 1;
		arr[2] = 2;
		System.out.println(topdown(Integer.parseInt(br.readLine())));
		
	}
	
	static int topdown(int N) {
		
		if(arr[N] == 0) {
			for(int i = 1; i <= 2; i++) {
				if (N - i >= 0)
					arr[N] += topdown(N-i);
			}
		}
		
		return arr[N] % 10007;
	}
}

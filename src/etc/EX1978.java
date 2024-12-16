package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int result = 0;
		boolean[] numArray = new boolean[1001];
		Arrays.fill(numArray, true);
		numArray[0] = false;
		numArray[1] = false;
		for (int i = 2; i <= Math.sqrt(1000); i++) {
			if (numArray[i] == false)
				continue;
			// 2,3,5,7
			for (int j = 2; i * j <= 1000; j++) {
				numArray[i * j] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (numArray[num] == true)
				result++;
		}
		System.out.println(result);
	}

}

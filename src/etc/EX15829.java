package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX15829 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] charArray = br.readLine().toCharArray();
		long[] hashArray = new long[n];
		hashArray[0] = 1;
		long M = 1234567891;
		for(int i = 1; i < n; i++) {
			long temp = 1;
			for(int j = 1; j <= i; j++) {
				temp = temp*31;
				temp %= M;
			}
			hashArray[i] = (long)temp;
		}
		long result = 0;
		for (int i = 0; i < n; i++) {
			long charNum = (long)charArray[i] - 'a' + 1;
			result += (charNum * hashArray[i]);
			result %= M;
		}
		System.out.println(result);
	}

}

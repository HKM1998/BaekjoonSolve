package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX13413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			char[] inputArr = br.readLine().toCharArray();
			char[] destArr = br.readLine().toCharArray();

			int inputWCount = 0;
			int destWCount = 0;
			int dCount = 0;

			for (int j = 0; j < N; j++) {
				if (inputArr[j] == destArr[j])
					continue;
				if (inputArr[j] == 'W')
					inputWCount++;
				if (destArr[j] == 'W')
					destWCount++;
				dCount++;
			}
			int temp = Math.abs(inputWCount - destWCount);
			if (temp == 0) {
				System.out.println(dCount / 2);
			} else {
				System.out.println((dCount + temp) / 2);
			}
		}
	}

}

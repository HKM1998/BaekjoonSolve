package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX16406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] myAnswer = br.readLine().toCharArray();
		char[] friendAnswer = br.readLine().toCharArray();
		int count = 0;
		for (int i = 0; i < myAnswer.length; i++) {
			if (myAnswer[i] == friendAnswer[i])
				count++;
		}
		System.out.println(myAnswer.length - Math.abs(k - count));
	}

}

package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX6321 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			char[] charArr = br.readLine().toCharArray();
			sb.append("String #" + i + "\n");
			for (int j = 0; j < charArr.length; j++) {
				sb.append(charArr[j]+1 > 'Z'? 'A' :
						(char)(charArr[j]+1));
			}
			if(i != n)
				sb.append("\n\n");
		}
		System.out.println(sb.toString());
	}

}

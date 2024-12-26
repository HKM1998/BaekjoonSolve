package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX30468 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())
				+ Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(st.nextToken());
		
		System.out.println((N * 4 - sum) >= 0 ? N * 4 - sum : 0);
	}

}

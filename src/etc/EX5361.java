package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX5361 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int a, b, c, d, e;
		double result;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			result = a * 350.34 + b * 230.90 + c * 190.55 + d * 125.30 + e * 180.90;
			
			System.out.printf("$%.2f\n" ,result);
		}
	}

}

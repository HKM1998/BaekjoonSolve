package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX30802 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tshirt = new int[6];

		for (int i = 0; i < 6; i++) {
			tshirt[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int tCount = 0;
		for (int i : tshirt) {
			tCount += i / T;
			tCount += i % T > 0 ? 1 : 0;
		}

		System.out.println(tCount);
		System.out.println(n / P + " " + n % P);
	}

}

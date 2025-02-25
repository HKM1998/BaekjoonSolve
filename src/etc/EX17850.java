package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX17850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] percent = new int[4];
		for(int i = 0; i < 4 ; i++) {
			percent[i] = Integer.parseInt(st.nextToken());
		}
		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[4][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(0);
			st.nextToken();
			String[] grade = st.nextToken().split("/");
			switch (op) {
			case 'L':
				arr[0][0] += Integer.parseInt(grade[0]);
				arr[0][1] += Integer.parseInt(grade[1]);
				break;
			case 'H':
				arr[1][0] += Integer.parseInt(grade[0]);
				arr[1][1] += Integer.parseInt(grade[1]);
				break;
			case 'P':
				arr[2][0] += Integer.parseInt(grade[0]);
				arr[2][1] += Integer.parseInt(grade[1]);
				break;
			case 'E':
				arr[3][0] += Integer.parseInt(grade[0]);
				arr[3][1] += Integer.parseInt(grade[1]);
				break;
			}
		}
		double result = 0;
		for (int i = 0; i < 4; i++) {
			result += percent[i] * ((double)arr[i][0]/(double)arr[i][1]);
		}
		
		System.out.println((int)Math.floor(result));
	}
}

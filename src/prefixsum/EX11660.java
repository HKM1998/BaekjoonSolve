package prefixsum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX11660 {
	static void mySolution() throws IOException {
		// 교재에 나오는 슈도 코드 및 풀이를 보지 않고 작성한 코드
		// 2차원 합 배열에 각 행단위 로 합배열을 생성하고
		// 이후 행단위 구간별 합계를 구한뒤 최종 합계를 구하도록 구현하였음
		// 시간 복잡도는 2N^2
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x1, y1, x2, y2;

		long[][] sumArray = new long[n + 1][n + 1];

		int count = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				sumArray[count][j] = sumArray[count][j - 1] + Integer.parseInt(st.nextToken());
			}
			count++;
		}

		for (int i = 0; i < m; i++) {
			long sum = 0;
			st = new StringTokenizer(bf.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j <= x2; j++) {
				sum += sumArray[j][y2] - sumArray[j][y1 - 1];
			}

			System.out.println(sum);
		}
	}

	static void bookSolution() throws IOException {
		// 교재의 풀이
		// 2차원에서의 합 배열의 각 위치 값은 배열(x, y)이라할때 
		// 합[x][y] = 합[x-1][y] + 합[x][y-1] -합[x-1][y-1] + 값[x][y]
		// 이므로 각 구간의 합은 최종 지점 - 해당 안되는 구간 + 중복 구역
		// 합[x1_x2][y1_y2] = 합[x2][y2] - 합[x1 - 1][y2] - 합[x2][y1 - 1] + 합[x1 - 1][y1 - 1];
		// 시간복잡도 2N^2
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x1, y1, x2, y2;

		int[][] inputArray = new int[n+1][n+1];
		int[][] sumArray = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				inputArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sumArray[i][j] = sumArray[i][j - 1] + sumArray[i - 1][j] - sumArray[i - 1][j - 1] + inputArray[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			long sum = sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][y1 - 1] + sumArray[x1 - 1][y1 - 1];
			System.out.println(sum);
		}
	}

	public static void main(String[] args) throws IOException {
		//mySolution();
		bookSolution();
	}

}

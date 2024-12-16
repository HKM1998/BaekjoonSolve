package twopointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX1940 {
	static void mySolution() throws IOException {
		// 풀이 보지 않고 작성한 코드
		// 정렬을 Arrays 를 사용하여 한다는 발상을 하지 못해서
		// 정렬없이 처리하는 코드를 작성함
		// 사용한 수를 배열에서 0으로 변경하고 0일 경우 계산에서 제외 하도록 함
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		int[] numArray = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		int startIndex = 0;
		int endIndex = 1;
		int count = 0;

		while (startIndex < n) {
			if (numArray[startIndex] == 0) {
				startIndex++;
				endIndex = startIndex + 1;
				continue;
			}
			if (endIndex >= n) {
				startIndex++;
				endIndex = startIndex + 1;
				continue;
			}
			if (numArray[endIndex] == 0) {
				endIndex++;
				continue;
			}
			if (numArray[startIndex] + numArray[endIndex] == m) {
				numArray[endIndex] = 0;
				startIndex++;
				endIndex = startIndex + 1;
				count++;
			} else
				endIndex++;
		}

		System.out.println(count);
	}

	static void bookSolution() throws IOException {
		// 교재 풀이
		// 정렬 후 배열의 시작위치/끝위치에서 각 값을 확인하면서 모이는 구조
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		int[] numArray = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArray);
		int startIndex = 0;
		int endIndex = n-1;
		int count = 0;

		while (startIndex < endIndex) {
			if(numArray[startIndex] + numArray[endIndex] < m) {
				startIndex++;
			}
			else if(numArray[startIndex] + numArray[endIndex] > m) {
				endIndex--;
			}
			else {
				count++;
				startIndex++;
				endIndex--;
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		mySolution();
		//bookSolution();
	}

}

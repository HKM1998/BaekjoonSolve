package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cardA = new int[N];

		for (int i = 0; i < N; i++) {
			cardA[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cardA);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			// 배열의 값중 key 값보다 큰 위치 - key 값과 같은 값중 가장 작은 값 위치 = key 값의 개수
			sb.append((getUpperBound(cardA, key) - getLowerBound(cardA, key)) + " ");
		}
		System.out.println(sb);
	}

	static int getLowerBound(int[] arr, int key) {

		int s = 0;
		int e = arr.length;
		while (s < e) {
			int mid = (e + s) / 2;
			// key 값보다 배열이 크거나 같아지는 시점의 위치값을 구함
			if (arr[mid] >= key) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		return s;
	}

	static int getUpperBound(int[] arr, int key) {

		int s = 0;
		int e = arr.length;
		while (s < e) {
			int mid = (e + s) / 2;
			// key 값보다 배열이 커지는 시점의 위치값을 구함
			if (arr[mid] > key) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return s;
	}
}

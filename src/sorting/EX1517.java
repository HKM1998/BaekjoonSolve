package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX1517 {
	static int[] A;
	static int[] temp;
	static long count;

	public static void main(String[] args) throws IOException {
		// 교재 로직과 동일
		// 자세한 설명은 EX2751 확인
		// 별도로 추가되는 부분은 swap 이 일어나는 수를 세는 방법이 전부다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N + 1];
		temp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		
		mergeSort(1, N);

		System.out.println(count);

	}

	static void mergeSort(int S, int E) {
		if (E - S < 1)
			return;
		int M = S + (E - S) / 2;

		mergeSort(S, M);
		mergeSort(M + 1, E);

		for (int i = S; i <= E; i++) {
			temp[i] = A[i];
		}

		int k = S;
		int index1 = S;
		int index2 = M + 1;
		while (index1 <= M && index2 <= E) {
			if (temp[index1] > temp[index2]) {
				// 뒤쪽 데이터의 값이 더 작은 경우
				// swap 이 일어난 것과 같으므로 현재 남아있는 앞의 데이터와 같은 수를 결과에 더함
				count = count + index2 - k;
				A[k] = temp[index2];
				index2++;
				k++;
			} else {
				A[k] = temp[index1];
				index1++;
				k++;
			}
		}
		while (index1 <= M) {
			A[k] = temp[index1];
			index1++;
			k++;
		}
		while (index2 <= E) {
			A[k] = temp[index2];
			index2++;
			k++;
		}
	}
}

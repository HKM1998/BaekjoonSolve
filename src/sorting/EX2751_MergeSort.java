package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX2751_MergeSort {
	static int[] S;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		S = new int[N+1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(1, N);

		for (int i = 1; i <= N; i++) {
			System.out.println(A[i]);
		}
	}

	static void mergeSort(int L, int R) {
		// 시작 위치와 종료위치가 같거나 시작위치가 더 나중이면 종료
		if (R - L < 1)
			return;
		
		// 시작위치와 종료위치의 평균을 중간 지점으로 지정(분할)
		int M = L + (R - L) / 2;
		
		// 시작 위치부터 중간 지점까지를 우선 재귀호출
		mergeSort(L, M);
		mergeSort(M + 1, R);

		// 임시 배열에 입력 수열 값 복사
		for (int i = L; i <= R; i++) {
			S[i] = A[i];
		}
		
		// 투포인터 개념으로 중간값 기준 앞 뒤 배열의 앞부터 작은 값을 본 배열에 대입
		// 작은 범위부터 실행되어 큰 범위로 실행됨
		int k = L; // k 저장 위치
		int index1 = L; // 포인터1
		int index2 = M + 1; // 포인터2
		while (index1 <= M && index2 <= R) {
			if (S[index1] > S[index2]) {
				A[k] = S[index2];
				k++;
				index2++;
			} else {
				A[k] = S[index1];
				k++;
				index1++;
			}
		}

		// 범위 내에서 저장되지 않은 임시 테이블 값을 본 배열에 반영
		while (index1 <= M) {
			A[k] = S[index1];
			k++;
			index1++;
		}
		while (index2 <= R) {
			A[k] = S[index2];
			k++;
			index2++;
		}

	}
}

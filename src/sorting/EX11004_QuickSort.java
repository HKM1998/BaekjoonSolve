package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX11004_QuickSort {
	static int[] A;

	public static void main(String[] args) throws IOException {
		// 퀵 정렬을 사용하는 경우
		// pivot 값을 한번 정렬하고 나면 pivot 의 위치는 결정나기때문에
		// pivot 이 찾는 위치와 동일한 값이 된다면 정렬을 그만 수행해도 됨
		// 시간복잡도 nlogn
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0, N - 1, K - 1);
		System.out.println(A[K - 1]);
	}

	static void quickSort(int start, int end, int K) {
		if (start < end) {
			// 중앙값 기준 정렬 1회 수행
			int pivot = partition(start, end);
			// pivot 값을 기준으로
			// 1. 찾아야하는 위치와 pivot 값이 같은 경우 위치가 결정되어 반복 종료
			// 2. 찾아야하는 위치가 pivot 값 보다 작은 경우 시작위치부터 pivot-1 을 종료 위치로 메서드 재호출
			// 3. 찾아야하는 위치가 pivot 값 보다 큰 경우 pivot+1 위치부터 종료위치로 메서드 재호출
			// 1~3 을 pivot 값이 찾아야하는 위치가 될때까지 반복 호출(재귀)
			if (pivot == K)
				return;
			else if (K < pivot)
				quickSort(start, pivot - 1, K);
			else
				quickSort(pivot + 1, end, K);

		}
	}

	static int partition(int start, int end) {
		// 값이 두개면 바로 정렬 수행 후 종료
		if (start + 1 == end) {
			if (A[start] > A[end])
				swap(start, end);
			return end;
		}
		// 퀵정렬의 기준 값은 중앙값을 기준으로 함
		int median = (end + start) / 2;
		int pivot;

		// 중앙값을 시작위치로 변경 후 정렬 수행
		swap(start, median);
		pivot = A[start];

		int i = start + 1;
		int j = end;

		// start 에서 시작해서 pivot 값보다 큰값의 위치
		// end 에서 시작해서 pivot 값보다 작은 값의 위치를
		// 찾아 두 값을 교체하고, 해당 로직을 start, end 가 만날때까지 수행
		while (i <= j) {
			while (i <= end && pivot > A[i])
				i++;
			while (j >= start && pivot < A[j])
				j--;
			if (i <= j)
				swap(i++, j--);
		}

		// pivot 값과 반복 종료 위치를 교체하면 pivot 값의 위치를 결정할 수 있음
		A[start] = A[j];
		A[j] = pivot;
		return j;
	}

	static void swap(int i, int j) {
		// 값 교체 메서드
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}

package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class EX10989 {

	public static void main(String[] args) throws IOException {
		// 메모리, 시간 문제로 Scanner, System.out 사용 불가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		// 최대 입력 정수가 10000이므로 자리수 최대 5
		radixSort(A, 5);
		for (int i = 0; i<n ; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void radixSort(int[] A, int max_size) {
		// 교재의 풀이법
		// CountingSort 계수정렬을 사용하여
		// 기수정렬 알고리즘의 각 자리의 인덱스를 결정하는데 사용 하였음
		// 실제로 큐를 사용하면 오히려 시간 복잡도에서 손해를 보기 때문인듯 함.
		int[] output = new int[A.length];
		int jarisu = 1;
		int count = 0;
		while (count != max_size) {
			int[] bucket = new int[10];
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) {
				output[bucket[(A[i] / jarisu) % 10] - 1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {
				A[i] = output[i];
			}
			jarisu *= 10;
			count++;
		}
	}

	static void myRadixSort(int[] A) {
		// 인터넷 자료 참고하여 만든 로직
		// 메모리초과 발생 큐 자체를 선언하여 만들어서 발생한 것으로 예상
		Queue<Integer>[] bucket = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			bucket[i] = new LinkedList<Integer>();
		}

		int[] temp = new int[A.length];
		int max = 0;
		int index = 0;

		for (int i = 0; i < A.length; i++) {
			max = max < A[i] ? A[i] : max;
		}
		max = (int) (Math.log10(max) + 1);

		for (int i = 0; i < A.length; i++) {
			temp[i] = A[i];
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < A.length; j++) {
				bucket[(int) (temp[j] / Math.pow(10, i) % 10)].add(temp[j]);
			}
			for (int j = 0; j < 10; j++) {
				while (!bucket[j].isEmpty()) {
					temp[index++] = bucket[j].poll();
				}
			}
			index = 0;
		}

		for (int i = 0; i < A.length; i++) {
			A[i] = temp[i];
		}
	}

}

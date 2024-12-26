package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EX2295 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> sumL = new ArrayList<Integer>();

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++)
			for (int j = i; j < N; j++) {
				sumL.add(A[i] + A[j]);
			}

		Arrays.sort(A);
		Collections.sort(sumL);

		for (int i = N - 1; i >= 0; i--)
			for (int j = i - 1; j >= 0; j--) {
				int sum = A[i] - A[j];

//				if (Collections.binarySearch(sumL, sum) >= 0) {
//					System.out.println(A[i]);
//					return;
//				}
				if (binarySearch(sumL, sum)) {
					System.out.println(A[i]);
					return;
				}
			}
	}

	static boolean binarySearch(List<Integer> list, int num) {
		boolean result = false;
		int s = 0;
		int e = list.size() - 1;
		while (s <= e) {
			int mid = (e + s) / 2;
			if (list.get(mid) < num) {
				s = mid + 1;
			} else if (list.get(mid) > num) {
				e = mid - 1;
			} else {
				result = true;
				break;
			}
		}
		return result;
	}

}

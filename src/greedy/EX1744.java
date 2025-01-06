package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class EX1744 {

	public static void main(String[] args) throws IOException {
		//bookAnswer();
		myAnswer();
	}

	static void myAnswer() throws IOException {
		// 교재 풀이 보기전 내 풀이
		// 경우의 수를 나누어 조건문 분기 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] < 0) {
				if (i + 1 < N && arr[i + 1] <= 0) {
					result += arr[i] * arr[i + 1];
					i++;
					continue;

				}
				result += arr[i];
			} else if (arr[i] > 0) {
				if ((i - N) % 2 == 0 && arr[i] > 1) {
					if (i + 1 < N) {
						result += arr[i] * arr[i + 1];
						i++;
						continue;
					}
				}
				result += arr[i];
			}
		}

		System.out.println(result);
	}

	static void bookAnswer() throws IOException {
		// 교재 정답
		// 구간별로 나눠서 우선순위 큐에 추가해서 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plusQ = new PriorityQueue<Integer>(Collections.reverseOrder()); // 역순
		PriorityQueue<Integer> minusQ = new PriorityQueue<Integer>();
		int count0 = 0, count1 = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 1)
				plusQ.add(num);
			else if(num < 0)
				minusQ.add(num);
			else if(num == 1)
				count1++;
			else
				count0++;
		}
		
		int result = 0;
		while(plusQ.size() > 1) {
			result += plusQ.poll() * plusQ.poll();
		}
		if(!plusQ.isEmpty())
			result += plusQ.poll();
		
		while(minusQ.size() > 1) {
			result += minusQ.poll() * minusQ.poll();
		}
		if(!minusQ.isEmpty())
			if(count0 == 0)
				result += minusQ.poll();
		result += count1;
		
		System.out.println(result);
	}
}

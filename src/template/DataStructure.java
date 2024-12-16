package template;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DataStructure {
	void queue() {
		// First In First Out(FIFO)
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// LinkedList 로 사용
		Queue<Integer> cardQ = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			cardQ.add(i); // 값 추가
		}

		while (cardQ.size() > 1) {
			cardQ.poll(); // 값 out 및 확인 (값만 확인할땐 peek 사용)
			cardQ.add(cardQ.poll());
		}

		System.out.println(cardQ.peek());
	}

	void priorityQueue() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// 우선순위 큐는 compare 메서드를 오버라이딩하여 우선순위 설정 가능
		// 아래 코드는 두 값의 절대값을 기준으로 설정 
		// 절댓값이 같은 경우 음수를 우선으로 정렬함
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o1);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1;
			else
				return first_abs - second_abs;
		});
		
		priorityQueue.add(n);

	}

	void stack() {
		// First In Last Out(FILO)
		int[] arr = new int[10];
		// Stack 클래스 사용
		Stack<Integer> stack = new Stack<Integer>();

		int count = 1;
		StringBuilder sb = new StringBuilder();
		boolean result = true;

		Arrays.fill(arr, 10);

		for (int i = 0; i < 10; i++) {
			if (arr[i] >= count) {
				while (arr[i] >= count) {
					// push 로 값 in
					stack.push(count);
					sb.append("+\n");
					count++;
				}
				sb.append("-\n");
				// pop 으로 top 의 값을 가져오며 out
				stack.pop();
			} else {
				int num = stack.pop();
				if (num > arr[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				sb.append("-\n");
			}
		}
		if (result)
			System.out.println(sb.toString());
	}
}

package needremind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX1526 {
	// 완전 탐색 문제인지 몰랏다...
	// 다른 풀이에는 실패하여 다른 답안 참고함
	// 여러 풀이를 추가 하였음
	static int result;

	static void A() {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = N; i > 0; i--) {
			int num = i;
			boolean flag = true;

			while (num != 0) {
				if (num % 10 == 4 || num % 10 == 7)
					num /= 10;
				else {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(i);
				break;
			}
		}
	}

	static void B() throws IOException {
		// 큐를 사용한 방법
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmp = in.readLine();
		int num = Integer.parseInt(tmp);
		Queue<Integer> q = new LinkedList<Integer>();
		int ans = 0;
		// 큐를 사용하여 4 or 7을 사용하는 모든 조합을 입력 숫자보다 낮은 값중에서 찾는다.
		// 큐에 저장되는 수는 항상 7이 포함된 값이 뒤로 감. 
		//	-> 마지막으로 반영된 값을 출력하는데 7이 가능하다면 무조건 마지막으로 반영됨
		if (num >= 4) {
			q.add(4);
			ans = 4;
		}
		if (num >= 7) {
			q.add(7);
			ans = 7;
		}
		while (!q.isEmpty()) {
			int tmp1 = q.peek();
			q.poll();
			tmp1 *= 10;
			if (tmp1 + 4 <= num) {
				ans = tmp1 + 4;
				q.add(ans);
			}
			if (tmp1 + 7 <= num) {
				ans = tmp1 + 7;
				q.add(ans);
			}
		}
		System.out.println(ans);
	}
	
	static void C() throws IOException {
		// 재귀 호출을 사용한 방법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		DFS(4,N);
		DFS(7,N);
		
		System.out.println(result);
	}
	
	static void DFS(int number, int N) {
		if (number > N) return;
		result = Math.max(result, number);
		DFS(number*10 + 4 , N);
		DFS(number*10 + 7 , N);
	}
	
	public static void main(String[] args) {

	}

}

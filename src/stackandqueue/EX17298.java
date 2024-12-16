package stackandqueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class EX17298 {

	static void myAnswer() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> numS = new Stack<Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int num = A[i];
			if (numS.isEmpty()) {
				for (int j = n - 1; j > i; j--) {
					numS.push(A[j]);
				}
			} else {
				while (count > 1) {
					numS.push(A[i + (count - 1)]);
					count--;
				}
			}
			count = 0;
			int nge = 0;
			if (numS.isEmpty())
				nge = -1;
			else {
				nge = numS.pop();
				count++;
				while (num > nge) {
					if (numS.isEmpty()) {
						nge = -1;
						break;
					}

					nge = numS.pop();
					count++;
				}
			}

			System.out.print(nge + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		// 스텍을 통해 입력 수열의 값을 쌓고 큰 값이 나올때까지만 꺼낸 후
		// 값을 출력하는 방식으로 풀이 했었는데 시간 초과가 발생함
		// 교재에 있는 방법으로
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] A = new int[n];
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0); // 스텍 최초값 대입

		// 입력 수열의 수만큼 반복
		for (int i = 1; i < n; i++) {
			// 스텍 top 의 값이 현재 수열보다 작은 경우 정답 배열의 탑 인덱스에 현재 수열의 값 저장
			// 정답 수열의 인덱스와 스텍에 저장되는 값을 매칭 시켜 답을 구함
			// if A[스텍 탑] 값이 현재 수열의 값보다 큰경우 수열 저장 후 다음 반복으로
			while (stack.isEmpty() == false && A[i] > A[stack.peek()]) {
				answer[stack.pop()] = A[i];
			}
			// 반복이 끝나면 -> 스텍에 들어 있는 값들과 현재 수열의 값 비교가 끝나면
			// 현재 수열의 인덱스를 스텍에 추가
			stack.push(i);
		}

		// 반복이 종료된 후 스텍에 남아있는 인덱스 값 = 수열의 왼쪽 인덱스에 자신보다 큰값이 없는 경우
		// -1 값 대입
		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : answer) {
			bw.write(i + " ");
		}
		bw.write("\n");
		bw.flush();
	}

}

package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX2251 {
	// 아래 6가지 케이스로 물이 이동함
	// A->B, A->C, B->A, B->C, C->A, C->B
	static int[] sender = { 0, 0, 1, 1, 2, 2 };
	static int[] receiver = { 1, 2, 0, 2, 0, 1 };
	static boolean[] answer;
	static boolean[][] visited;
	static int[] now = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());

		visited = new boolean[201][201];
		answer = new boolean[201];

		BFS();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= now[2]; i++) {
			if (answer[i])
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

	static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });	
		visited[0][0] = true; // A, B 값만 알면 C는 고정!
		answer[now[2]] = true; // 초기값은 고정으로 정답임!

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int A = node[0];
			int B = node[1];
			int C = now[2] - A - B;
			for (int i = 0; i < 6; i++) {
				// 다음 값은 위 6가지 케이스 중에 하나
				int[] next = { A, B, C };
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;

				// 보내는 값이 최댓값을 넘는 경우 최대 값을 담고 나머지는 기존 보내는 위치에 다시 반영
				if (next[receiver[i]] > now[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - now[receiver[i]];
					next[receiver[i]] = now[receiver[i]];
				}

				// 중복되는 값이 아닌경우에만 큐에 추가
				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					queue.add(next);
					if (next[0] == 0)
						answer[next[2]] = true;
				}
			}
		}
	}
}

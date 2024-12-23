package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX7576 {
	static int[][] A;
	static boolean[][] visited;
	static int N, M;
	static ArrayList<int[]> start;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int depth = 1;
	static int aTomatoCount = 0; // 다익은 토마토
	static int totalTomatoCount = 0; // 토마토 합계

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N, M 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[M][N];
		visited = new boolean[M][N];
		start = new ArrayList<>();

		// 각 위치 값 입력 -1, 0, 1
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == 0) {
					totalTomatoCount++;
				}
				else if (A[i][j] == 1) {
					start.add(new int[] { i, j });
					aTomatoCount++;
					totalTomatoCount++;
				}
			}
		}

		// BFS 실행
		BFS();
		
		// BFS 이후 0 값이 남은 경우 -1 아닌경우 depth
		/*
		 * int max = 0; pos: for (int i = 0; i < M; i++) { for (int j = 0; j < N; j++) {
		 * if(A[i][j] == 0) { max = 0; break pos; } if (A[i][j] > max) max = A[i][j]; }
		 * }
		 * 
		 * System.out.println(max - 1);
		 */
		// 익은 토마토 수가 BFS(토마토익히기) 이후 전체 토마토 수와 일치하는지 확인
		// 일치 안하는 경우 -1 출력 (안익은 토마토가 있으므로)
		if(aTomatoCount == totalTomatoCount)
			System.out.println(depth - 1);
		else
			System.out.println(-1);
	}

	static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 초기 1값을 모두 큐에 추가
		for (int[] i : start) {
			queue.add(i);
			visited[i[0]][i[1]] = true;
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x >= 0 && y >= 0 && x < M && y < N) {
					if(!visited[x][y] && A[x][y] == 0) {
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1;
						if(depth < A[x][y]) depth = A[x][y];
						aTomatoCount++;
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}

}

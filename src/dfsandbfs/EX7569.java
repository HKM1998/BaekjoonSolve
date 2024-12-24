package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX7569 {
	static int N, M, H;
	static int[][][] A;
	static boolean[][][] visited;
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int tomatoCount = 0, tomatoCount2 = 0;
	static ArrayList<int[]> start = new ArrayList<>();
	static int time = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		A = new int[H][N][M];
		visited = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 0) {
						tomatoCount++;
					} else if (temp == 1) {
						tomatoCount++;
						tomatoCount2++;
						start.add(new int[] { i, j, k });
					}
					A[i][j][k] = temp;
				}
			}
		}

		BFS();

		if (tomatoCount == tomatoCount2) {
			System.out.println(time - 1);
		} else {
			System.out.println(-1);
		}

	}

	static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int[] S : start) {
			queue.add(S);
			visited[S[0]][S[1]][S[2]] = true;
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 6; i++) {
				int z = now[0] + dh[i];
				int x = now[1] + dx[i];
				int y = now[2] + dy[i];
				if (z >= 0 && z < H && x >= 0 && x < N && y >= 0 && y < M) {
					if (!visited[z][x][y] && A[z][x][y] == 0) {
						visited[z][x][y] = true;
						A[z][x][y] = A[now[0]][now[1]][now[2]] +1;
						time = time < A[z][x][y]? A[z][x][y] : time;
						tomatoCount2++;
						queue.add(new int[] { z, x, y });
					}
				}
			}
		}
	}

}

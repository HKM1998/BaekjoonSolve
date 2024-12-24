package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX4179 {
	static char[][] A;
	static ArrayList<int[]> F = new ArrayList<int[]>();
	static int[][] FA;
	static int R, C;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] timeA;

	public static void main(String[] args) throws IOException {
		// R(행), C(열) 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 미로 정보 입력 #(벽), .(통로), J(지훈), F(불)
		A = new char[R][C];
		visited = new boolean[R][C];
		timeA = new int[R][C];

		int[] jPos = null;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char tmp = str.charAt(j);
				if (tmp == 'J') {
					jPos = new int[] { i, j };
				} else if (tmp == 'F') {
					F.add(new int[] { i, j });
				}
				A[i][j] = tmp;
			}
		}
		int time = BFS(jPos);

		if (time > 0)
			System.out.println(time);
		else
			System.out.println("IMPOSSIBLE");

	}

	static int BFS(int[] jihun) {
		if (jihun[0] == 0 || jihun[0] == R || jihun[1] == 0 || jihun[1] == C)
			return 1;
		Queue<int[]> Queue = new LinkedList<int[]>();
		Queue.add(jihun);
		timeA[jihun[0]][jihun[1]]++;
		for (int[] i : F) {
			Queue.add(i);
		}

		while (!Queue.isEmpty()) {
			int[] nowJ = Queue.poll();
			if (A[nowJ[0]][nowJ[1]] == 'F') {
				for (int i = 0; i < 4; i++) {
					int x = nowJ[0] + dx[i];
					int y = nowJ[1] + dy[i];
					if (x >= 0 && x < R && y >= 0 && y < C) {
						if (A[x][y] != '#' && A[x][y] != 'F') {
							A[x][y] = 'F';
							Queue.add(new int[] { x, y });
						}
					}
				}
			}
			else if (A[nowJ[0]][nowJ[1]] == 'J') {
				for (int i = 0; i < 4; i++) {
					int x = nowJ[0] + dx[i];
					int y = nowJ[1] + dy[i];
					if (x >= 0 && x < R && y >= 0 && y < C) {
						if (!visited[x][y] && A[x][y] == '.') {
							A[x][y] = 'J';
							timeA[x][y] = timeA[nowJ[0]][nowJ[1]] + 1;
							visited[x][y] = true;
							Queue.add(new int[] { x, y });
						}
					}
					else return timeA[nowJ[0]][nowJ[1]];
						
					
				}
			}
		}
		return -1;
	}
}
